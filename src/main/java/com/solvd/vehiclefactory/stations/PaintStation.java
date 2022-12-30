package main.java.com.solvd.vehiclefactory.stations;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.vehiclefactory.IPaint;
import main.java.com.solvd.vehiclefactory.InventoryItem;
import main.java.com.solvd.vehiclefactory.Runner;
import main.java.com.solvd.vehiclefactory.employees.Employee;
import main.java.com.solvd.vehiclefactory.employees.Painter;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;


public class PaintStation extends Station implements IPaint{
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	public PaintStation(boolean isAvailable) {
		super(isAvailable);
		this.setDeptName("Paint");

		InventoryItem inventoryItem = new InventoryItem("White Paint", 4);
		ArrayList<InventoryItem> inventoryRequired = new ArrayList<InventoryItem>();
		inventoryRequired.add(inventoryItem);
		this.setInventoryRequired(inventoryRequired);

		GregorianCalendar hireDate = new GregorianCalendar(2022, 12 - 1, 1);
		Painter employee = new Painter("Penny", "Prince","P001","Paint", hireDate,32f, 15);
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		this.setEmployeeList(employeeList);
	}
	@Override
	public void processVehicle(Vehicle v, ArrayList<InventoryItem> inventory) {

		this.setIsAvailable(true);

		paintColor(v);

		String emps = "";
		for (Employee e : this.getEmployeeList()) {
			e.doWork(v);
			emps = emps.concat("[" + e.toString() + "]");
		}
		v.setStatus("Processing at " + this.getDeptName() + " Station by " + emps);
		logger.info(v.toString());

		for (InventoryItem i : this.getInventoryRequired()) {
			inventory.remove(i);	
			logger.info(i + " Used.");
		}

		logger.info("**********************************");

	}
	@Override
	public void paintColor(Vehicle v) {
		switch (v.getColor()) {
		// light colors
		case "Yellow": case "Pink": case "White":
			logger.info("Paint machine is spray-painting initial coat of white paint.");
			break;
			// medium colors
		case "Gray": case "Red": case "Green":
			logger.info("Paint machine is spray-painting initial coat of gray paint.");
			break;
			// dark colors
		case "Maroon": case "Purple": case "Brown":
			logger.info("Paint machine is spray-painting initial coat of black paint.");
			break;
		}
	}

}
