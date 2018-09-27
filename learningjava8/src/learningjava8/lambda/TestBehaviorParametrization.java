package learningjava8.lambda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestBehaviorParametrization {

	// added so as do not need to initialize for every test (so called) method
	static FilterObjects<Apple> filterObjects = new FilterObjects<Apple>();
	// added so as do not need to initialize for every test (so called) method
	static FilterObjects<Banana> filterBananaObjects = new FilterObjects<Banana>();
	// added so as do not need to initialize for every test (so called) method
	static List<Apple> assortedObjects = Arrays.asList(new Apple("Green", 1.0), new Apple("Yellow", 2.0),
			new Apple("Green", 3.0), new Apple("Green", 4.0));
	// added so as do not need to initialize for every test (so called) method
	static List<Banana> assortedBananaObjects = Arrays.asList(new Banana("Green", 1.0), new Banana("Yellow", 2.0),
			new Banana("Green", 3.0), new Banana("Green", 4.0));

	Comparator<Apple> byWeight = new Comparator<Apple>() {
		public int compare(Apple a1, Apple a2) {
			return a1.getWeight().compareTo(a2.getWeight());
		}
	};

	Comparator<Apple> byW = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// filterGreenApples(assortedObjects);
		// filterApples(new GreenApplePredicate());

		/*
		 * filterApples(new Predicate() {
		 * 
		 * @Override public boolean test(Apple apple) {
		 * if(apple.getColor().equals("Yellow")) { return true; } return false; } });
		 */

		// filterApples((Apple apple) -> apple.getColor().equals("Green"));

		// filterApples(apple -> apple.getWeight()>3.0);

		// filterApples(apple -> apple.getColor().equals("Green") &&
		// apple.getWeight()>2.0);

		// printFiltered(filterObjects.filterApples(assortedObjects, apple ->
		// apple.getWeight() > 2.0));
		/*
		 * printBananaFiltered( filterBananaObjects.filterApples(assortedBananaObjects,
		 * banana -> banana.getColor().equals("Green")));
		 * printBananaFiltered(filterBananaObjects.filter(assortedBananaObjects, (Banana
		 * banana) -> banana.getColor().equals("Green"), "-------------------"));
		 * System.out.println("test " + Thread.currentThread().getName());
		 * 
		 * Thread t = new Thread(() -> System.out.println("test " +
		 * Thread.currentThread().getName())); Thread t2 = new Thread(() -> {
		 * System.out.println("test " + Thread.currentThread().getName());
		 * printBananaFiltered(filterBananaObjects.filter(assortedBananaObjects, (Banana
		 * banana) -> banana.getColor().equals("Green"), "-------------------")); });
		 * t.start(); t2.start();
		 * 
		 * test();
		 */

		BufferedReaderProcessor brp = new BufferedReaderProcessor() {

			@Override
			public String apply(BufferedReader br) {
				// TODO Auto-generated method stub
				return null;
			}
		};

		BufferedReaderProcessor processor = (BufferedReader br) -> br.readLine();
		String response = processFile(processor);
		System.out.println("response :" + response);

		Function<BufferedReader, String> brProcessor = (BufferedReader br) -> {
			try {
				return br.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		};

		String response2 = processFile(brProcessor);
		System.out.println("response :" + response2);

		testLambdaCapture();
		
		Map<String, Supplier> v = createCounter(42);
		//v.get("val").get(); // returns 42
		//v.get("inc").get(); // returns 42
		//v.get("val").get(); // returns 43
		
		
		System.out.println(v.get("val").get());
		System.out.println(v.get("inc").get());
		System.out.println(v.get("val").get());
		
		
		assortedBananaObjects.sort((Banana a1, Banana a2) -> a1.getWeight().compareTo(a2.getWeight()));
		
		assortedBananaObjects.sort(java.util.Comparator.comparing(Banana::getWeight));
		
		
		List<String> str = Arrays.asList("a","b","A","B");
		str.sort((a1,a2)->a1.compareToIgnoreCase(a2));
		str.sort(String::compareToIgnoreCase);
		
		
		Function<String, Integer> stringToInteger =  (String s) -> Integer.parseInt(s);
		Function<String, Integer> stringToIntegers =  Integer::parseInt;
		
		BiPredicate<List<String>, String> contains =
				(list, element) -> list.contains(element);
		BiPredicate<List<String>, String> containss =
						List::contains;
		
		String color = "green";
		Double weight = 2.0;
		
		Supplier<Apple> cons = Apple::new;
		Apple apple = cons.get();
		System.out.println("Default values : "+ apple.toString());
		
		Function<Double, Apple> function  = Apple::new;
		Apple applebyweight = function.apply(99.00);

		

	}

	private static void testLambdaCapture() {
		int portNumber = 1337;
		Runnable r = () -> System.out.println(portNumber);
		r.run();
	}

	/*
	 * @SuppressWarnings("unused") private static void filterApples(Predicate<Apple>
	 * predicate) { Objects.requireNonNull(predicate); List<Apple> filteredObjects =
	 * filterObjects.filterApples(assortedObjects, predicate);
	 * printFiltered(filteredObjects);
	 * 
	 * }
	 */

	@SuppressWarnings("unused")
	private static void filterGreenApples(List<Apple> assortedObjects) {
		Objects.nonNull(assortedObjects);
		List<Apple> filteredObjects = filterObjects.filterGreenApples(assortedObjects);

		Objects.requireNonNull(filteredObjects);
		printFiltered(filteredObjects);
	}

	private static void printFiltered(List<Apple> filteredObjects) {
		for (Apple object : filteredObjects) {
			System.out.println(object);
		}
	}

	private static void printBananaFiltered(List<Banana> filteredObjects) {
		for (Banana object : filteredObjects) {
			System.out.println(object);
		}
	}

	public static Callable<String> test() {
		return () -> "xyz";
	}

	public static String processFile() throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
			return br.readLine();
		}
	}

	public static String processFile(BufferedReaderProcessor p) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\singharu\\Desktop\\quotes.txt"))) {
			return p.apply(br);
		}
	}

	public static String processFile(Function<BufferedReader, String> processor)
			throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\singharu\\Desktop\\quotes.txt"))) {
			return processor.apply(br);
		}
	}

	private static class MyClosure {
		public int value;

		public MyClosure(int initValue) {
			this.value = initValue;
		}
	}

	public static Map<String, Supplier> createCounter(int initValue) {
		MyClosure closure = new MyClosure(initValue);
		Map<String, Supplier> counter = new HashMap<>();
		counter.put("val", () -> closure.value);
		counter.put("inc", () -> closure.value++);
		return counter;
	}
	
	public static List<Apple> map(List<Integer> weights, Function<Double, Apple> function){
		List<Apple> results = new ArrayList<>();
		for(Integer e: weights) {
			results.add(function.apply(new Double(e)));
		}
		
		return results;
	}
	
	
	

}
