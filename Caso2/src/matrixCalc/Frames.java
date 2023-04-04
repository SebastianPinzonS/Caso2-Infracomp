package matrixCalc;

public class Frames {
	private Page[] frameArray;
	private AgeCounter[] frameCounterArray;
	private int currentAvailable;
	private int numFrames;
	
	public Frames(int oNumFrames) {
		numFrames = oNumFrames;
		frameArray = new Page[numFrames];
		frameCounterArray = new AgeCounter[numFrames];
		currentAvailable = numFrames;
	}
	public boolean insertPage(Page newPage) {
		if (currentAvailable > 0) {
			frameArray[numFrames - currentAvailable] = newPage;
			return true;
		}
		return false;
	}
}
