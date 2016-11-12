package com.asodc.tinkerforge.connection;

import com.tinkerforge.AlreadyConnectedException;
import com.tinkerforge.IPConnection;

import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class Connection {

    private String host;
    private int port;
    private IPConnection ipConnection;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
        this.ipConnection = new IPConnection();
    }

    public IPConnection getIPConnection() {
        return ipConnection;
    }

    public void connect() {
        try {
            ipConnection.connect(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AlreadyConnectedException e) {
            e.printStackTrace();
        }
    }
}
