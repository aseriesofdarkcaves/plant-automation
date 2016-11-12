package com.asodc.tinkerforge;

import com.tinkerforge.*;
import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class Tinkerforge {

    private static final String HOST = "PlantAutomation";
    private static final int PORT = 4223;
    private static final String TEMPERATURE_SENSOR_UID = "zky";
    private static final long CALLBACK_PERIOD = 1000;

    private static IPConnection ipConnection;
    private static BrickletTemperature temperatureSensor;

    public static void main(String[] args) {
        initIPConnection();
        initTemperatureSensor();
        connect();
        initTemperatureSensorListener();
        setCallbackPeriod(CALLBACK_PERIOD);
        loop();
    }

    private static void loop() {
        while(true) {}
    }

    private static void setCallbackPeriod(long callbackPeriod) {
        try {
            temperatureSensor.setTemperatureCallbackPeriod(callbackPeriod);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (NotConnectedException e) {
            e.printStackTrace();
        }
    }

    private static void initTemperatureSensorListener() {
        temperatureSensor.addTemperatureListener(new BrickletTemperature.TemperatureListener() {
            public void temperature(short temperature) {
                System.out.println("Temperature: " + temperature / 100.0 + " °C");
            }
        });
    }

    private static void connect() {
        try {
            ipConnection.connect(HOST, PORT);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AlreadyConnectedException e) {
            e.printStackTrace();
        }
    }

    private static void initTemperatureSensor() {
        temperatureSensor = new BrickletTemperature(TEMPERATURE_SENSOR_UID, ipConnection);
    }

    private static void initIPConnection() {
        ipConnection = new IPConnection();
    }
}
