package main.java.com.solvd.vehiclefactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import main.java.com.solvd.vehiclefactory.exceptions.InvalidColorChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidMakeChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidModelChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidSeriesChoiceException;
import main.java.com.solvd.vehiclefactory.stations.InspectionStation;
import main.java.com.solvd.vehiclefactory.stations.InteriorStation;
import main.java.com.solvd.vehiclefactory.stations.MechanicalStation;
import main.java.com.solvd.vehiclefactory.stations.PaintStation;
import main.java.com.solvd.vehiclefactory.stations.StampingStation;
import main.java.com.solvd.vehiclefactory.stations.Station;
import main.java.com.solvd.vehiclefactory.stations.TireStation;
import main.java.com.solvd.vehiclefactory.stations.WeldingStation;
import main.java.com.solvd.vehiclefactory.vehicles.Car;
import main.java.com.solvd.vehiclefactory.vehicles.Motorcycle;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;
public class VehicleFactory {

	private String factoryName;
	private String address;
	private ArrayList<Station> stations;
	private HashMap<String, Vehicle> approvedVehicles;

	public VehicleFactory(String factoryName, String address) throws InvalidMakeChoiceException, InvalidModelChoiceException, InvalidSeriesChoiceException, InvalidColorChoiceException {
		this.factoryName = factoryName;
		this.address = address;
		this.stations = initializeStations();
		this.approvedVehicles = initializeApprovedVehicles();
	}

	public ArrayList<Station> initializeStations() {
		ArrayList<Station> stationList = new ArrayList<Station>();

		StampingStation stampingStation = new StampingStation(false);
		stationList.add(stampingStation);

		WeldingStation weldingStation = new WeldingStation(false);
		stationList.add(weldingStation);

		MechanicalStation mechanicalStation = new MechanicalStation(false);
		stationList.add(mechanicalStation);

		PaintStation paintStation = new PaintStation(false);
		stationList.add(paintStation);

		InteriorStation interiorStation = new InteriorStation(false);
		stationList.add(interiorStation);

		TireStation tireStation = new TireStation(false);
		stationList.add(tireStation);

		InspectionStation inspectionStation = new InspectionStation(false);
		stationList.add(inspectionStation);

		return stationList;

	}

	public HashMap<String, Vehicle> initializeApprovedVehicles() throws InvalidMakeChoiceException, InvalidModelChoiceException, InvalidSeriesChoiceException, InvalidColorChoiceException {
		HashMap<String, Vehicle> approvedVehicles = new HashMap<>();
		approvedVehicles.put("VIN0234324", new Car("Yellow", "Honda", "Fit", "Sport"));
		approvedVehicles.put("VIN6774567", new Car("White", "Toyota", "Yaris", "Hatchback"));
		approvedVehicles.put("VIN6478932", new Car("Maroon", "Honda", "Accord", "Sport 2.0T"));
		approvedVehicles.put("VIN8567832", new Motorcycle("Brown", "Ducati", "Streetfighter", "V2"));
		return approvedVehicles;

	}

	public boolean isProducible(Vehicle v) throws InvalidColorChoiceException, InvalidMakeChoiceException, InvalidModelChoiceException, InvalidSeriesChoiceException {
		boolean ip = true;
		if (!this.getValidColorList().contains(v.getColor())) {
			ip = false;
			String message = v.getColor() + " is not a valid color selection for a vehicle.";
			throw new InvalidColorChoiceException(message);
		}
		if (!this.getValidMakeList().contains(v.getMake())) {
			ip = false;
			String message = v.getMake() + " is not a valid selection for a make.";
			throw new InvalidMakeChoiceException(message);
		}
		if (!this.getValidModelList(v.getMake()).contains(v.getModel())) {
			ip = false;
			String message = v.getModel() + " is not a valid selection for a model for a " + v.getMake() + " vehicle.";
			throw new InvalidModelChoiceException(message);
		}
		if (!this.getValidSeriesList(v.getModel()).contains(v.getSeries())) {
			ip = false;
			String message = v.getSeries() + " is not a valid selection for a series for a " + v.getModel() + " vehicle";
			throw new InvalidSeriesChoiceException(message);
		}
		return ip;
	}

	public ArrayList<String> getValidColorList(){
		List<String> colors = Arrays.asList("Yellow", "Pink", "White", "Gray", "Red", "Green", "Maroon", "Purple", "Brown");
		ArrayList<String> validColorList = new ArrayList<String>();
		colors.stream().forEach(color -> validColorList.add(color));
		return validColorList;

	}

	public ArrayList<String> getValidMakeList(){
		List<String> makes = Arrays.asList("Toyota", "Honda", "Ducati");
		ArrayList<String> validMakeList = new ArrayList<String>();
		makes.stream().forEach(make -> validMakeList.add(make));
		return validMakeList;
	}

	public ArrayList<String> getValidModelList(String make){
		ArrayList<String> validModelList = new ArrayList<String>();
		switch (make) {
		case "Toyota":
			validModelList.add("Camry");
			validModelList.add("Yaris");
			break;
		case "Honda":
			validModelList.add("Fit");
			validModelList.add("Accord");
			break;
		case "Ducati":
			validModelList.add("Streetfighter");
			validModelList.add("DesertX");
			break;
		}
		return validModelList;
	}

	public ArrayList<String> getValidSeriesList(String model){
		ArrayList<String> validSeriesList = new ArrayList<String>();
		switch (model) {
		case "Camry":
			validSeriesList.add("LE");
			validSeriesList.add("SE Nightshade");
			break;
		case "Yaris":
			validSeriesList.add("XLE");
			validSeriesList.add("Hatchback");
			break;
		case "Fit":
			validSeriesList.add("Sport");
			validSeriesList.add("EX-L");
			break;
		case "Accord":
			validSeriesList.add("Sport 2.0T");
			validSeriesList.add("Touring 2.0T");
			break;
		case "Streetfighter":
			validSeriesList.add("V2");
			validSeriesList.add("V4 SP");
			break;
		case "DesertX":
			validSeriesList.add("Dream");
			validSeriesList.add("937");
			break;
		}
		return validSeriesList;
	}


	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Station> getStations() {
		return stations;
	}

	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}

	public HashMap<String, Vehicle> getApprovedVehicles() {
		return approvedVehicles;
	}

	public void setApprovedVehicles(HashMap<String, Vehicle> approvedVehicles) {
		this.approvedVehicles = approvedVehicles;
	}

}
