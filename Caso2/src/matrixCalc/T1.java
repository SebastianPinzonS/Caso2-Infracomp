package matrixCalc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class T1 extends Thread{

    public String direccion;
    private Frames marcos;

    public T1(String direccion, Frames marcos) 
    {
        this.direccion = direccion;
        this.marcos = marcos;
    }
    
    @Override
    public void run() {
        
        try {
            File myObj = new File(direccion);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                if(data.contains("=")==false)
                {

                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    String[] pvirtual = data.split(",");

                    int npagina = Integer.valueOf(pvirtual[3].strip());

                    if (marcos.inPagina(npagina)==false)
                    {
                        marcos.insertPage(npagina);
                    }

                }

            }
            myReader.close();
            marcos.setFin(true);
            System.out.println("Numero de fallos de pagina = "+marcos.getFallos());
            } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
