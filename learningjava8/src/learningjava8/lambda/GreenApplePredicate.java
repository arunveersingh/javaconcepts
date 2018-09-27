package learningjava8.lambda;

public class GreenApplePredicate implements Predicate<Apple>{

	@Override
	public boolean test(Apple apple) {
		return apple.getColor().equals("Green");
	}

}
