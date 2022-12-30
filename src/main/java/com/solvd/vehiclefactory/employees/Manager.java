package main.java.com.solvd.vehiclefactory.employees;

import java.util.GregorianCalendar;
import org.apache.logging.log4j.*;

import main.java.com.solvd.vehiclefactory.Runner;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidRateChangeException;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;


public class Manager extends Employee implements IManage{
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	private int perfectCarRating;

	public Manager(String firstName, String lastName, String employeeID, String department, GregorianCalendar hireDate,float hourlyRate, int perfectCarRating) {
		super(firstName,lastName,employeeID,department,hireDate,hourlyRate);
		this.setPerfectCarRating(perfectCarRating);
	}
	
	@Override
	public void doWork(Vehicle v) {
		logger.info(this.getFirstName() + " " + this.getLastName() + " Manages Employees.");
	}
	
	@Override
	public void setNewHourlyRate(Employee e, float newRate) throws InvalidRateChangeException {
		float oldRate = e.getHourlyRate();
		if (newRate <= oldRate) {
			String message = "New Rate must be higher than old rate of " + oldRate;
			throw new InvalidRateChangeException(message);
		}else {
		e.setHourlyRate(newRate);
			logger.info(e.toString() 
				+ "'s hourly rate has been changed from " 
				+ oldRate + " to " + newRate + " by " 
				+ this.toString() + ".");
		}
	}
	
	@Override
	public void setNewStation(Employee e, String newDept) {
		String oldDept = e.getDepartment();
		e.setDepartment(newDept);
		logger.info(e.toString() 
				+ "'s department has been changed from " 
				+ oldDept + " to " + newDept + " by " 
				+ this.toString() + ".");
		
	}


	public int getPerfectCarRating() {
		return perfectCarRating;
	}

	public void setPerfectCarRating(int perfectCarRating) {
		this.perfectCarRating = perfectCarRating;
	}

}
