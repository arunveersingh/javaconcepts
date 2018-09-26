package generics;

import java.util.Arrays;

public class GenericStackUsage {
	
	public static void main(String[] args) {
		
		GenericStack<String> stack = new GenericStack<>();
		Arrays.asList(args).stream().forEach(e -> stack.push(e));
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().toUpperCase());
		}
	}

}
