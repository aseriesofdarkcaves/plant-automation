package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.tinkerforge.BrickletAmbientLightV2;

/**
 * Created by aseriesofdarkcaves on 11.11.2016.
 */
public class AmbientLightSensor extends Sensor {

    private BrickletAmbientLightV2 sensor;

    public AmbientLightSensor(String uid, Connection connection) {
        super(uid, connection);
        this.sensor = new BrickletAmbientLightV2(this.uid, this.connection.getIPConnection());
        connect(connection);
        initSensorListener();
    }

    @Override
    public void initSensorListener() {
        sensor.addIlluminanceListener(new BrickletAmbientLightV2.IlluminanceListener() {
            @Override
            public void illuminance(long illuminance) {
                // TODO: dicern value and conversion factor, if any
                System.out.println("Illuminance: " + illuminance);
            }
        });
    }
}
