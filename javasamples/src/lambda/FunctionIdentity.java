package lambda;

import java.util.function.Function;

public class FunctionIdentity {

	public static void main(String[] args) {
		
		/**
		 * this piece of code is just to verify that input object is returned by 
		 */
		Function<Apple, Apple> function = t -> {t.setTested(true); return t;};
		Apple apple = new Apple(10, "green");
		Apple op = function.apply(apple);
		System.out.println(op);
		
		Function<Apple, Apple> functionIdentity = Function.identity();
		functionIdentity.apply(apple);
		//int opIdentity = functionIdentity.apply(new Apple());
		//System.out.println(opIdentity);
		
		
		

		
		
	}

}
