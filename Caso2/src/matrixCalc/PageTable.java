package matrixCalc;

import java.util.ArrayList;

public class PageTable {

    private ArrayList<Page> listPag;
    private int paginaActualIndice = 0;
    private int desplazamientoPaginaActual = 0;
    private Page paginaActual;
    private int entero;
    private int paginaTamano;

    public PageTable(int oEntero, int oPaginaTamano){
        entero = oEntero;
        paginaTamano = oPaginaTamano;
    }

    public int[] insertarAPagina(int oRow, int oColumn){
        if( desplazamientoPaginaActual == 0){
            paginaActual = new Page(paginaTamano/entero);
            listPag.add(paginaActual);
        }
        boolean resultado = paginaActual.putValue(oRow, oColumn);
        if (!resultado){
            desplazamientoPaginaActual = 0;
            paginaActualIndice++;
            return null;
        }
        int[] respuesta = new int[2];
        respuesta[0] = paginaActualIndice;
        respuesta[1] = desplazamientoPaginaActual;
        desplazamientoPaginaActual += entero;
        return respuesta;
    }

}
