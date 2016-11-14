package com.asodc.tinkerforge.service;

import com.tinkerforge.*;

import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class TestHumidity {

    private static final String HOST = "PlantAutomation";
    private static final int PORT = 4223;
    private static final String SENSOR_UID = "xwj";

    private static IPConnection ipConnection;
    private static BrickletHumidity humiditySensor;

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
        humiditySensor.addHumidityListener(new BrickletHumidity.HumidityListener() {
            @Override
            public void humidity(int humidity) {
                System.out.println("Humidity: " + humidity);
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
        humiditySensor = new BrickletHumidity(SENSOR_UID, ipConnection);
    }

    private static void initIPConnection() {
        ipConnection = new IPConnection();
    }
}
