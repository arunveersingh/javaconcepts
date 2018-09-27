package collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import learningjava8.lambda.Apple;

/**
 * Usage of keyMapper, valueMapper, mergeFunction
 * {@link Collectors#toMap(Function, Function, java.util.function.BinaryOperator)}
 * 
 * @author arunveersingh
 *
 */
public class ToMapCollectors {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("MATHEMATICS");
		list.add("PHYSICS");
		list.add("CHEMISTRY");
		Map<String, Object> map = list.stream().collect(Collectors.toMap(Function.identity(), s -> s));
		map.forEach((x, y) -> System.out.println("Key: " + x + ", value: " + y));

		List<Apple> apples = new ArrayList<>(
				Arrays.asList(new Apple("green", 10.0), new Apple("orange", 20.0), new Apple("green", 20.0)));
		// Map<Apple, Object> maps =
		// apples.stream().collect(Collectors.toMap(Function.identity(), s->s));
		// Map<Apple, Object> maps =
		// apples.stream().collect(Collectors.toMap(Function.identity(),
		// s->s.getColor()));

		/**
		 * Below code will throw an exception - duplicate key
		 */
		// Map<String, Object> maps =
		// apples.stream().collect(Collectors.toMap(s->s.getColor(),
		// Function.identity()));
		// maps.forEach((x, y) -> System.out.println("Key: " + x +", value: "+ y));

		/*
		 * Exception in thread "main" java.lang.IllegalStateException: Duplicate key
		 * Apple with color = green, weight = 10.0 at
		 * java.util.stream.Collectors.lambda$throwingMerger$0(Collectors.java:133) at
		 * java.util.HashMap.merge(HashMap.java:1253) at
		 * java.util.stream.Collectors.lambda$toMap$58(Collectors.java:1320) at
		 * java.util.stream.ReduceOps$3ReducingSink.accept(ReduceOps.java:169) at
		 * java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:
		 * 1374) at
		 * java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:481) at
		 * java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:471)
		 * at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708)
		 * at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) at
		 * java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:499) at
		 * collectors.ToMapCollectors.main(ToMapCollectors.java:26)
		 */

		/**
		 * Ways to handle duplicate keys
		 */
		Map<String, Object> maps = apples.stream()
				.collect(Collectors.toMap(s -> s.getColor(), Function.identity(), (s1, s2) -> {
					System.out.println("Duplicate key found");
					return s1;
				}));
		maps.forEach((x, y) -> System.out.println("Key: " + x + ", value: " + y));

	}

}
