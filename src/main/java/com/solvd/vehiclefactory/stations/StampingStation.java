package main.java.com.solvd.vehiclefactory.stations;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import main.java.com.solvd.vehiclefactory.InventoryItem;
import main.java.com.solvd.vehiclefactory.employees.Employee;
import main.java.com.solvd.vehiclefactory.employees.Stamper;

public class StampingStation extends Station{
	

	public StampingStation(boolean isAvailable) {
		super(isAvailable);
		this.setDeptName("Stamping");
		
		InventoryItem inventoryItem = new InventoryItem("Metal Door", 4);
		ArrayList<InventoryItem> inventoryRequired = new ArrayList<InventoryItem>();
		inventoryRequired.add(inventoryItem);
		this.setInventoryRequired(inventoryRequired);
		
		GregorianCalendar hireDate = new GregorianCalendar(2022, 12 - 1, 1);
		Stamper employee = new Stamper("Sissy", "Simpson","S001","Stamping", hireDate, 66f, 5);
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		this.setEmployeeList(employeeList);
		
		
	}
	
}
