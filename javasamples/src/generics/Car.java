package generics;

import java.util.HashSet;
import java.util.Set;

public class Car implements Vehicle {

	
	public Set<Car> testMethodInCar(){
		return new HashSet<>();
	}
}
