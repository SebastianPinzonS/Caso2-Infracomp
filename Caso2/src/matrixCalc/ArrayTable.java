package matrixCalc;

import java.util.*;


public class ArrayTable {
	Map<String, int[]> table;
	
	public ArrayTable() {
		table = new HashMap<String, int[]>();
	}
	
	public void addAddress(int matrix, int row, int column) {
		String address = (matrix + "-" + row + "-" + column);
		int[] values = new int[]{row,column};
		table.put(address, values);
	}
	
	public int[] getAddress(String key) {
		return table.get(key);
	}
}
