package learningjava8.lambda;

import java.util.ArrayList;
import java.util.List;

public class FilterObjects<T> {
	
	public List<Apple> filterGreenApples(List<Apple> assortedObjects){
		List<Apple> filteredObjects = new ArrayList<>();
		
		for(Apple object: assortedObjects) {
			if(object.getColor().equals("Green")) {
				filteredObjects.add(object);
			}
		}
		
		return filteredObjects;
	}
	
	public List<T> filterApples(List<T> assortedObjects, java.util.function.Predicate<T> predicate){
		List<T> filteredObjects = new ArrayList<>();
		
		for(T object: assortedObjects) {
			if(predicate.test(object)) {
				filteredObjects.add(object);
			}
		}
		
		return filteredObjects;
	}
	
	public List<T> filterApples(List<T> assortedObjects, java.util.function.Predicate<T> predicate, String message){
		System.out.println(message);
		List<T> filteredObjects = new ArrayList<>();
		
		for(T object: assortedObjects) {
			if(predicate.test(object)) {
				filteredObjects.add(object);
			}
		}
		
		return filteredObjects;
	}
	
	public List<T> filter(List<T> assortedObjects, java.util.function.Predicate<T> predicate, String message){
		System.out.println(message);
		List<T> filteredObjects = new ArrayList<>();
		
		for(T object: assortedObjects) {
			if(predicate.test(object)) {
				filteredObjects.add(object);
			}
		}
		
		return filteredObjects;
	}
	
	
}
