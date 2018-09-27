package learningjava8.optional;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;

public class TestOptional {
	
	public static void main(String[] args) {
		
		
		
	}
	
	
	public static void testMethod(Insurance insurance) {
		String name = null;
		if(insurance != null){
		    name = insurance.getName();
		}
		
		
		Optional<Insurance> ins = Optional.ofNullable(insurance);
		Optional<String> na = ins.map(Insurance::getName);
		
		//na.orElseThrow(exceptionSupplier)
				
		
	}

}
