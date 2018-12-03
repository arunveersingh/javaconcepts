package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<E> {

	//******************************
	//Commented intentionally below code. Read the comment in the commented code.
	//******************************
	
	/*private final E[] choiceArray;

	public Chooser(Collection<E> choices) {
		// This cast will function right at run time but compiler cannot vouch for it.
		// There is a way to eliminate this warning at compile time... Usage of List. See code in this same class. Type safety:
		// Unchecked cast from Object[] to E[]
		choiceArray = (E[]) choices.toArray();
	}

	public Object choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceArray[rnd.nextInt(choiceArray.length)];
	}*/
	
	
	
	private final List<E> choiceArray;

	public Chooser(Collection<E> choices) {
		choiceArray = new ArrayList<>(choices);
	}
	
	/**
	 * Introduced this constructor to explore PECS - producer extends consumer super. 
	 * Here choices is a producer so used Collection<? extends E>
	 * @param choices
	 * @param dummy - introduced this just to have another constructor in this class.   
	 */
	public Chooser(Collection<? extends E> choices, boolean dummy) {
		choiceArray = new ArrayList<>(choices);
	}

	public Object choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceArray.get(rnd.nextInt(choiceArray.size()));
	}

}
