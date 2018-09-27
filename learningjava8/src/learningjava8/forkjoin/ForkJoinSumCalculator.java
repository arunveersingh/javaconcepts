package learningjava8.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;
	private final int start;
	private final int end;
	private final long[] numbers;

	public static final long THRESHOLD = 10_000;

	public ForkJoinSumCalculator(int start, int end, long[] numbers) {
		super();
		this.start = start;
		this.end = end;
		this.numbers = numbers;
	}

	public ForkJoinSumCalculator(long[] numbers) {
		this(0, numbers.length, numbers);
	}

	@Override
	protected Long compute() {
		
		int length = end - start;
		if (length <= THRESHOLD) {
			return computeSequentially();
		}
		ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(start, start + length / 2, numbers);
		leftTask.fork();
		ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(start + length / 2, end, numbers);

		long rightResult = rightTask.compute();
		long leftResult = leftTask.join();
		return leftResult + rightResult;

	}

	private long computeSequentially() {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += numbers[i];
		}

		return sum;
	}
	
	public static long forkJoinSum(long n) {
	    long[] numbers = LongStream.rangeClosed(1, n).toArray();
	    ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
	    return new ForkJoinPool().invoke(task);
	}

}
