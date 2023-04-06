package matrixCalc;

public class Frames {
	private AgeCounter[] frameCounterArray;
	private int[] framesPag;
	private int numFrames;
	private int frameDisponible;
	private int[] contadorCiclo;
	private int fallos;
	private int numFramesVacios;
	
	public Frames(int oNumFrames) {
		numFrames = oNumFrames;
		frameCounterArray = new AgeCounter[numFrames];
		framesPag = new int[numFrames];
		fallos = 0;
		numFramesVacios = oNumFrames;

		for (int i = 0;i<oNumFrames;i++)
		{
			framesPag[i] = -1;
			frameCounterArray[i] = new AgeCounter();
		}

		contadorCiclo = new int[numFrames];

		for (int i = 0;i<oNumFrames;i++)
		{
			contadorCiclo[i] = 0;
		}
	}
	public synchronized void insertPage(int nPage) {

		fallos+=1;

		if(numFramesVacios > 0)
		{
			for(int i = 0;i<numFrames;i++)
			{
				if(framesPag[i]==-1)
				{

					framesPag[i] = nPage;
					AgeCounter nuevoContador = new AgeCounter();
					frameCounterArray[i] = nuevoContador;
					contadorCiclo[i] = 1;
					numFramesVacios-=1;
					break;

				}
			}
		}

		if(numFramesVacios <= 0)
		{
			int frame = accederFrameDisponible(0, 0);
			framesPag[frame] = nPage;
			AgeCounter nuevoContador = new AgeCounter();
			frameCounterArray[frame] = nuevoContador;
			contadorCiclo[frame] = 1;
		}
	}

	public synchronized boolean inPagina(int nPage)
	{

		for(int i = 0;i<numFrames;i++)
		{
			if (framesPag[i] == nPage)
			{
				contadorCiclo[i] = 1;
				return true;
			}
		}
		return false;
	}

	public synchronized int accederFrameDisponible(int tipo, int pframe)
	{

		if (tipo == 0)
		{
			return frameDisponible;
		}
		else
		{
			frameDisponible = pframe;
		}
		return frameDisponible;
	}

	public synchronized void reiniciarContador() {

		for(int i = 0;i<numFrames;i++)
		{
			if(contadorCiclo[i]==1)
			{
				frameCounterArray[i].registerAccess(true);
			}
			else
			{
				frameCounterArray[i].registerAccess(false);
			}

			contadorCiclo[i] = 0;

		}
	}

	public synchronized int calcularFrame()
	{
		int menor = 256;
		int menorframe = 0;
		for (int i =0;i<numFrames;i++)
		{
			if(frameCounterArray[i].getValue()<=menor)
			{
				menor = frameCounterArray[i].getValue();
				menorframe = i;
			}
		}
		return menorframe;

	}

	public int getFallos() 
	{
		return fallos;
	}
	public AgeCounter[] getFrameCounterArray() {
		return frameCounterArray;
	}
	public void setFrameCounterArray(AgeCounter[] frameCounterArray) {
		this.frameCounterArray = frameCounterArray;
	}
	public int[] getFramesPag() {
		return framesPag;
	}
	public void setFramesPag(int[] framesPag) {
		this.framesPag = framesPag;
	}
	public int getNumFrames() {
		return numFrames;
	}
	public void setNumFrames(int numFrames) {
		this.numFrames = numFrames;
	}
	public int getFrameDisponible() {
		return frameDisponible;
	}
	public void setFrameDisponible(int frameDisponible) {
		this.frameDisponible = frameDisponible;
	}
	public int[] getContadorCiclo() {
		return contadorCiclo;
	}
	public void setContadorCiclo(int[] contadorCiclo) {
		this.contadorCiclo = contadorCiclo;
	}
	public void setFallos(int fallos) {
		this.fallos = fallos;
	}
}
