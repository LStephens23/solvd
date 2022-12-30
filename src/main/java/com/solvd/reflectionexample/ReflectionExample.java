package main.java.com.solvd.reflectionexample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.vehiclefactory.Runner;
import main.java.com.solvd.vehiclefactory.vehicles.Vehicle;

public class ReflectionExample {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Logger logger = LogManager.getLogger(Runner.class.getName());

		Class<?> carClass = Class.forName("main.java.com.solvd.vehiclefactory.vehicles.Car");

		Constructor[] constructors = carClass.getDeclaredConstructors();
		Constructor constructor = constructors[0];
		Vehicle vehicle = (Vehicle) constructor.newInstance("Blue", "Toyota", "Rav4", "X");
		for (Constructor c : constructors) {		
			logger.info(c);
		}

		Field[] fields = carClass.getDeclaredFields();
		Field capField = carClass.getDeclaredField("maxCapacity");
		capField.setAccessible(true);
		int cap = (int) capField.get(vehicle);
		for (Field f :fields) {		
			logger.info(f);
		}

		Method[] methods = carClass.getDeclaredMethods();
		Method statusMethod = carClass.getDeclaredMethod("getMaxCapacity");
		statusMethod.invoke(vehicle);
		for (Method m : methods) {
			logger.info(m);		
		}
	}
}
