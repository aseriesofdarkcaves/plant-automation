package com.asodc.tinkerforge;

import com.asodc.tinkerforge.connection.Connection;
import com.asodc.tinkerforge.sensor.TemperatureSensor;

/**
 * Created by aseriesofdarkcaves on 06/11/2016.
 */
public class DavesClass {

    private static final String HOST = "localhost";
    private static final int PORT = 0;
    private static final String TEMPERATURE_UID= "qnV";

    public static void main(String[] args) {
        Connection connection = new Connection(HOST, PORT);
        TemperatureSensor temperature = new TemperatureSensor(TEMPERATURE_UID, connection);

    }
}
