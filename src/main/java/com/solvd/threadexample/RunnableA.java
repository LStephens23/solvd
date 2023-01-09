package main.java.com.solvd.threadexample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableA implements Runnable{
	private static Logger logger = LogManager.getLogger(ThreadExample.class.getName());

	@Override
	public void run() {
		logger.info("Running A");
	}
}
