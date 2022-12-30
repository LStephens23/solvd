package main.java.com.solvd.vehiclefactory.vehicles;

public enum FuelType {
	GASOLINE("Gasoline", false) {
		@Override
		public double getFuelEfficiency() {
			return 35.0;
		}
	},
	DIESEL("Diesel", false) {
		@Override
		public double getFuelEfficiency() {
			return 50.0;
		}
	},
	ELECTRIC("Electric", true) {
		@Override
		public double getFuelEfficiency() {
			return 100.0;
		}
	},
	HYBRID("Hybrid", true) {
		@Override
		public double getFuelEfficiency() {
			return 62.0;
		}
	};

	private String name;
	private boolean renewable;

	FuelType(String name, boolean renewable) {
		this.name = name;
		this.renewable = renewable;
	}

	// Average miles per gallon
	public abstract double getFuelEfficiency(); 

	public String getName() {
		return name;
	}

	public boolean isRenewable() {
		return renewable;
	}
}
