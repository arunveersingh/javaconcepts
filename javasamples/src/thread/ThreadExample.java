package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample {

    public static void main(String[] args) {

	
	Executor ex = Executors.newFixedThreadPool(2);
	
	
	
	ex.execute(() -> {
	    
	    
	    System.out.println("printign even");
	    
	
	});
	ex.execute(() -> {System.out.println("printign odd");});
	
	
	
    }

}
