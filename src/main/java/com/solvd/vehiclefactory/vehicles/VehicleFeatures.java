package main.java.com.solvd.vehiclefactory.vehicles;

import java.util.ArrayList;
import java.util.List;

public enum VehicleFeatures {
	SUNROOF("Sunroof"),
	NAVIGATION("Navigation system"),
	LEATHER_SEATS("Leather seats"),
	HEATED_SEATS("Heated seats"),
	CLIMATE_CONTROL("Climate control"),
	REMOTE_START("Remote Start"),
	BLUETOOTH_CONNECTIVITY("Bluetooth Connectivity"),
	BACKUP_CAMERA("Backup camera"),
	BLIND_SPOT_MONITOR("Blind spot monitor"),
	EMERGENCY_BRAKING("Emergency braking");

	private String feature;

	VehicleFeatures(String feature) {
		this.feature = feature;
	}

	public String getFeature() {
		return this.feature;
	}

	public static List<String> getComfortFeatures() {
		List<String> comfortFeatures = new ArrayList<>();
		for (VehicleFeatures feature : VehicleFeatures.values()) {
			switch(feature) {
			case SUNROOF:
			case LEATHER_SEATS:
			case HEATED_SEATS:
			case CLIMATE_CONTROL:
				comfortFeatures.add(feature.getFeature());
				break;
			default:
				break;
			}
		}
		return comfortFeatures;
	}
	
	public static List<String> getConvenienceFeatures() {
		List<String> convenienceFeatures = new ArrayList<>();
		for (VehicleFeatures feature : VehicleFeatures.values()) {
			switch(feature) {
			case REMOTE_START:
			case BLUETOOTH_CONNECTIVITY:
				convenienceFeatures.add(feature.getFeature());
				break;
			default:
				break;
			}
		}
		return convenienceFeatures;
	}

	public static List<String> getSafetyFeatures() {
		List<String> safetyFeatures = new ArrayList<>();
		for (VehicleFeatures feature : VehicleFeatures.values()) {
			switch(feature) {
			case BACKUP_CAMERA:
			case BLIND_SPOT_MONITOR:
			case EMERGENCY_BRAKING:
				safetyFeatures.add(feature.getFeature());
				break;
			default:
				break;
			}
		}
		return safetyFeatures;
	}

}
