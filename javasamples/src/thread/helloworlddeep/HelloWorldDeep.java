package thread.helloworlddeep;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HelloWorldDeep {

	private static int counter = 0;
	private static int max = 50;

	public static void main(String[] args) {
		
		Thread t = new Thread(()->printHelloWorld());
		t.start();
		
	}

	static void printHelloWorld() {

		if (counter < max) {
			counter++;
			Thread t = new Thread(() -> {
				printHelloWorld();
			});
			t.start();

			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + "  _   " + new Date() + " Hello World");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
