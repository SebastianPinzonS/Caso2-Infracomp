package matrixCalc;

public class Page {
	private int[] pageArray;
	private int intSize;
	private int disponible;
	
	public Page(int oIntSize, int pageSize ) {
		intSize = oIntSize;
		pageArray = new int[pageSize/intSize];
		disponible = pageSize/oIntSize;
	}
	public int getValue(int index) {
		return pageArray[index/ intSize];
	}
	
	public boolean putValue(int index, int value) {
		if(disponible>0)
		{

			pageArray[index/ intSize] = value;
			disponible -=1;
			return true;

		}

		else
		{

			return false;

		}
	}

}
