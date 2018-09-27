package learningjava8.defaultmethods;


/**
 * 9.3.2. Multiple inheritance of behavior
 * @author SinghAru
 *
 */
public class TestMultipleInherBehav implements Resizable {

	public static void main(String[] args) {

	}
	
	public void test() {
	 Resizable.super.setRealativeSize (1, 2);
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setAbsoluteSize(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

}
