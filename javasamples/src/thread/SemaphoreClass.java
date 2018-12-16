package thread;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreClass {

    private final static Semaphore lock = new Semaphore(5);

    public void accessResource() {

	synchronized (this) {
	    try {
		boolean lockAcquired = false;

		while (!lockAcquired) {
		    
		    System.out.println("!!!!!  trying to get lock " + Thread.currentThread().getName() + " "+ new Date());
		    if (lock.availablePermits() > 0) {
			lock.acquire();
			lockAcquired = true;
			System.out.println("@@@@@ lock Acquired " + Thread.currentThread().getName()+ " "+ new Date());

		    }else {
			    System.out.println("&&&&&&  havent got lock lock " + Thread.currentThread().getName()+ " "+ new Date());

		    }
		}

		TimeUnit.SECONDS.sleep(20);

	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}

	System.out.println("##### Releasing lock " + Thread.currentThread().getName()+ " "+ new Date());
	lock.release();

    }

}
