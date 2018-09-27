package learningjava8.defaultmethods;

import java.util.List;

public class Utils {

	public static void paint(List<Resizable> resizableShapes) {
		resizableShapes.forEach(r -> {
			r.setAbsoluteSize(42, 42);
			//r.draw();
		});

	}

}
