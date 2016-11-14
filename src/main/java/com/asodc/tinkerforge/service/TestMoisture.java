package com.asodc.tinkerforge.service;

import com.tinkerforge.*;

import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class TestMoisture {

    private static final String HOST = "PlantAutomation";
    private static final int PORT = 4223;
    private static final String SENSOR_UID = "zU3";

    private static IPConnection ipConnection;
    private static BrickletMoisture moistureSensor;

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
        moistureSensor.addMoistureListener(new BrickletMoisture.MoistureListener() {
            @Override
            public void moisture(int moisture) {
                System.out.println("Moisture: " + moisture);
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
        moistureSensor = new BrickletMoisture(SENSOR_UID, ipConnection);
    }

    private static void initIPConnection() {
        ipConnection = new IPConnection();
    }
}
