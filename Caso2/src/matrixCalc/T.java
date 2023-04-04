package matrixCalc;

public class T extends Thread {

    private int type;
    private int numRows;
    private int numColumns;
    private ArrayTable arrayTable;

    public T(int oType){
        type = oType;
    }

    public void run(){
        if(type == 0){
            for(int matrix = 0; matrix < 3; matrix++){
                for(int row = 0; row < numRows; row++ ){
                    for(int column = 0; column < numColumns; column++){
                        System.out.println(arrayTable.addAddress(matrix,row,column));
                    }
                }
                
            }
        }
    }
    
}
