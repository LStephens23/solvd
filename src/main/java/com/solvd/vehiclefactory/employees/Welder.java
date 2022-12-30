package main.java.com.solvd.vehiclefactory.employees;

import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.vehiclefactory.Runner;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;

public class Welder extends Employee{
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	private int safetyRating;

	public Welder(String firstName, String lastName, String employeeID, String department, GregorianCalendar hireDate, float hourlyRate, int safetyRating) {
		super(firstName,lastName,employeeID,department,hireDate, hourlyRate);
		this.setSafetyRating(safetyRating);
	}
	@Override
	public void doWork(Vehicle v) {
		logger.info(this.getFirstName() + " " + this.getLastName() + " Welds.");
	}

	public int getSafetyRating() {
		return safetyRating;
	}

	public void setSafetyRating(int safetyRating) {
		this.safetyRating = safetyRating;
	}

}