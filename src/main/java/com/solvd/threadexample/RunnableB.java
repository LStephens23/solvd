package main.java.com.solvd.threadexample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.vehiclefactory.Runner;

public class RunnableB implements Runnable{
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	@Override
	public void run() {
		logger.info("Running B");
	}
}