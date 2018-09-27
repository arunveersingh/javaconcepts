package learningjava8.forkjoin;

public class TestForkJoinSumCalculator {
	
	public static void main(String [] args) {
		
		long cal = ForkJoinSumCalculator.forkJoinSum(10_0000_0000);
		System.out.println("Calculated Sum: " + cal);
	}

}
