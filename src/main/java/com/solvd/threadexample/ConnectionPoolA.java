package main.java.com.solvd.threadexample;

import java.util.concurrent.*;

public class ConnectionPoolA {
    private final LinkedBlockingQueue<Connection> availableConnections;

    public ConnectionPoolA(int poolSize) {
        availableConnections = new LinkedBlockingQueue<Connection>(poolSize);
		// add connections to the queue
        for (int i = 0; i < poolSize; i++) {
            availableConnections.add(new Connection());
        }
    }

    public synchronized Connection getConnection() throws InterruptedException{
        Connection connection = availableConnections.take();
        return connection;
    }

    public void close() {
        for (Connection connection : availableConnections) {
            connection.close();
        }
    }
}

