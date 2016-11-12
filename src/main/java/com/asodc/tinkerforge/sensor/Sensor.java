package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.asodc.tinkerforge.listener.SensorListener;
import com.tinkerforge.AlreadyConnectedException;
import com.tinkerforge.Device;

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

    void connect(Connection connection) {
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AlreadyConnectedException e) {
            e.printStackTrace();
        }
    }

    public String getUID() {
        return uid;
    }
}
