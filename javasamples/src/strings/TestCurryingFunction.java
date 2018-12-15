package strings;

import java.util.function.Function;

public class TestCurryingFunction implements CurryingInterface {

    public static void main(String[] args) {
	
	Function<Integer, 
        Function<Integer, Integer> > 
   curryMulti = u -> v -> u * v;
   
   
   System.out.println(curryMulti.apply(2));

    }

    @Override
    public Integer sum(Integer n, CurryingInterface num) {
	return 0;
    }
    
    

}
