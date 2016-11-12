package com.asodc.tinkerforge.connection;

import com.tinkerforge.AlreadyConnectedException;
import com.tinkerforge.IPConnection;

import java.io.IOException;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class Connection {

    public String host;
    public int port;
    public IPConnection ipConnection;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
        ipConnection = new IPConnection();
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public IPConnection getIPConnection() {
        return ipConnection;
    }

    public void connect() throws IOException, AlreadyConnectedException {
        ipConnection.connect(host, port);
    }
}
