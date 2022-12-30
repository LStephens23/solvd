package main.java.com.solvd.vehiclefactory.stations;

import java.util.ArrayList;

import main.java.com.solvd.vehiclefactory.InventoryItem;
import main.java.com.solvd.vehiclefactory.Runner;
import main.java.com.solvd.vehiclefactory.employees.Employee;
import main.java.com.solvd.vehiclefactory.exceptions.EmployeeNotAvailableException;
import main.java.com.solvd.vehiclefactory.exceptions.InventoryItemNotFoundException;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;

import org.apache.logging.log4j.*;


public abstract class Station implements IProcess {
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	private String deptName;
	private boolean isAvailable;
	private ArrayList<InventoryItem> inventoryRequired;
	private ArrayList<Employee> employeeList;

	public Station(String deptName, boolean isAvailable, ArrayList<InventoryItem> inventoryRequired,
			ArrayList<Employee> employeeList) {
		this.deptName = deptName;
		this.isAvailable = isAvailable;
		this.inventoryRequired = inventoryRequired;
		this.employeeList = employeeList;
	}
	
	public Station(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public void processVehicle(Vehicle v, ArrayList<InventoryItem> inventory) throws InventoryItemNotFoundException, EmployeeNotAvailableException {
		
		if (this.getEmployeeList().isEmpty()){
			throw new EmployeeNotAvailableException(" WARNING: Send Employee to " + this.getDeptName() + " immediately!");
		}
		
		for (InventoryItem i : this.getInventoryRequired()) {
			if (!inventory.contains(i)) {
				String message = "Inventory Item " + i.toString() + " Not Found. FATAL ERROR:Inventory is insufficient for continuing production of vehicle.";
				throw new InventoryItemNotFoundException(message);
			}else {
				inventory.remove(i);	
				logger.info(i + " removed from inventory.");
			}
		}
		this.setIsAvailable(true);
		v.setStatus("Processing at " + this.getDeptName() + " Station.");
		logger.info(v.toString());

		for (Employee e : this.getEmployeeList()) {
			e.doWork(v);
		}

		logger.info("**********************************");

	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public boolean isisAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public ArrayList<InventoryItem> getInventoryRequired() {
		return inventoryRequired;
	}

	public void setInventoryRequired(ArrayList<InventoryItem> inventoryRequired) {
		this.inventoryRequired = inventoryRequired;
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public void printInventory(ArrayList<InventoryItem> inventory) {
		String message;
		message = "Current inventory: ";
		for (int i = 0; i < inventory.size(); i++) {
			message += inventory.get(i).toString();
		}
		logger.info(message);
	}




}
