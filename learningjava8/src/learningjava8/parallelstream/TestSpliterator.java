package learningjava8.parallelstream;

public class TestSpliterator {

	public static void main(String[] args) {
		
		final String SENTENCE =
	            " Nel   mezzo del cammin  di nostra  vita " +
	            "mi  ritrovai in una  selva oscura" +
	            " ché la  dritta via era   smarrita ";

		System.out.println(countWordsIteratively(SENTENCE));
	}

	private static int countWordsIteratively(String txt) {

		// using char by char method intentionally
		char[] chars = txt.trim().toCharArray();
		int word = 0;
		char now = ' ';
		char previous = ' ';
		for (int i = 0; i < chars.length; i++) {
			now = chars[i];
			if (i == 0) {
				now = chars[i];
				previous = ' ';
			} else {
				now = chars[i];
				previous = chars[i - 1];
			}

			if (now == ' ' && previous != ' ') {
				word++;

			}

		}

		return word+1;

	}

}
