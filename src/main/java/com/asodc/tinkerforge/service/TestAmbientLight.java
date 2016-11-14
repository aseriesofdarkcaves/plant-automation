package com.asodc.tinkerforge.service;

import com.tinkerforge.*;

import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class TestAmbientLight {

    private static final String HOST = "PlantAutomation";
    private static final int PORT = 4223;
    private static final String SENSOR_UID = "yC3";

    private static IPConnection ipConnection;
    private static BrickletAmbientLightV2 ambientLightSensor;

    public static void main(String[] args) throws TimeoutException, NotConnectedException {
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
        ambientLightSensor.addIlluminanceListener(new BrickletAmbientLightV2.IlluminanceListener() {
            @Override
            public void illuminance(long illuminance) {
                System.out.println("Illuminance: " + illuminance / 100.0 + " Lux");
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
        ambientLightSensor = new BrickletAmbientLightV2(SENSOR_UID, ipConnection);
    }

    private static void initIPConnection() {
        ipConnection = new IPConnection();
    }
}
