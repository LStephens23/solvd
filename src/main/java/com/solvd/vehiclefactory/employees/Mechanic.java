package main.java.com.solvd.vehiclefactory.employees;

import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.vehiclefactory.Runner;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;

public class Mechanic extends Employee{
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	private int engineerRating;

	public Mechanic(String firstName, String lastName, String employeeID, String department, GregorianCalendar hireDate, float hourlyRate, int engineerRating) {
		super(firstName,lastName,employeeID,department,hireDate,hourlyRate);
		this.setEngineerRating(engineerRating);
	}
	@Override
	public void doWork(Vehicle v) {
		logger.info(this.getFirstName() + " " + this.getLastName() + " Mechanizes.");
	}
	public int getEngineerRating() {
		return engineerRating;
	}

	public void setEngineerRating(int engineerRating) {
		this.engineerRating = engineerRating;
	}



}
