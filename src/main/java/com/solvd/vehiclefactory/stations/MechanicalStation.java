package main.java.com.solvd.vehiclefactory.stations;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import main.java.com.solvd.vehiclefactory.InventoryItem;
import main.java.com.solvd.vehiclefactory.employees.Employee;
import main.java.com.solvd.vehiclefactory.employees.Mechanic;

public class MechanicalStation extends Station {
	
	public MechanicalStation(boolean isAvailable) {
		super(isAvailable);
		this.setDeptName("Mechanical");
		
		InventoryItem inventoryItem = new InventoryItem("Motor", 1);
		ArrayList<InventoryItem> inventoryRequired = new ArrayList<InventoryItem>();
		inventoryRequired.add(inventoryItem);
		this.setInventoryRequired(inventoryRequired);
		
		GregorianCalendar hireDate = new GregorianCalendar(2022, 12 - 1, 1);
		Mechanic employee = new Mechanic("Molly", "Mackey","M003","Mechanical", hireDate, 35f, 20);
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		this.setEmployeeList(employeeList);
		
		
	}

}
