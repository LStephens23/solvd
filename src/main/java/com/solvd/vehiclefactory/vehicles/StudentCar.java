package main.java.com.solvd.vehiclefactory.vehicles;

import main.java.com.solvd.vehiclefactory.exceptions.InvalidColorChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidMakeChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidModelChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidSeriesChoiceException;

public class StudentCar extends Car {
	
	private static long numStudentCarsProduced;

	public StudentCar (String color, String make, String model, String series) throws InvalidMakeChoiceException, InvalidModelChoiceException, InvalidSeriesChoiceException, InvalidColorChoiceException{
		
		super(color, make, model, series);
		this.setStatus("**Student Instruction Car Waiting to Begin Production**");
		this.setMaxCapacity(2);
		this.setNumWheels(2);
		numStudentCarsProduced++;
	}
	
	public static long getNumStudentCarsProduced() {
		return numStudentCarsProduced;
	}

	public static void setNumStudentCarsProduced(long numStudentCarsProduced) {
		StudentCar.numStudentCarsProduced = numStudentCarsProduced;
	}

}
