package com.asodc.tinkerforge;

import com.tinkerforge.*;
import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class Tinkerforge {

    private static final String HOST = "localhost";
    private static final int PORT = 4223;
    private static final String UID = "qnV";
    private static final long CALLBACK_PERIOD = 1000;

    private static IPConnection ipConnection;
    private static BrickletTemperature temperatureSensor;

    public static void main(String[] args) {
        initIPConnection();
        initTemperatureSensor();
        connect();
        initTemperatureSensorListener();
        initTerminationListener();
        setCallbackPeriod(CALLBACK_PERIOD);
        loop();
    }

    private static void loop() {
        while(true) {}
    }

    private static void initTerminationListener() {
        // TODO: add keyboard listener for when user hits ESC to kill program
    }

    private static void setCallbackPeriod(long callbackPeriod) {
        try {
            temperatureSensor.setTemperatureCallbackPeriod(CALLBACK_PERIOD);
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
        temperatureSensor = new BrickletTemperature(UID, ipConnection);
    }

    private static void initIPConnection() {
        ipConnection = new IPConnection();
    }
}
