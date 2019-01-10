package thread.reversestring;

/**
 * Collect the response from a thread which can be further used to build
 * complete response.
 * 
 * @author arunveersingh
 *
 */
public class Collector {

	private int partNumber;

	private String content;
	
	public Collector(int partNumber, String content) {
		this.partNumber = partNumber;
		this.content = content;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public String getContent() {
		return content;
	}
	
	@Override
	public String toString() {
		return "Collector [ " + " taskId= " + partNumber + " stringPart= " + content + "]";
	}

}
