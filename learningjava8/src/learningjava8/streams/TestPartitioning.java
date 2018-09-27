package learningjava8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestPartitioning {
	
	static List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH));

	public static void main(String[] args) {
		
		Map<Boolean, List<Dish>> partionedMenu = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
		partionedMenu.get(true).forEach(System.out::println);
		
		System.out.println(isPrime(7));
		

	}
	
	public static boolean isPrime(int candidate) {
	    int candidateRoot = (int) Math.sqrt((double) candidate);
	    System.out.println("candidateRoot : " + candidateRoot);
	    return IntStream.rangeClosed(2, candidateRoot)
	                    .noneMatch(i -> candidate % i == 0);
	}

}
