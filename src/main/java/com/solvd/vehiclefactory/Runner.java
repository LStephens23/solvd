package main.java.com.solvd.vehiclefactory;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.*;

import main.java.com.solvd.vehiclefactory.employees.Manager;
import main.java.com.solvd.vehiclefactory.employees.TrimInstaller;
import main.java.com.solvd.vehiclefactory.exceptions.EmployeeNotAvailableException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidColorChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidMakeChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidModelChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidRateChangeException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidSeriesChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InventoryItemNotFoundException;
import main.java.com.solvd.vehiclefactory.stations.Station;
import main.java.com.solvd.vehiclefactory.vehicles.Car;
import main.java.com.solvd.vehiclefactory.vehicles.Motorcycle;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;
import main.java.com.solvd.vehiclefactory.vehicles.VehicleHashMapComparator;

public class Runner {

	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	public static <T> void main(String[] args) throws InvalidRateChangeException, InvalidMakeChoiceException, InvalidModelChoiceException, InvalidSeriesChoiceException, InvalidColorChoiceException {

		VehicleFactory vehicleFactory = new VehicleFactory("Auto Man", "100 Pan St. Austin, Tx. 78747");

		Owner owner = new Owner("Octavia Oliver", "123 Flower St", "555-55-5555");
		owner.printInfo();

		// Manager gives employee a raise and changes their station.
		GregorianCalendar hireDate = new GregorianCalendar(2022, 12 - 1, 1);
		TrimInstaller employee = new TrimInstaller("India", "Inigo","I001","Interior", hireDate, 40f, 8);
		hireDate = new GregorianCalendar(2022, 12 - 1, 1);
		Manager manager = new Manager("Mickaela", "Mittens", "ADMIN001", "Management", hireDate, 80f, 7);
		manager.setNewHourlyRate(employee, 50f);
		manager.setNewStation(employee, "Tire");
		logger.info("*************************************************");

		//Employee enters some data for a vehicle to be made
		String color = "Green";
		String make = "Toyota";
		String model = "Camry";
		String series = "SE Nightshade";

		// Factory produces a vehicle showing employees, process, inventory
		ArrayList<InventoryItem> inventory = initializeInventory();
		ArrayList<Station> stationList = vehicleFactory.getStations();
		
		// Produce a list of items that are low in inventory
		//List<InventoryItem> orderList = new ArrayList<>();
		inventory.stream().filter(item -> item.getCount() < 10).forEach(item -> {
			logger.info(item.getItemID() + " is low in stock.");
		});

		Car c = new Car(color, make, model, series);

		LinkedList<Vehicle> vehiclesInProduction = new LinkedList<Vehicle>();
		vehiclesInProduction.add(c);

		//Instead of creating a new data for a car, Employee may select a car from 
		//list of approved vehicles.
		HashMap<String, Vehicle> approvedVehicles = vehicleFactory.getApprovedVehicles();
		Vehicle c2 = approvedVehicles.get("VIN0234324");
		vehiclesInProduction.add(c2);
		Vehicle c3 = approvedVehicles.get("VIN6774567");
		vehiclesInProduction.add(c3);
		logger.info(vehiclesInProduction.getSize());
		
		//testing customlambdaA
		logger.info("****************************");
		vehiclesInProduction.foreach(v -> logger.info(v.toString() + " is scheduled for production."));
		logger.info("****************************");


		vehiclesInProduction.forEach(v -> {
			try {
				for (Station st : stationList) {
					st.processVehicle(v, inventory);
					st.printInventory(inventory);
				}
				logger.info("***********END OF PROCESS FOR VEHICLE************");
			}catch (InventoryItemNotFoundException e) {
				logger.fatal(e.getMessage());
			}catch (EmployeeNotAvailableException e) {
				logger.fatal(e.getMessage());
			}
			
		});

		// Stream through list of vehicles needed and add those we can produce to vehiclesInProduction
		initializeVehiclesNeeded().entrySet().stream().filter(v -> {
			try {
				return vehicleFactory.isProducible(v.getValue());
			} catch (InvalidColorChoiceException | InvalidMakeChoiceException | InvalidModelChoiceException
					| InvalidSeriesChoiceException e) {
				logger.info(e.getMessage());
				return false;
			}
		}).forEach(v -> {
			vehiclesInProduction.add(v.getValue());
			logger.info("Good News! We can produce vehicle " + v.getKey() + " " 
					+ v.getValue().toString() + " and it's been added to vehicles in production");
		});

	}


