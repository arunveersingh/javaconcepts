package learningjava8.newfeatures.functionsinjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import learningjava8.lambda.Apple;

/**
 * This class demonstrates behavior parameterization / passing code.
 * 
 * @author arunveer singh
 *
 */
public class FilteringApples {

	public static void main(String[] args) {

		List<Apple> inventory = Arrays.asList(new Apple("green", 80.0), new Apple("green", 155.0),
				new Apple("red", 120.0));
		

		filter(inventory, FilteringApples::isGreenApple);
		filter(inventory, FilteringApples::isHeavyApple);

		filterGreenApples(inventory).stream().forEach(apple -> System.out.println(apple));

		filterGreenAndHeavyApples(inventory).stream().forEach(apple -> System.out.println(apple));

		filter(inventory, apple -> "green".equals(apple.getColor()));

		filter(inventory, apple -> "green".equals(apple.getColor()) && apple.getWeight().doubleValue() > 85.0);


		Predicate<Apple> greenApple = apple -> "green".equals(apple.getColor());
		Predicate<Apple> heavyApple = apple -> apple.getWeight().doubleValue() > 85.0;

		Predicate<Apple> greenAndHeavyApple = greenApple.and(heavyApple);

		System.out.println("**** greenAndHeavyApple ****");
		filter(inventory, greenAndHeavyApple).stream().forEach(apple -> System.out.println(apple));

	}

	// "green".equals(apple.getColor())
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> filteredApples = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				filteredApples.add(apple);
			}
		}

		return filteredApples;
	}

	// "green".equals(apple.getColor()) && apple.getWeight().doubleValue() > 85.0
	public static List<Apple> filterGreenAndHeavyApples(List<Apple> inventory) {
		List<Apple> filteredApples = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor()) && apple.getWeight().doubleValue() > 85.0) {
				filteredApples.add(apple);
			}
		}

		return filteredApples;
	}

	public static List<Apple> filter(List<Apple> inventory, Predicate<Apple> predicate) {

		List<Apple> filteredApples = new ArrayList<>();
		for (Apple apple : inventory) {
			if (predicate.test(apple)) {
				filteredApples.add(apple);
			}
		}
		return filteredApples;
	}

	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return "green".equals(apple.getColor()) && apple.getWeight().doubleValue() > 85.0;
	}

}
