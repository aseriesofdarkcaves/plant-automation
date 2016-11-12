package com.asodc.tinkerforge.service;

import com.asodc.tinkerforge.connection.Connection;
import com.asodc.tinkerforge.sensor.AmbientLightSensor;
import com.asodc.tinkerforge.sensor.HumiditySensor;
import com.asodc.tinkerforge.sensor.MoistureSensor;
import com.asodc.tinkerforge.sensor.TemperatureSensor;

/**
 * Created by aseriesofdarkcaves on 06/11/2016.
 */
public class PlantAutomation {

    private static final String HOST = "PlantAutomation";
    private static final int PORT = 4223;
    private static final String AMBIENT_LIGHT_SENSOR_UID = "yC3";
    private static final String HUMIDITY_SENSOR_UID = "xwj";
    private static final String MOISTURE_SENSOR_UID = "zU3";
    private static final String TEMPERATURE_SENSOR_UID = "zky";

    public static void main(String[] args) {
        attachTemperature();
        attachHumidity();
        attachMoisture();
        attachAmbientLight();
        loop();
    }

    private static void attachAmbientLight() {
        Connection ambientLightConnection = new Connection(HOST, PORT);
        AmbientLightSensor ambientLightSensor = new AmbientLightSensor(AMBIENT_LIGHT_SENSOR_UID, ambientLightConnection);
    }

    private static void attachHumidity() {
        Connection humidityConnection = new Connection(HOST, PORT);
        HumiditySensor humiditySensor = new HumiditySensor(HUMIDITY_SENSOR_UID, humidityConnection);
    }

    private static void attachMoisture() {
        Connection moistureConnection = new Connection(HOST, PORT);
        MoistureSensor moistureSensor = new MoistureSensor(MOISTURE_SENSOR_UID, moistureConnection);
    }

    private static void attachTemperature() {
        Connection temperatureConnection = new Connection(HOST, PORT);
        TemperatureSensor temperature = new TemperatureSensor(TEMPERATURE_SENSOR_UID, temperatureConnection);
    }

    private static void loop() {
        while (true) {}
    }
}
