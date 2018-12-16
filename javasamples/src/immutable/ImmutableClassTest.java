package immutable;

public class ImmutableClassTest {

    public static void main(String[] args) {

	ImmutableClass immutable = new ImmutableClass("test", 3, new NonImmutableClass());
	
	System.out.println(immutable.getX());
	
	
    }

}
