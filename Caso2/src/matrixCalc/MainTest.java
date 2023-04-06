package matrixCalc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainTest {
	
	public static AgeCounter ageCounter = new AgeCounter();

  public static FileWriter myWriter;
	
	public static void main(String[] args) {
        
        PageTable paginas = new PageTable();

        Scanner myObj = new Scanner(System.in);

        System.out.println("Ingrese numero de filas");
        Integer filas = Integer.valueOf(myObj.nextLine());

        System.out.println("Ingrese numero de columnas");
        Integer columnas = Integer.valueOf(myObj.nextLine());

        System.out.println("Ingrese numero de tamaño de entero");
        Integer tentero = Integer.valueOf(myObj.nextLine());

        System.out.println("Ingrese numero de tamaño de pagina");
        Integer tpagina = Integer.valueOf(myObj.nextLine());

        System.out.println("Ingrese numero de marcos de pagina");
        Integer nframes = Integer.valueOf(myObj.nextLine());

        paginas.CrearPaginas(filas, columnas, tentero, tpagina);

        ArrayTable tabla = paginas.getTablaPagina();
        Map<String, int[]> mapa = tabla.getTable();

        try {
          myWriter = new FileWriter("Modo1.txt");
          PrintWriter printWriter = new PrintWriter(myWriter);
            for(int i=0;i<filas;i++)
            {
              for(int j=0;j<columnas;j++)
              {
                for(int k=1;k<4;k++)
                {
                  String key = "[" + k + "," + i + "," + j + "]";
                  int[] value = mapa.get(key);
                  printWriter.print(key+"," + value[0] + "," + + value[1] + "\n");
                }
              }
            }
          printWriter.close();
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }

        Frames mainFrames = new Frames(nframes);
        T1 t1 = new T1("Modo1.txt",mainFrames);
        T2 t2 = new T2(mainFrames);
        t1.start();
        t2.start();

        try {
          t1.join();
          System.out.println(mainFrames.getFallos());
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
    }
}
