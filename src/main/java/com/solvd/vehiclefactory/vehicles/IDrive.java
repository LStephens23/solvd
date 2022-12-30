package main.java.com.solvd.vehiclefactory.vehicles;

public interface IDrive {
	
	void moveForward();
	void moveBackward();
	void turnLeft();
	void turnRight();
	void changeGear(int i);
	void brake();

}
