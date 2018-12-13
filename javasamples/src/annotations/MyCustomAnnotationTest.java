package annotations;


public class MyCustomAnnotationTest {
    
    @MyCustomAnnotation(address = "testAddress", name = "testName")
    public void test(){
	
	
	
	
    }
    
    
    public static void main(String [] args) throws NoSuchMethodException, SecurityException {
	
	MyCustomAnnotationTest test = new MyCustomAnnotationTest();
	MyCustomAnnotation annotation = test.getClass().getMethod("test").getAnnotation(MyCustomAnnotation.class);
	System.out.println(annotation.name());
	
    }

}
