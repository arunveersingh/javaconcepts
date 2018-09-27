package learningjava8.lambda;

import java.util.function.Function;

public class TestComposingFunctions {

	public static void main(String[] args) {

		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
				.andThen(Letter::addFooter);
		
		
		String output = transformationPipeline.apply("text");
		
		System.out.println(output);

	}

}
