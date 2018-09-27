package learningjava8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
	
	String apply(BufferedReader br) throws IOException;

}
