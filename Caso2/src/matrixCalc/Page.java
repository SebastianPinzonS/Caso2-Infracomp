package matrixCalc;

public class Page {
	private int[] pageArray;
	private int intSize;
	
	public Page(int oIntSize, int pageSize ) {
		intSize = oIntSize;
		pageArray = new int[pageSize/intSize];
	}
	public int getValue(int index) {
		return pageArray[index/ intSize];
	}
	
	public void putValue(int index, int value) {
		pageArray[index/ intSize] = value;
	}

}
