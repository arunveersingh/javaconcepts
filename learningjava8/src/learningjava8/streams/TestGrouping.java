package learningjava8.streams;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static  java.util.Comparator.comparingInt;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TestGrouping {

	static List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH));

	public enum CaloricLevel {
		DIET, NORMAL, FAT
	}

	public static void main(String[] args) {

		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));

		dishesByType.forEach((key, value) -> {

			System.out.println("Key: " + key);
			value.forEach(System.out::println);

		});

		Map<String, List<Dish>> dishesByName = menu.stream().collect(groupingBy(Dish::getName));
		dishesByName.forEach((key, value) -> {

			System.out.println("Key: " + key);
			value.forEach(System.out::println);

		});

		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish -> {
			if (dish.getCalories() <= 400)
				return CaloricLevel.DIET;
			else if (dish.getCalories() <= 700)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		}));

		dishesByCaloricLevel.forEach((key, value) -> {

			System.out.println("Key: " + key);
			value.forEach(System.out::println);

		});

		System.out.println("**********");

		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeAndCaloricalLevel = menu.stream()
				.collect(groupingBy(Dish::getType, groupingBy(dish -> {
					if (dish.getCalories() <= 400)
						return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
						return CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
				})));

		dishesByTypeAndCaloricalLevel.forEach((key, value) -> {
			System.out.println("Key: " + key);
			value.forEach((keyInner, valueInner) -> {
				System.out.println("Inner Key: " + key);
				valueInner.forEach(System.out::println);
			});
		});

		// Collecting data in subgroups
		// Map<Dish.Type, Long> typesCount =
		menu.stream().collect(groupingBy(Dish::getType, counting())).forEach((key, value) -> {
			System.out.println("key: " + key);
			System.out.println("value: " + value);
		});

		Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
				.collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
		
		System.out.println(mostCaloricByType);

	}

}
