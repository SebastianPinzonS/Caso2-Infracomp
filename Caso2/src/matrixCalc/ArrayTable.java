package matrixCalc;

import java.util.*;


public class ArrayTable {
	
	Map<String, int[]> table;
	
	public ArrayTable() {
		table = new HashMap<String, int[]>();
	}
	
	public int[] getAddress(String key) {
		return table.get(key);
	}

	public void addAddress1(int ipag, int idespl, String elemento) {

		int[] values = new int[]{ipag,idespl};
		table.put(elemento, values);

	}

	public Map<String, int[]> getTable() {
		return table;
	}
}
