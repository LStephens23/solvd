package main.java.com.solvd.vehiclefactory.stations;

import java.util.ArrayList;

import main.java.com.solvd.vehiclefactory.InventoryItem;
import main.java.com.solvd.vehiclefactory.exceptions.EmployeeNotAvailableException;
import main.java.com.solvd.vehiclefactory.exceptions.InventoryItemNotFoundException;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;
public interface IProcess {
	
	void processVehicle(Vehicle v, ArrayList<InventoryItem> inventory) throws InventoryItemNotFoundException, EmployeeNotAvailableException;

}
