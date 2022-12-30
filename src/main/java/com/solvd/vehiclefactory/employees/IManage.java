package main.java.com.solvd.vehiclefactory.employees;

import main.java.com.solvd.vehiclefactory.exceptions.InvalidRateChangeException;

public interface IManage {
	
	void setNewHourlyRate(Employee e, float rate) throws InvalidRateChangeException;
	void setNewStation(Employee e, String deptName);
}
