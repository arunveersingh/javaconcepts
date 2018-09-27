package learningjava8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import learningjava8.lambda.Apple;

public class TestStreams {
	
	static List<Apple> assortedObjects = Arrays.asList(new Apple("Green", 1.0), new Apple("Yellow", 2.0),
			new Apple("Green", 3.0), new Apple("Green", 4.0));
	
	public static void main(String[] args) {
		
		//assortedObjects.stream().filter((Apple apple) -> apple.getWeight()>1.0).sorted(Comparator.comparing(Apple::getWeight));
		
		
		Map<String, List<Apple>> dishesByType =    assortedObjects.stream().collect(Collectors.groupingBy(Apple::getColor));
		System.out.println(dishesByType);
		
	}

}
