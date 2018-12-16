package thread;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SemaphoreTest {

    public static void main(String[] args) {

	ExecutorService executor = Executors.newFixedThreadPool(10);
	
	IntStream.range(0, 20).forEach((x) -> executor.execute(() -> {
	    System.out.println("===> Invoking accessResource " + new Date());
	    new SemaphoreClass().accessResource();
	}));
	
	executor.shutdown();
	
    }

}
