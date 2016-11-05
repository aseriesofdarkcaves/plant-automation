package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.tinkerforge.BrickletTemperature;
import com.tinkerforge.IPConnection;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class TemperatureSensor implements TinkerforgeSensor {

    public String uid;
    public BrickletTemperature sensor;

    public TemperatureSensor(String uid, Connection connection) {
        this.uid = uid;
        
    }

}
