package matrixCalc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class MainTest {
	
	public static AgeCounter ageCounter = new AgeCounter();

  public static FileWriter myWriter;

  public  static int columnas;

  public  static int tentero;

  public  static int tpagina;

  public  static int nframes;

  public  static int nframes2;

  public static void main(String[] args) throws FileNotFoundException {
        
        PageTable paginas = new PageTable();

        Scanner myObj = new Scanner(System.in);

        System.out.println("Ingrese el nombre del archivo de entrada del modo 1 ( Porfavor guardar archivo a recorrer en la carpeta llamada data)");
        String archivoNombre = myObj.nextLine();

        System.out.println("Ahora dijite 1 si solo desea ejecutar el modo 1 o 2 si desea ejecutar el modo 2");
        Integer opcionModo = Integer.valueOf(myObj.nextLine());

        File myObj1 = new File("./data/" + archivoNombre);
        Scanner myReader = new Scanner(myObj1);

        int filas = 0;

        int columnas= 0;

        int tentero= 0;

        int tpagina= 0;

        int nframes= 0;

        while (myReader.hasNextLine()) {

          String data = myReader.nextLine();
          String[] tamaños = data.split("=");

          if (tamaños[0].equals("NF"))
          { 
            filas = Integer.valueOf(tamaños[1]);
          }

          if (tamaños[0].equals("NC"))
          {
            columnas = Integer.valueOf(tamaños[1]);
          }

          if (tamaños[0].equals("TE"))
          {
            tentero = Integer.valueOf(tamaños[1]);
          }

          if (tamaños[0].equals("TP"))
          {
            tpagina = Integer.valueOf(tamaños[1]);
          }

          if (tamaños[0].equals("MP"))
          {
            nframes = Integer.valueOf(tamaños[1]);
          }

        }

        paginas.CrearPaginas(filas, columnas, tentero, tpagina);

        ArrayTable tabla = paginas.getTablaPagina();
        Map<String, int[]> mapa = tabla.getTable();

        try {
          myWriter = new FileWriter("./data/Modo1.txt");
          PrintWriter printWriter = new PrintWriter(myWriter);
          printWriter.print("TP= " +tpagina+ "\n");
          printWriter.print("TE= " +tentero+ "\n");
          printWriter.print("NF= " +filas+ "\n");
          printWriter.print("NC= " +columnas+ "\n");
          printWriter.print("NR= " +mapa.size()+ "\n");
          printWriter.print("MP= " +nframes+ "\n");
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

        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }

        if (opcionModo == 1)
        {
          System.out.println("El archivo quedo guardado, en la carpeta data, bajo el nombre de Modo1.txt");
        }

        else{
            System.out.println("Ingrese el nombre del archivo de entrada del modo 2, si desea utilizar el archivo que genero el modo 1 Coloque solo 'Modo1.txt', sino coloque el nombre del archivo que requiera ( Porfavor guardar archivo a recorrer en la carpeta llamada data, sino es el generado por el modo 1). Ademas, escribir .txt al final del archivo");
            String archivoNombreModo2 = myObj.nextLine();

            File myObj2 = new File("./data/" + archivoNombreModo2);
            Scanner myReader2 = new Scanner(myObj2);
            while (myReader2.hasNextLine()) {

                String data = myReader2.nextLine();
                if(data.contains("=")==true)
                {

                    String[] tamaños = data.split("=");

                    if (tamaños[0].equals("MP"))
                    {
                      nframes2 = Integer.valueOf(tamaños[1].strip());
                      break;
                    }

                }

            }
            myReader2.close();
            Frames mainFrames = new Frames(nframes2);
            T1 t1 = new T1("./data/" + archivoNombreModo2,mainFrames);
            T2 t2 = new T2(mainFrames);
            t1.start();
            t2.start();

        }

    }
}
