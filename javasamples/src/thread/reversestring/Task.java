package thread.reversestring;

import java.util.concurrent.Callable;

public class Task implements Callable<Collector> {

	private int taskId;
	private String stringPart;

	public Task(int taskId, String stringPart) {
		this.taskId = taskId;
		this.stringPart = stringPart;
	}

	@Override
	public Collector call() throws Exception {

		return new Collector(taskId, new StringBuffer(stringPart).reverse().toString());
	}

	@Override
	public String toString() {
		return "Task [ " + " taskId= " + taskId + " stringPart= " + stringPart + "]";
	}

}
