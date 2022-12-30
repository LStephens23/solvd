package main.java.com.solvd.vehiclefactory.employees;

public enum EmployeeAvailabilityStatus {
    AVAILABLE("Available"),
    PAID_VACATION("On vacation"), 
    OUT_SICK("Out sick"),
    ON_LEAVE("On leave"),
    WORKING_REMOTELY("Working remotely");

    private String availability;

    EmployeeAvailabilityStatus(String availability) {
        this.availability = availability;
    }

    public String getAvailability() {
        return this.availability;
    }

    public boolean isAvailable() {
        switch(this) {
            case AVAILABLE:
            case WORKING_REMOTELY:
                return true;
            default:
                return false;
        }
    }
}
