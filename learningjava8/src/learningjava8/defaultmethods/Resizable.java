package learningjava8.defaultmethods;

public interface Resizable {
	
	int getWidth();
	int getHeight();
	int setWidth();
	int setHeight();
	int setAbsoluteSize(int x, int y);
	default int setRealativeSize(int wFactor, int hFactor) {
		return setAbsoluteSize(getWidth() / wFactor, getHeight() / hFactor);
	}

}
