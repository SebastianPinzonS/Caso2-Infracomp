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

        Integer filas = 16;

        Integer columnas = 16;

        Integer tentero = 4;

        Integer tpagina = 256;

        Integer nframes = 4;

        paginas.CrearPaginas(filas, columnas, tentero, tpagina);

        ArrayTable tabla = paginas.getTablaPagina();
        Map<String, int[]> mapa = tabla.getTable();

        Frames mainFrames = new Frames(nframes);
        T1 t1 = new T1("Modo1.txt",mainFrames);
        T2 t2 = new T2(mainFrames,filas,columnas);
        t1.start();
        t2.start();

    }
}
