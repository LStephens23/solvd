package main.java.com.solvd.vehiclefactory.employees;

import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.vehiclefactory.Runner;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;


public class Inspector extends Employee{
	
	private static Logger logger = LogManager.getLogger(Runner.class.getName());
	
	private int goodEyeRating;

	public Inspector(String firstName, String lastName, String employeeID, String department, GregorianCalendar hireDate, float hourlyRate, int goodEyeRating) {
		super(firstName,lastName,employeeID,department,hireDate, hourlyRate);
		this.setGoodEyeRating(goodEyeRating);
	}
	
	@Override
	public void doWork(Vehicle v) {
		logger.info(this.getFirstName() + " " + this.getLastName() + " Inspects.");
	}

	public int getGoodEyeRating() {
		return goodEyeRating;
	}

	public void setGoodEyeRating(int goodEyeRating) {
		this.goodEyeRating = goodEyeRating;
	}




}
