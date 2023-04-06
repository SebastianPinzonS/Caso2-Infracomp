package matrixCalc;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class T2 extends Thread{

    private Frames marcos;

    public T2(Frames marcos) 
    {
        this.marcos = marcos;
    }

    @Override
    public void run() {

        marcos.reiniciarContador();
        int disponible = marcos.calcularFrame();
        marcos.accederFrameDisponible(1, disponible);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
