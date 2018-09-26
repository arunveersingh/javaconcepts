package generics;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

	public static void main(String[] args) {

		List<Vehicle> ls = new ArrayList<>();
		
		ls.add(new Car());
		ls.add(new Truck());
		
		showFleet(ls);
		
		List<Car> lsc = new ArrayList<>();
		ls.add(new Car());
		ls.add(new Car());
		
		//showFleet(lsc);
		
		
		// Not assignment compatible
		//ls == lsc;

		// LISKOV SUBSTITUTION PRINCIPLE
		/*Methods that use references to the base classes must be able to use the objects of the derived classes without knowing it*/
		
		
		
		
	}

	private static void showFleet(List<Vehicle> lv) {

		for(Vehicle v: lv) {
			System.out.println(">" + v);
		}
	}

}
