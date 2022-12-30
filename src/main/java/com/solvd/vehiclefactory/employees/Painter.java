package main.java.com.solvd.vehiclefactory.employees;

import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.vehiclefactory.IPaint;
import main.java.com.solvd.vehiclefactory.Runner;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;

public class Painter extends Employee implements IWork, IPaint {
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	private int accuracyRating;

	public Painter(String firstName, String lastName, String employeeID, String department, GregorianCalendar hireDate, float hourlyRate, int accuracyRating) {
		super(firstName,lastName,employeeID,department,hireDate,hourlyRate);
		this.setAccuracyRating(accuracyRating);
	}
	@Override
	public void doWork(Vehicle v) {
		paintColor(v);

	}
	public int getAccuracyRating() {
		return accuracyRating;
	}

	public void setAccuracyRating(int accuracyRating) {
		this.accuracyRating = accuracyRating;
	}

	@Override
	public void paintColor(Vehicle v) {

		logger.info(this.toString() + " paints a final coat of "+ v.getColor() + ".");

	}
}
