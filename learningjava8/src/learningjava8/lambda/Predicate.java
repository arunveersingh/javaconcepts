package learningjava8.lambda;

@FunctionalInterface
interface Predicate<T> {
	
	boolean test(T t);
	
	//boolean test(T t, T u);
}
