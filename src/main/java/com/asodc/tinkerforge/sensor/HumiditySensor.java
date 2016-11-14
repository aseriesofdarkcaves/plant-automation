package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.tinkerforge.AlreadyConnectedException;
import com.tinkerforge.BrickletHumidity;

import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 11.11.2016.
 */
public class HumiditySensor extends Sensor {

    private BrickletHumidity sensor;

    public HumiditySensor(String uid, Connection connection) throws IOException, AlreadyConnectedException {
        super(uid, connection);
        sensor = new BrickletHumidity(this.uid, this.connection.getIPConnection());
        connect(connection);
        initSensorListener();
    }

    @Override
    public void initSensorListener() {
        sensor.addHumidityListener(new BrickletHumidity.HumidityListener() {
            @Override
            public void humidity(int humidity) {
                // TODO: dicern value and conversion factor, if any
                System.out.println("Humidity: " + humidity / 10.0 + " %RH");
            }
        });
    }
}
