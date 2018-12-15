package enumexamples;

public enum EnumWithoutInstance {
    
    ;
    
    public static String test() {
	System.out.println("test");
	return "test";
    }
    
    static String test(String value){
	return value;
    }

}
