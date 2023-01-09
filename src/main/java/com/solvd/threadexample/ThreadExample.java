package main.java.com.solvd.threadexample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadExample {
	private static Logger logger = LogManager.getLogger(ThreadExample.class.getName());

	public static void main(String[] args) {
		RunnableA runnableA = new RunnableA();
		Thread thread1 = new Thread(runnableA);
		thread1.start();

		RunnableB runnableB = new RunnableB();
		Thread thread2 = new Thread(runnableB);
		thread2.start();

		ConnectionPoolA poolA = new ConnectionPoolA(5);

		for (int i = 0; i < 7; i++) {
			try {
				Connection connection = poolA.getConnection();
				try {
					connection.executeQuery();
				}finally {
					//
				}
			} catch (InterruptedException e) {
				logger.info("Connection Failed: "+ e);
			}
		}

		poolA.close();

	}

}
