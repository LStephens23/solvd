package main.java.com.solvd.vehiclefactory.stations;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import main.java.com.solvd.vehiclefactory.InventoryItem;
import main.java.com.solvd.vehiclefactory.Runner;
import main.java.com.solvd.vehiclefactory.employees.Employee;
import main.java.com.solvd.vehiclefactory.employees.Inspector;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;

import org.apache.logging.log4j.*;

public class InspectionStation extends Station{
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	public InspectionStation(boolean isAvailable) {
		super(isAvailable);
		this.setDeptName("Inspection");
		
		InventoryItem inventoryItem = new InventoryItem("Sheets of Paper", 50);
		ArrayList<InventoryItem> inventoryRequired = new ArrayList<InventoryItem>();
		inventoryRequired.add(inventoryItem);
		this.setInventoryRequired(inventoryRequired);
		
		GregorianCalendar hireDate = new GregorianCalendar(2022, 12 - 1, 1);
		Inspector employee = new Inspector("Isabel", "Iviola", "IS001", "Inspection", hireDate, 30f, 7);
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		this.setEmployeeList(employeeList);
		
		
	}
	@Override
	public void processVehicle(Vehicle v, ArrayList<InventoryItem> inventory) {

			this.setIsAvailable(true);
			String emps = "";
			for (Employee e : this.getEmployeeList()) {
				e.doWork(v);
				emps = emps.concat("[" + e.toString() + "]");
			}
			v.setStatus("Processing at " + this.getDeptName() + " Station by " + emps);
			logger.info(v.toString());

			v.moveForward();
			logger.info(v.getStatus());
			v.moveBackward();
			logger.info(v.getStatus());
			v.turnLeft();
			logger.info(v.getStatus());
			v.turnRight();
			logger.info(v.getStatus());
			v.changeGear(2);
			logger.info(v.getStatus());
			v.brake();
			logger.info(v.getStatus());
			
			for (InventoryItem i : this.getInventoryRequired()) {
				inventory.remove(i);	
				logger.info(i + " Used.");
			}
			
			logger.info("**********************************");
			
	}
	
}
