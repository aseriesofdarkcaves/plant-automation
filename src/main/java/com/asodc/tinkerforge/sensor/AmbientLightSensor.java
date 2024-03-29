package com.asodc.tinkerforge.sensor;

import com.asodc.tinkerforge.connection.Connection;
import com.tinkerforge.AlreadyConnectedException;
import com.tinkerforge.BrickletAmbientLightV2;

import java.io.IOException;

public class AmbientLightSensor extends Sensor {
    private BrickletAmbientLightV2 sensor;

    public AmbientLightSensor(String uid, Connection connection) throws IOException, AlreadyConnectedException {
        super(uid, connection);
        sensor = new BrickletAmbientLightV2(this.uid, this.connection.getIPConnection());
        connect(connection);
        initSensorListener();
    }

    @Override
    public void initSensorListener() {
        sensor.addIlluminanceListener(new BrickletAmbientLightV2.IlluminanceListener() {
            @Override
            public void illuminance(long illuminance) {
                System.out.println("Illuminance: " + illuminance / 100.0 + " Lux");
            }
        });
    }
}
