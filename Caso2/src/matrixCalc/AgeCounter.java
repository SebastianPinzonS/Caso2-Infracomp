package matrixCalc;

public class AgeCounter {

	public int[] counter;
	
	public AgeCounter() {
		counter = new int[8];
		counter[0]=1;
		for(int i = 1; i<8; i++) {
			counter[i]=0;
		}
	}
	
	public void registerAccess(boolean accessState) {
		for (int i=7; i>0; i--) {
			counter[i]=counter[i-1];
		}
		if(accessState) {
			counter[0]=1;	
		} else {
			counter[0]=0;

		}
	}
	
	public void registerNonAccess() {
		for (int i=7; i>0; i--) {
			counter[i]=counter[i-1];
		}
		counter[0]=0;
	}
	
	public int getValue() {
		int value = 0;
		for(int i=0; i<8; i++ ) {
			if(counter[7-i] != 0) {
			value = value + (int)Math.pow(counter[7-i]*2, (double)i);
			}
		}
		return value;
	}		
}
