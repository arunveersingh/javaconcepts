package learningjava8.parallelstream;

import java.util.stream.IntStream;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.*;

public class TestParallelStream {

	public static void main(String[] args) {
		
		System.out.println("Calcualtions for : " + 0 + " and response is " + parallelStream(0));
		System.out.println("Calcualtions for : " + 1 + " and response is " + parallelStream(1));
		System.out.println("Calcualtions for : " + 2 + " and response is " + parallelStream(2));
		System.out.println("Calcualtions for : " + 3 + " and response is " + parallelStream(3));
		System.out.println("Calcualtions for : " + 4 + " and response is " + parallelStream(4));
		
		measurePerf(4, TestParallelStream::parallelStream);
	
	}
	
	private static int parallelStream(int n) {
		System.out.println("here");
		
		Date firstStart = new Date();
		Stream.iterate(0, (x)->x+1).limit(n).reduce(0, (a,b)->a+b);
		System.out.println("Time Taken first method: " + (new Date().getTime() - firstStart.getTime()));
		
		
		Date secondStart = new Date();
		IntStream.range(0, n).reduce(0, (a, b)->a+b);		
		System.out.println("Time Taken second method: " + (new Date().getTime() - secondStart.getTime()));
		
		System.out.println("leaving");
		return IntStream.range(0, n).reduce(0, (a, b)->a+b);
		
	}
	
	private static void measurePerf(int n, Function<Integer, Integer> function) {		
		System.out.println("output: " + function.apply(n));
	}
	
	public static long sideEffectSum(long n) {
	    Accumulator accumulator = new Accumulator();
	    LongStream.rangeClosed(1, n).forEach(accumulator::add);
	    return accumulator.total;
	}

}

class Accumulator {
    public long total = 0;
    public void add(long value) { total += value; }
}
