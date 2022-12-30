package main.java.com.solvd.threadexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.vehiclefactory.Runner;

public class ThreadExample {
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	public static void main(String[] args) {
        RunnableA runnableA = new RunnableA();
        Thread thread1 = new Thread(runnableA);
        thread1.start();

       RunnableB runnableB = new RunnableB();
        Thread thread2 = new Thread(runnableB);
        thread2.start();
        
        ConnectionPoolA pool = new ConnectionPoolA(5);

        ExecutorService executor = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 7; i++) {
            executor.execute(() -> {
                try {
                    Connection connection = pool.getConnection();
                    try {
                        connection.executeQuery();
                    } finally {
                        pool.releaseConnection(connection);
                    }
                } catch (InterruptedException e) {
					logger.info("Connection Failed: "+ e);
                }
            });
        }

        executor.shutdown();

        pool.close();


	}

}
