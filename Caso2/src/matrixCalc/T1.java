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
                String[] pvirtual = data.split(",");

                int npagina = Integer.valueOf(pvirtual[3]);

                if (marcos.inPagina(npagina)==false)
                {
                    marcos.insertPage(npagina);
                    String valor = " ";
                    for (int numero:marcos.getFramesPag())
                    {
                        valor += numero + ",";
                    }
                    System.out.println(valor + ":  " + marcos.getFallos() + "   pag: " + npagina + data);
                }

                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            myReader.close();
            } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
