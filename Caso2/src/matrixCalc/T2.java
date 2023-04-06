package matrixCalc;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class T2 extends Thread{

    private Frames marcos;

    private int nfila;

    private int ncolumnas;

    public T2(Frames marcos,int fila,int columnas) 
    {
        this.marcos = marcos;
        this.nfila = fila;
        this.ncolumnas = columnas;
    }

    @Override
    public void run() {

        int i = 0;
        while (i<nfila*ncolumnas)
        {

            marcos.reiniciarContador();
            int disponible = marcos.calcularFrame();
            marcos.accederFrameDisponible(1, disponible);
            try {
                this.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            i++;

        }
        
    }
    
}
