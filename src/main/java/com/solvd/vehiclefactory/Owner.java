package main.java.com.solvd.vehiclefactory;

import org.apache.logging.log4j.*;


public final class Owner {
	private static Logger logger = LogManager.getLogger(Runner.class.getName());

	private final String fullName;
	private final String address;
	private final String socialSecurityNumber;

	public Owner(String fullName, String address, String socialSecurityNumber) {
		this.fullName = fullName;
		this.address = address;
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public final void printInfo() {
		logger.info(this.getFullName() + " owns this vehicle factory.");
	}

	public final String getFullName() {
		return fullName;
	}

	public final String getAddress() {
		return address;
	}

	public final String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

}
