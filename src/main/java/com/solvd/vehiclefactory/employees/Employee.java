package main.java.com.solvd.vehiclefactory.employees;


import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class Employee implements IWork{
	
	private String firstName;
	private String lastName;
	private String employeeID;
	private String department;
	private GregorianCalendar hireDate;
	private float hourlyRate;
	
	public Employee(String firstName, String lastName, String employeeID, String department, GregorianCalendar hireDate, float hourlyRate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeID = employeeID;
		this.department = department;
		this.hireDate = hireDate;
		this.hourlyRate = hourlyRate;
	}

	
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(obj == null || obj.getClass()!= this.getClass()) {
		        return false;
		}
		Employee e = (Employee) obj;
		return (e.firstName.equals(this.firstName)  
				&& e.lastName.equals(this.lastName) 
				&& e.employeeID.equals(this.employeeID));
		
	}
	
	@Override
    public int hashCode()
    {
        return Objects.hash(firstName, lastName, employeeID);
    }
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public GregorianCalendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(GregorianCalendar hireDate) {
		this.hireDate = hireDate;
	}

	public float getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

}
