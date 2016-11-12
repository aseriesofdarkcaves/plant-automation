package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.tinkerforge.AlreadyConnectedException;

import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public abstract class Sensor {

    public String uid;

    void connect(Connection connection) {
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AlreadyConnectedException e) {
            e.printStackTrace();
        }
    }
}
