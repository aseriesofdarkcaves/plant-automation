package com.asodc.tinkerforge.service;

import com.tinkerforge.*;

import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class TestTemperature {

    private static final String HOST = "PlantAutomation";
    private static final int PORT = 4223;
    private static final String SENSOR_UID = "zky";

    private static IPConnection ipConnection;
    private static BrickletTemperature temperatureSensor;

    public static void main(String[] args) {
        initIPConnection();
        initSensor();
        connect();
        initSensorListener();
        startService();
    }

    private static void startService() {
        while (true) {
            // TODO: handle Exceptions gracefully
        }
    }

    private static void initSensorListener() {
        temperatureSensor.addTemperatureListener(new BrickletTemperature.TemperatureListener() {
            @Override
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

    private static void initSensor() {
        temperatureSensor = new BrickletTemperature(SENSOR_UID, ipConnection);
    }

    private static void initIPConnection() {
        ipConnection = new IPConnection();
    }
}
