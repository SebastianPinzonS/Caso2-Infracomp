package matrixCalc;

public class Page {
	private int[] pageArray;
	private int intSize;
	private int disponible;
	
	public Page(int pageSize ) {
		pageArray = new int[pageSize];
		disponible = pageSize;
	}
	public int getValue(int index ) {
		return pageArray[index];
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
