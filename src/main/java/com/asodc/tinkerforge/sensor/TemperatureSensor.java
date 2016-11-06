package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.tinkerforge.AlreadyConnectedException;
import com.tinkerforge.BrickletTemperature;

import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class TemperatureSensor implements TinkerforgeSensor {

    public String uid;
    public BrickletTemperature sensor;

    public TemperatureSensor(String uid, Connection connection) {
        this.uid = uid;
        sensor = new BrickletTemperature(this.uid, connection.getIPConnection());
        connect(connection);
    }

    private void connect(Connection connection) {
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AlreadyConnectedException e) {
            e.printStackTrace();
        }
    }

}