	static ArrayList<InventoryItem> initializeInventory() {

		ArrayList<InventoryItem> inventory = new ArrayList<>();

		InventoryItem inventoryItem = new InventoryItem("Metal Door", 4);
		inventory.add(inventoryItem);

		inventoryItem = new InventoryItem("Solder Roll", 100);
		inventory.add(inventoryItem);

		inventoryItem = new InventoryItem("Motor", 1);
		inventory.add(inventoryItem);

		inventoryItem = new InventoryItem("White Paint", 4);
		inventory.add(inventoryItem);

		inventoryItem = new InventoryItem("Fabric Roll", 10);
		inventory.add(inventoryItem);

		inventoryItem = new InventoryItem("Tires", 4);
		inventory.add(inventoryItem);

		inventoryItem = new InventoryItem("Sheets of Paper", 50);
		inventory.add(inventoryItem);
		logger.info("Starting Inventory: " + inventory.toString());

		return inventory;
	}

	//some outside list of vehicles that need to be produced,
	//(some of which this factory may not be equipped or authorized
	//to produce)
	public static HashMap<String, Vehicle> initializeVehiclesNeeded() throws InvalidMakeChoiceException, InvalidModelChoiceException, InvalidSeriesChoiceException, InvalidColorChoiceException {
		HashMap<String, Vehicle> vehiclesNeeded = new HashMap<>();
		vehiclesNeeded.put("VIN0334324", new Car("Blue", "Honda", "Fit", "Sport")); //color not valid
		vehiclesNeeded.put("VIN6774963", new Car("White", "Chevrolet", "Yaris", "Hatchback")); //make not valid
		vehiclesNeeded.put("VIN6475930", new Car("Maroon", "Honda", "Pixie", "Sport 2.0T")); //model not valid
		vehiclesNeeded.put("VIN8467836", new Motorcycle("Brown", "Ducati", "Streetfighter", "8")); //series not valid
		vehiclesNeeded.put("VIN0234322", new Car("Yellow", "Honda", "Fit", "Sport")); //valid
		vehiclesNeeded.put("VIN6774562", new Car("White", "Toyota", "Yaris", "Hatchback")); //valid
		vehiclesNeeded.put("VIN6478932", new Car("Maroon", "Honda", "Accord", "Sport 2.0T")); //valid
		vehiclesNeeded.put("VIN8567832", new Motorcycle("Brown", "Ducati", "Streetfighter", "V2")); //valid
		return vehiclesNeeded;

	}

	
	//No longer in use
	public static void compareVehicleHashMaps(HashMap<String, Vehicle> map1, HashMap<String, Vehicle> map2, VehicleHashMapComparator comparator) {
		// Iterate through the key-value pairs in map1 and compare them to the pairs in map2
		for (Map.Entry<String, Vehicle> entry1 : map1.entrySet()) {
			String key1 = entry1.getKey();
			Vehicle value1 = entry1.getValue();

			for (Map.Entry<String, Vehicle> entry2 : map2.entrySet()) {
				String key2 = entry2.getKey();
				Vehicle value2 = entry2.getValue();

				// Use the comparator to compare the values
				if (comparator.compare(key1, value1, key2, value2)) {
					logger.info("Good News! We can produce vehicle " + key1 + " " 
							+ value1.toString() + " and it's been added to vehicles in production");
				}
			}
		}
	}

}
