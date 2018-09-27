package learningjava8.newfeatures.optional;

import java.util.Optional;

import learningjava8.lambda.Apple;

/**
 * This class demonstrates the usage of {@link Optional}
 * @author arunveer singh
 *
 */
public class OptionalUsage {

	public static void main(String[] args) {
		
		Optional<Apple> apple = Optional.ofNullable(getApple(0, "green", true));
		
		if(apple.isPresent()) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
		
		Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional:" + gender);
        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));
        
        // java.lang.NullPointerException
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));
		
		
	}

	
	public static Apple getApple(double weight, String color, Boolean flag) {
		if(flag) {
			return null;
		}else {
			return new Apple(color, weight);
		}
	}
}
