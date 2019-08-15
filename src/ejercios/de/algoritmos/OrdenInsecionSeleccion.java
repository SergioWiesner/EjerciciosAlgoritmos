package ejercios.de.algoritmos;

import sun.tools.jar.Main;

/**
 *
 * @author PC-47050
 */
public class OrdenInsecionSeleccion {

    public int u[] = new int[6];
    public int v[] = new int[6];

    public OrdenInsecionSeleccion() {
        int[] u = {1, 2, 3, 4, 5, 6};
        int[] v = {6, 5, 4, 3, 2, 1};
    }

    public static int[] ordenanzaInsecion(int[] arreglo) {
        int i = 2;
        int x = arreglo[i];
        int j = i - 1;
        
        while (j > 0 && x < arreglo[j]) {
            arreglo[j + 1] = arreglo[j];
            j--;
            arreglo[j + 1] = x;
        }
        
        return arreglo;
    }

    public static void ordenanzaSeleccion(int[] arreglo) {
        int i = 1;
        int minj = 1;
        
    }
    
    public static void main(String args[]){
        
    }
}
