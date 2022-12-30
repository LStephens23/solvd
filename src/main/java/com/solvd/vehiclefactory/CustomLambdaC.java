package main.java.com.solvd.vehiclefactory;

@FunctionalInterface
public interface CustomLambdaC<T, U, R> {
	R apply(T t, U u);
}
