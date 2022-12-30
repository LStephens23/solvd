package main.java.com.solvd.vehiclefactory.vehicles;

import main.java.com.solvd.vehiclefactory.exceptions.InvalidColorChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidMakeChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidModelChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidSeriesChoiceException;

public class Motorcycle extends Vehicle{

	private int numHandlebars;
	private int numWheels;
	private static long numMotorcyclesProduced;
	
	public Motorcycle (String color, String make, String model, String series) throws InvalidMakeChoiceException, InvalidModelChoiceException, InvalidSeriesChoiceException, InvalidColorChoiceException{
		
		super(color, make, model, series, "**Motorcycle Waiting to Begin Production**");
		this.setNumHandlebars(1);
		numMotorcyclesProduced++;
	}
	public int getNumHandlebars() {
		return numHandlebars;
	}

	public void setNumHandlebars(int numHandlebars) {
		this.numHandlebars = numHandlebars;
	}
	public int getNumWheels() {
		return numWheels;
	}

	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}
	public static long getNumMotorcyclesProduced() {
		return numMotorcyclesProduced;
	}
	public static void setNumMotorcyclesProduced(long numMotorcyclesProduced) {
		Motorcycle.numMotorcyclesProduced = numMotorcyclesProduced;
	}

	
}
