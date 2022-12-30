package main.java.com.solvd.vehiclefactory.vehicles;


import main.java.com.solvd.vehiclefactory.exceptions.InvalidColorChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidMakeChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidModelChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidSeriesChoiceException;

public class Car extends Vehicle{
	
	private int maxCapacity;
	private int numWindows;
	private int numWheels;
	private static long numCarsProduced;


	public Car (String color, String make, String model, String series) throws InvalidMakeChoiceException, InvalidModelChoiceException, InvalidSeriesChoiceException, InvalidColorChoiceException{
		
		super(color, make, model, series, "**Car Waiting to Begin Production**");
		this.setMaxCapacity(5);
		this.setNumWindows(6);
		this.setNumWheels(1);
		numCarsProduced++;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}


	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}


	public int getNumWindows() {
		return numWindows;
	}


	public void setNumWindows(int numWindows) {
		this.numWindows = numWindows;
	}


	public int getNumWheels() {
		return numWheels;
	}


	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}


	public static long getNumCarsProduced() {
		return numCarsProduced;
	}


	public static void setNumCarsProduced(long numCarsProduced) {
		Car.numCarsProduced = numCarsProduced;
	}


	
}
