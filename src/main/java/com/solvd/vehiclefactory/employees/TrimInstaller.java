package main.java.com.solvd.vehiclefactory.employees;

import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.vehiclefactory.Runner;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;

public class TrimInstaller extends Employee{
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	private int quickHandsRating;

	public TrimInstaller(String firstName, String lastName, String employeeID, String department, GregorianCalendar hireDate, float hourlyRate, int quickHandsRating) {
		super(firstName,lastName,employeeID,department,hireDate,hourlyRate);
		this.setQuickHandsRating(quickHandsRating);
	}
	
	@Override
	public void doWork(Vehicle v) {
		logger.info(this.getFirstName() + " " + this.getLastName() + " Installs Trim.");
	}
	public int getQuickHandsRating() {
		return quickHandsRating;
	}

	public void setQuickHandsRating(int quickHandsRating) {
		this.quickHandsRating = quickHandsRating;
	}




}
