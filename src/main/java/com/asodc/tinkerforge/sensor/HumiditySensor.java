package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.tinkerforge.BrickletHumidity;

/**
 * Created by aseriesofdarkcaves on 11.11.2016.
 */
public class HumiditySensor extends Sensor {

    public BrickletHumidity sensor;

    public HumiditySensor(String uid, Connection connection) {
        this.uid = uid;
        sensor = new BrickletHumidity(this.uid, connection.getIPConnection());
        connect(connection);
        initSensorListener();
    }

    @Override
    public void initSensorListener() {
        sensor.addHumidityListener(new BrickletHumidity.HumidityListener() {
            @Override
            public void humidity(int humidity) {
                // TODO: dicern value and conversion factor, if any
                System.out.println("Humidity: " + humidity);
            }
        });
    }
}
