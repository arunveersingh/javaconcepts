package learningjava8.newfeatures.functionsinjava;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * this class demonstrates the usage of method reference and lambdas in place of anonymous class.
 * @author SinghAru
 *
 */
public class ListHiddenFiles {

	public static void main(String[] args) {

		File[] hiddenFilesUsingAnonyClass = new File(".").listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isHidden();
			}
		});

		// FileFilter filter = pathname -> pathname.isHidden(); // Lambda
		// FileFilter filter = File::isHidden; // Method reference

		File[] hiddenFilesUsingLambda = new File(".").listFiles(pathname -> pathname.isHidden());

		File[] hiddenFilesUsingMethodRef = new File(".").listFiles(File::isHidden);

		Arrays.asList(hiddenFilesUsingAnonyClass).stream().forEach(file -> System.out.println(file.getName()));
		
		Arrays.asList(hiddenFilesUsingLambda).stream().forEach(file -> System.out.println(file.getName()));
		
		Arrays.asList(hiddenFilesUsingMethodRef).stream().forEach(file -> System.out.println(file.getName()));

	}

}
