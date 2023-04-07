package matrixCalc;

import java.util.Arrays;

public class Frames {
	private AgeCounter[] frameCounterArray;
	private int[] framesPag;
	private int numFrames;
	private int frameDisponible;
	private int[] contadorCiclo;
	private int fallos;
	private boolean fin;
	
	public Frames(int oNumFrames) {

		numFrames = oNumFrames;
		frameCounterArray = new AgeCounter[numFrames];
		framesPag = new int[numFrames];
		fallos = 0;
		fin = false;

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

		int posicionVacio = -1;

		for (int i = 0; i < framesPag.length; i++) {
			if (framesPag[i] == -1) {
				posicionVacio = i;
				break;
			}
		}

		if(posicionVacio!=-1)
		{
			framesPag[posicionVacio] = nPage;
			AgeCounter nuevoContador = new AgeCounter();
			frameCounterArray[posicionVacio] = nuevoContador;
			contadorCiclo[posicionVacio] = 1;
		}

		else
		{
			int frameDisponible = calcularFrame();
			framesPag[frameDisponible] = nPage;
			AgeCounter nuevoContador = new AgeCounter();
			frameCounterArray[frameDisponible] = nuevoContador;
			contadorCiclo[frameDisponible] = 1;
		}
	}

	public boolean inPagina(int nPage)
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

	public void accederFrameDisponible(int tipo, int pframe)
	{
		frameDisponible = pframe;
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

	public int calcularFrame()
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



	public int[] getContadorCiclo() {
		return contadorCiclo;
	}



	public boolean isFin() {
		return fin;
	}



	public void setFrameCounterArray(AgeCounter[] frameCounterArray) {
		this.frameCounterArray = frameCounterArray;
	}



	public void setFrameDisponible(int frameDisponible) {
		this.frameDisponible = frameDisponible;
	}



	public void setContadorCiclo(int[] contadorCiclo) {
		this.contadorCiclo = contadorCiclo;
	}



	public void setFallos(int fallos) {
		this.fallos = fallos;
	}



	public void setFin(boolean fin) {
		this.fin = fin;
	}
}
