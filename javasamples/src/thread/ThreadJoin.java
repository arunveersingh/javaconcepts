package thread;

import java.util.concurrent.TimeUnit;

public class ThreadJoin {

    public static void main(String[] args) {

	Thread t1 = new Thread(() ->  {
	    try {
		TimeUnit.SECONDS.sleep(7);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    System.out.println("7");

	});//.start();
	
	t1.start();
	
	try {
	    t1.join();
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	
	new Thread(() ->  {
	    try {
		TimeUnit.SECONDS.sleep(3);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    System.out.println("3");

	}).start();
	
	
	new Thread(() ->  {
	    try {
		TimeUnit.SECONDS.sleep(5);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    System.out.println("5");

	}).start();
	
	
	
    }

}
