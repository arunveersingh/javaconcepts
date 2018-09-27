package learningjava8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestDish {

	static List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH));

	public static void main(String[] args) {

		List<String> list = menu.stream().filter(d -> d.getCalories() > 400).map(Dish::getName).limit(3)
				.collect(Collectors.toList());
		System.out.println(list);

		List<Dish> vegetarianDishes = new ArrayList<>();

		/*
		 * List<Dish> vegetarianDishes = new ArrayList<>(); for (Dish d : menu) { if
		 * (d.isVegetarian()) { vegetarianDishes.add(d); } }
		 * System.out.println(vegetarianDishes);
		 */
		vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

		System.out.println(vegetarianDishes);

		System.out.println("Size: " + menu.size());
		System.out.println("Distinct: " + menu.stream().distinct().collect(Collectors.toList()));
		// System.out.println("Distinct: " + );
		menu.stream().distinct().forEach((Dish dish) -> {
			System.out.println("TYPE: " + dish.getType());
			System.out.println("NAME: " + dish.getName());
			System.out.println("************");

		});

		System.out.println(("arunveer singh".split("")).length);

		Arrays.asList("arunveer singh".split("")).stream().forEach(System.out::println);

		System.out.println("=====================================");

		System.out.println(Arrays.asList("arunveer singh".split("")).stream().map(word -> word.split("")).distinct()
				.collect(Collectors.toList()));

		Arrays.asList("arunveer singh".split("")).stream().map(word -> word.split("")).map(Arrays::stream).distinct()
				.collect(Collectors.toList());

		// *************** 5.3. FINDING AND MATCHING *****************//

		// ************** 5.3.4. Finding the first element ***************//
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream().map(x -> x * x).filter(x -> x % 3 == 0)
				.findFirst(); // 9
		firstSquareDivisibleByThree.ifPresent(System.out::println);

		// ** How would you count the number of dishes in a stream using the map and
		// reduce methods?**//
		int count = menu.stream().map(d -> 1).reduce(0, (a, b) -> a + b);
		System.out.println("Count = " + count);
		
		System.out.println("Count =" + menu.stream().count());
		
		// ******** Stream operations: stateless vs. stateful ******** //
		
		

	}
}
