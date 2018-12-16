package learningjava8.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyCalculator {

    public static void main(String[] args) {

	Integer[] array = { 1, 2, 3, 4, 6, 1, 4, 6, 2, 9, 7, 2, 5, 5, 5, 7 };

	List<Integer> list = Arrays.asList(array);

	Map<Integer, Integer> countMap = new HashMap<>();
	Map<Integer, Integer> countMap3 = new HashMap<>();
	Map<Integer, Integer> countMap4 = new HashMap<>();

	list.stream().forEach(x -> {
	    System.out.println(x);
	    countMap.compute(x, (k, v) -> v == null ? 1 : v + 1);
	});

	Stream.of(array).forEach(x -> {
	    System.out.println(x);
	    countMap3.compute(x, (k, v) -> v == null ? 1 : v + 1);
	});

	/*Comparator<Integer> intComparator = (Integer a, Integer b) -> a
		.compareTo(b);*/

	// Compute the frequency
	countMap4 = Stream.of(array)
		.collect(Collectors.groupingBy(e -> e,
			Collectors.collectingAndThen(Collectors.counting(),
				Long::intValue)));

	// Number with Max Frequency
	Integer withMaxFreq = countMap4.entrySet().stream()
		.max(Comparator.comparing(Entry::getValue)).map(Entry::getKey)
		.orElse(null);

	
	// Exception if Duplicate
	countMap4.values().stream().sorted((Integer a, Integer b) -> {
	    
	    if(a.intValue()==b.intValue()) {
		throw new RuntimeException("Duplicates found");
	    }
	    return a > b ? a: b;
	}).collect(Collectors.toList());
	

	for (Integer x : list) {
	    System.out.println("--- Collections.frequency ---");
	    System.out.println(x + "__ " + Collections.frequency(list, x));
	}
	System.out.println("--- Collections.frequency ---");

	System.out.println("with max freq " + withMaxFreq);
    }

}
