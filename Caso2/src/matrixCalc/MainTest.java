package matrixCalc;

import java.util.Map;
import java.util.TreeMap;

public class MainTest {
	
	public static AgeCounter ageCounter = new AgeCounter();
	
	public static void main(String[] args) {
        
        PageTable paginas = new PageTable();

        paginas.CrearPaginas(8, 8, 4, 256);

        ArrayTable tabla = paginas.getTablaPagina();
        Map<String, int[]> mapa = tabla.getTable();
        Map<String, int[]> sortedMap = new TreeMap<>(mapa);
        for (java.util.Map.Entry<String, int[]> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " tiene " + entry.getValue()[0] + "," + + entry.getValue()[1]);
          }
    }
}
