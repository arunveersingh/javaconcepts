package jvm;

import java.util.concurrent.TimeUnit;

public class ShutDownHook {

    public static void main(String[] args) {

	System.out.println("Started");

	// ==> 1
	Runtime.getRuntime().addShutdownHook(
		new Thread(() -> System.out.println("Shutting down")));

	try {
	    TimeUnit.SECONDS.sleep(10);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	// ==> 2
	System.out.println("Shut down complete");

    }

    // Output:

    // Started
    // Shut down complete
    // Shutting down

}
