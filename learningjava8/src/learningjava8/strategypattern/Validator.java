package learningjava8.strategypattern;

public class Validator {
	
	private final ValidationStrategy strategy;

	public Validator(ValidationStrategy strategy) {
		super();
		this.strategy = strategy;
	}
	
	public boolean valdiate(String s) {
		return strategy.execute(s);
	}

}
