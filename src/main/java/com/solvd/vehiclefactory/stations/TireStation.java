package main.java.com.solvd.vehiclefactory.stations;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import main.java.com.solvd.vehiclefactory.InventoryItem;
import main.java.com.solvd.vehiclefactory.employees.Employee;
import main.java.com.solvd.vehiclefactory.employees.TireInstaller;

public class TireStation extends Station {
	
	public TireStation(boolean isAvailable) {
		super(isAvailable);
		this.setDeptName("Tire");
		
		InventoryItem inventoryItem = new InventoryItem("Tires", 4);
		ArrayList<InventoryItem> inventoryRequired = new ArrayList<InventoryItem>();
		inventoryRequired.add(inventoryItem);
		this.setInventoryRequired(inventoryRequired);
		
		GregorianCalendar hireDate = new GregorianCalendar(2022, 12 - 1, 1);
		TireInstaller employee = new TireInstaller("Tia", "Timber","T001","Tire", hireDate, 50f, 10);
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		this.setEmployeeList(employeeList);
		
		
	}
}
