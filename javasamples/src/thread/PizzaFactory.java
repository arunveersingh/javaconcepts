package thread;

import java.util.LinkedList;
import java.util.Queue;

public class PizzaFactory {
    
    Queue<Object> pizzas = new LinkedList<>();
    void producePizza() {
	

	while(true) {
	    synchronized (this) {
		    
		    while(pizzas.size() >=10) {
			try {
			    wait();
			} catch (InterruptedException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
		    }
		    
		    if (pizzas.size() < 10) {
			pizzas.add("Pizza");
			System.out.println("Produced");
			notify();
		    }

		}
	}

    }

    void consumePizza() {
	
	while(true) {
	    synchronized (this) {
		    
		    while(pizzas.size()<1) {
			try {
			    wait();
			} catch (InterruptedException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
		    }
		    
		    if (pizzas.size() > 0) {
			pizzas.poll();
			System.out.println("Consumed");

			notify();
		    }

		}

	}
    }
    
    
    public static void main(String [] args) {
	
	PizzaFactory fact = new PizzaFactory();
	new Thread(() -> fact.producePizza()).start();
	new Thread(() -> fact.consumePizza()).start();

    }

}
