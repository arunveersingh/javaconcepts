package exceptions;

public class ChildOfTestExceptions extends TestExceptions {
    
    @Override
    void method()  {
	
	
        try {
	    super.method();
	} catch (CustomCheckedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    

}
