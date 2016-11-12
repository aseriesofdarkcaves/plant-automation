package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.tinkerforge.BrickletMoisture;

/**
 * Created by aseriesofdarkcaves on 11.11.2016.
 */
public class MoistureSensor extends Sensor {

    public BrickletMoisture sensor;

    public MoistureSensor(String uid, Connection connection) {
        this.uid = uid;
        sensor = new BrickletMoisture(this.uid, connection.getIPConnection());
        connect(connection);
        initSensorListener();
    }

    @Override
    public void initSensorListener() {
        sensor.addMoistureListener(new BrickletMoisture.MoistureListener() {
            @Override
            public void moisture(int moisture) {
                // TODO: dicern value and conversion factor, if any
                System.out.println("Moisture: " + moisture);
            }
        });
    }
}
