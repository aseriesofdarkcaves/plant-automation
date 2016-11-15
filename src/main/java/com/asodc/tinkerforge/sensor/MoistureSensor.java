package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.tinkerforge.AlreadyConnectedException;
import com.tinkerforge.BrickletMoisture;

import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 11.11.2016.
 */
public class MoistureSensor extends Sensor {

    private BrickletMoisture sensor;

    public MoistureSensor(String uid, Connection connection) throws IOException, AlreadyConnectedException {
        super(uid, connection);
        sensor = new BrickletMoisture(this.uid, this.connection.getIPConnection());
        connect(connection);
        initSensorListener();
    }

    @Override
    public void initSensorListener() {
        sensor.addMoistureListener(new BrickletMoisture.MoistureListener() {
            @Override
            public void moisture(int moisture) {
                System.out.println("Moisture: " + moisture + " Units");
            }
        });
    }
}
