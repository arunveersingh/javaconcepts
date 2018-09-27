package learningjava8.strategypattern;

public class TestValidator {
	
	
	public static void main(String[] args) {
		
		
		//Validator numericValidator = new Validator(new IsNumeric());
		//Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
		
		
		
		Validator numericValidator2 = new Validator((s) -> s.matches("\\d+"));
		Validator lowerCaseValidator2 = new Validator((s) -> s.matches("[a-z]+"));
		System.out.println(numericValidator2.valdiate("1223"));
		System.out.println(lowerCaseValidator2.valdiate("AAA"));	
		
	}

}
