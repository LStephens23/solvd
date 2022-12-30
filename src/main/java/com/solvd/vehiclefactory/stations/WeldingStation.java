package main.java.com.solvd.vehiclefactory.stations;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import main.java.com.solvd.vehiclefactory.InventoryItem;
import main.java.com.solvd.vehiclefactory.employees.Employee;
import main.java.com.solvd.vehiclefactory.employees.Stamper;

public class WeldingStation extends Station {
	
	
	public WeldingStation(boolean isAvailable) {
		super(isAvailable);
		this.setDeptName("Welding");
		
		InventoryItem inventoryItem = new InventoryItem("Solder Roll", 100);
		ArrayList<InventoryItem> inventoryRequired = new ArrayList<InventoryItem>();
		inventoryRequired.add(inventoryItem);
		this.setInventoryRequired(inventoryRequired);
		
		GregorianCalendar hireDate = new GregorianCalendar(2022, 12 - 1, 1);
		Stamper employee = new Stamper("Wendy", "Wotts","W002","Welding", hireDate,40f, 100);
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		this.setEmployeeList(employeeList);
		
		
	}


}
