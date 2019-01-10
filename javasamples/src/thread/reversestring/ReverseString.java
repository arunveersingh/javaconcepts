package thread.reversestring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author arunveersingh
 *
 */
public class ReverseString {

	public static void main(String[] args) {

		// Defaults
		String string = "abcdefg";
		int numberOfParallelJobs = 10;
		System.out.println("parallel jobs= " + numberOfParallelJobs);

		// Input Length
		String[] alphabets = string.split("");
		System.out.println("input length= " + alphabets.length);

		// Part Length handled per thread. Last thread may have part of varying length.
		int partLength = alphabets.length / numberOfParallelJobs;
		System.out.println("partLength = " + partLength);

		// Thread pool
		ExecutorService service = Executors.newFixedThreadPool(numberOfParallelJobs);

		// Results from threads
		List<Future<Collector>> results = new ArrayList<>();

		for (int i = 0; i < numberOfParallelJobs; i++) {

			Future<Collector> future = null;
			Task task = null;
			if (i == numberOfParallelJobs - 1) {
				task = new Task(i, string.substring(i * partLength, alphabets.length));
			} else {
				task = new Task(i, string.substring(i * partLength, (i * partLength) + partLength));
			}

			System.out.println("Task to be submitted " + task.toString());
			future = service.submit(task);

			System.out.println("added a future in the list");
			results.add(future);

		}

		/*
		 * try { TimeUnit.SECONDS.sleep(10); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */

		String[] result = new String[numberOfParallelJobs];
		results.stream().forEach(e -> {
			try {
				System.out.println(e.get().toString());

				int index = e.get().getPartNumber();
				String part = e.get().getContent();

				result[index] = part;

			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
		});

		System.out.println("Result: ");
		for (int i = numberOfParallelJobs - 1; i >= 0; i--) {
			System.out.print(result[i]);
		}
		service.shutdown();
	}

}
