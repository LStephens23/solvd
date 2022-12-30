package main.java.com.solvd.vehiclefactory.employees;

import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.vehiclefactory.Runner;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;

public class Stamper extends Employee{
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	private int noWasteRating;

	public Stamper(String firstName, String lastName, String employeeID, String department, GregorianCalendar hireDate, float hourlyRate, int noWasteRating) {
		super(firstName,lastName,employeeID,department,hireDate, hourlyRate);
		this.setNoWasteRating(noWasteRating);
	}
	
	@Override
	public void doWork(Vehicle v) {
		logger.info(this.getFirstName() + " " + this.getLastName() + " Stamps Metal.");
	}
	public int getNoWasteRating() {
		return noWasteRating;
	}

	public void setNoWasteRating(int noWasteRating) {
		this.noWasteRating = noWasteRating;
	}


}
