package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.tinkerforge.AlreadyConnectedException;
import com.tinkerforge.BrickletTemperature;

import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class TemperatureSensor extends Sensor {

    private BrickletTemperature sensor;

    public TemperatureSensor(String uid, Connection connection) throws IOException, AlreadyConnectedException {
        super(uid, connection);
        sensor = new BrickletTemperature(this.uid, this.connection.getIPConnection());
        connect(connection);
        initSensorListener();
    }

    @Override
    public void initSensorListener() {
        sensor.addTemperatureListener(new BrickletTemperature.TemperatureListener() {
            @Override
            public void temperature(short temperature) {
                System.out.println("Temperature: "+ temperature / 100.0 + " °C");
            }
        });
    }
}
