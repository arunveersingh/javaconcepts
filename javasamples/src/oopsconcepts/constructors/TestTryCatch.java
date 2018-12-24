package oopsconcepts.constructors;

public class TestTryCatch {

    public static void main(String[] args) {
System.out.println(test());
    }

    static String test() {
	try {
	    System.exit (0);
	    System.out.println("here");
	    if(true) {
		throw new Exception();
	    }
	    return "apple";
	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    System.out.println("in finally");
	}
	return "mango";
    }
}
