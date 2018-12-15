package strings;

public class Strings {

    public static void main(String[] args) {

	String str = "arun veer singh";
	String[] split = str.split("");

	String modified = "";

	for (int i = 0; i < split.length; i++) {
	    if (split[i].equals(" ")) {
		split[i] = "%20";
	    }

	    modified = modified + split[i];
	}

	System.out.println(modified);
	
	

    }
    
    

}
