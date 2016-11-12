package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.tinkerforge.AlreadyConnectedException;

import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
abstract class Sensor implements SensorListener {

    String uid;
    Connection connection;

    Sensor(String uid, Connection connection) {
        this.uid = uid;
        this.connection = connection;
    }

    void connect(Connection connection) throws IOException, AlreadyConnectedException {
        connection.connect();
    }

    public String getUID() {
        return uid;
    }
}
