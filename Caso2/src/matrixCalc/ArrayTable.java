package matrixCalc;

import java.util.*;


public class ArrayTable {
	private PageTable pageTable = new PageTable(0, 0);
	Map<String, int[]> table;
	
	public ArrayTable() {
		table = new HashMap<String, int[]>();
	}
	
	public String addAddress(int matrix, int row, int column) {
		String address = (matrix + "-" + row + "-" + column);
		int[] values = null;
		while(values == null){
		values = pageTable.insertarAPagina(row,column);
		}
		table.put(address, values);
		String finalAddress = ("[" + address + "]" + " " + values[0] + ", " + values[1] );
		return finalAddress;
	}
	
	public int[] getAddress(String key) {
		return table.get(key);
	}
}
