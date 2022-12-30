
package main.java.com.solvd.vehiclefactory.stations;

public enum StationStatus {
	AVAILABLE("Available to Use"),
	UNMANNED("Awaiting employees"),
	PROCESSING("Currently in Use"),
	UNAVAILABLE("Maintenance has been ordered"),
	ERROR("Error requires Investigation");

	private String status;

	StationStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public boolean isOperational() {
		switch(this) {
		case AVAILABLE:
		case UNMANNED:
		case PROCESSING:
			return true;
		default:
			return false;
		}
	}

}


