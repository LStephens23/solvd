package main.java.com.solvd.vehiclefactory.stations;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import main.java.com.solvd.vehiclefactory.InventoryItem;
import main.java.com.solvd.vehiclefactory.employees.Employee;
import main.java.com.solvd.vehiclefactory.employees.TrimInstaller;

public class InteriorStation extends Station {
	
	public InteriorStation(boolean isAvailable) {
		super(isAvailable);
		this.setDeptName("Interior");
		
		InventoryItem inventoryItem = new InventoryItem("Fabric Roll", 10);
		ArrayList<InventoryItem> inventoryRequired = new ArrayList<InventoryItem>();
		inventoryRequired.add(inventoryItem);
		this.setInventoryRequired(inventoryRequired);
		
		GregorianCalendar hireDate = new GregorianCalendar(2022, 12 - 1, 1);
		TrimInstaller employee = new TrimInstaller("India", "Inigo","I001","Interior", hireDate, 40f, 8);
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		this.setEmployeeList(employeeList);
		
	}

}
