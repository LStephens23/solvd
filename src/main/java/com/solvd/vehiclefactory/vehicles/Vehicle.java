package main.java.com.solvd.vehiclefactory.vehicles;

import java.util.Objects;

import main.java.com.solvd.vehiclefactory.exceptions.InvalidColorChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidMakeChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidModelChoiceException;
import main.java.com.solvd.vehiclefactory.exceptions.InvalidSeriesChoiceException;


public abstract class Vehicle implements IDrive{

	private String color;
	private String make;
	private String model;
	private String series;
	private String status;
	

	public Vehicle(String color, String make, String model, String series, String status) throws InvalidMakeChoiceException, InvalidModelChoiceException, InvalidSeriesChoiceException, InvalidColorChoiceException {
		
		this.color = color;
		this.make = make;
		this.model = model;
		this.series = series;
		this.status = status;

	}
	
	
	@Override
	public void moveForward() {
		this.setStatus("Moving Forward");
	};
	
	@Override
	public void moveBackward() {
		this.setStatus("Moving Backward");
	};
	
	@Override
	public void turnLeft() {
		this.setStatus("Turning Left");
	};
	
	@Override
	public void turnRight() {
		this.setStatus("Turning Right");
	};
	
	@Override
	public void changeGear(int i) {
		this.setStatus("Changing Gear to " + i);
	};
	
	@Override
	public void brake() {
		this.setStatus("Braking");
	}

	
	@Override
	public String toString() {
		return this.getColor() + " " + this.getMake() + " " + this.getModel() + " " + this.getSeries();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(obj == null || obj.getClass()!= this.getClass()) {
		        return false;
		}
		Vehicle v = (Vehicle) obj;
		return (v.getColor().equals(this.getColor())  
				&& v.getMake().equals(this.getMake()) 
				&& v.getModel().equals(this.getModel())
				&& v.getSeries().equals(this.getSeries())
				&& v.getStatus().equals(this.getStatus())  );
		
	}
	
	@Override
    public int hashCode()
    {
        return Objects.hash(this.getColor(), this.getMake(), this.getModel(), this.getSeries(), this.getStatus());
    }

	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}


	

}
