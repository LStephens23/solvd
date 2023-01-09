package main.java.com.solvd.threadexample;

import java.util.concurrent.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPoolB {

	private static Logger logger = LogManager.getLogger(ThreadExample.class.getName());

	private final LinkedBlockingQueue<Connection> availableConnections;

	public ConnectionPoolB(int poolSize) {
		availableConnections = new LinkedBlockingQueue<Connection>(poolSize);
		// add connections to the queue
		for (int i = 0; i < poolSize; i++) {
			availableConnections.add(new Connection());
		}
	}

	public synchronized CompletableFuture<Connection> getConnection() {
		return CompletableFuture.supplyAsync(() -> {
			try {
				return availableConnections.take();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				logger.error("Connection Failed: "+ e);
				//supplyAsync doesn't allow for checked 
				//exceptions to be thrown so we wrap it in
				//a runtime exception
				throw new RuntimeException(e);
			}
		});
	}

	public CompletionStage<Void> close() {
		return CompletableFuture.runAsync(() -> {
			for (Connection connection : availableConnections) {
				connection.close();
			}
		});
	}
}

