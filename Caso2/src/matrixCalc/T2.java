package matrixCalc;

public class T2 extends Thread{

    private Frames marcos;

    private int nfila;

    private int ncolumnas;

    private boolean fin;

    public T2(Frames marcos,int fila,int columnas) 
    {
        this.marcos = marcos;
        this.nfila = fila;
        this.ncolumnas = columnas;
    }

    public void Envejecimiento()
    {
        marcos.reiniciarContador();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (!fin)
        {
            fin = marcos.isFin();
            Envejecimiento();

        }
        
    }
    
}
