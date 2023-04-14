package matrixCalc;

public class T2 extends Thread{

    private Frames marcos;

    private boolean fin;

    public T2(Frames marcos) 
    {
        this.marcos = marcos;
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
