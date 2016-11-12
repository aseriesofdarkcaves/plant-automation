package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.tinkerforge.BrickletTemperature;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class TemperatureSensor extends Sensor {

    public BrickletTemperature sensor;

    public TemperatureSensor(String uid, Connection connection) {
        this.uid = uid;
        sensor = new BrickletTemperature(this.uid, connection.getIPConnection());
        connect(connection);
        initSensorListener();
    }

    @Override
    public void initSensorListener() {
        sensor.addTemperatureListener(new BrickletTemperature.TemperatureListener() {
            @Override
            public void temperature(short temperature) {
                System.out.println("Temperature: " + temperature / 100.0 + " °C");
            }
        });
    }
}
