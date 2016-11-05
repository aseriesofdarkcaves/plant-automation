package com.asodc.tinkerforge.connection;

import com.tinkerforge.IPConnection;

/**
 * Created by aseriesofdarkcaves on 05.11.2016.
 */
public class Connection {

    public String host;
    public int port;
    public IPConnection connection;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
        connection = new IPConnection();
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public IPConnection getConnection() {
        return connection;
    }

}
