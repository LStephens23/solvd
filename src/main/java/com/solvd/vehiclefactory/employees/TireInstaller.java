package main.java.com.solvd.vehiclefactory.employees;

import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.vehiclefactory.Runner;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;

public class TireInstaller extends Employee{
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	private int goodInstallRating;

	public TireInstaller(String firstName, String lastName, String employeeID, String department, GregorianCalendar hireDate, float hourlyRate, int goodInstallRating) {
		super(firstName,lastName,employeeID,department,hireDate, hourlyRate);
		this.setGoodInstallRating(goodInstallRating);
	}
	@Override
	public void doWork(Vehicle v) {
		logger.info(this.getFirstName() + " " + this.getLastName() + " Installs Tires.");
	}
	public int getGoodInstallRating() {
		return goodInstallRating;
	}

	public void setGoodInstallRating(int goodInstallRating) {
		this.goodInstallRating = goodInstallRating;
	}




}
