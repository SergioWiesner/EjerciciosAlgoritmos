package ejercios.de.algoritmos;

import java.util.Scanner;

public class OrdenInsecionSeleccion {

    public static int u[] = new int[6];
    public static int v[] = new int[6];

    public OrdenInsecionSeleccion() {
    }

    public static int[] ordenanzaInsecion(int[] arreglo) {
        int x, j; // 2 pasos contastes 
        for (int i = 1; i < arreglo.length; i++) { //3 pasos
            x = arreglo[i]; // 1 paso
            j = i - 1; // 2 paso
            while (j > 0 && x < arreglo[j]) { // 2 paso
                arreglo[j + 1] = arreglo[j]; // 1 paso
                j--; // 1 paso
                arreglo[j + 1] = x; // 1 paso
            }
        }
        
        //ordenanzaInsecion = 2+3n+3n+n(2x+3x)
        
        return arreglo;
    }
    
    public static int[] ordenanzaSeleccion(int[] arreglo) {
        int minj, minx;
        for (int i = 1; i < arreglo.length - 1; i++) {
            minj = i;
            minx = arreglo[i];
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] < minx) {
                    minj = j;
                    minx = arreglo[j];
                    arreglo[minj] = arreglo[i];
                    arreglo[i] = minx;
                }
            }
        }
        return arreglo;
    }

    public static int[] ordenanzaSeleccionInternet(int[] arreglo){
    int i, j, menor, pos, tmp; // 5 pasos 
          for (i = 0; i < arreglo.length - 1; i++) {  // 4 pasos
                menor = arreglo[i]; // 1 paso
                pos = i; // 1 paso
                for (j = i + 1; j < arreglo.length; j++){ // 4 pasos
                      if (arreglo[j] < menor) { // 1 paso
                          menor = arreglo[j]; // 1 paso
                          pos = j;// 1 paso
                      }
                }
                if (pos != i){ // 1 paso
                    tmp = arreglo[i]; // 1 paso
                    arreglo[i] = arreglo[pos]; // 1 paso
                    arreglo[pos] = tmp; // 1 paso
                }
          }
          
        // ordenanzaSeleccion 5+7n+5x(2)+3  
          return arreglo;
    }
    
    public static void mostrarArray(int[] secencias) {
        String cadena = "[";
        for (int a = 0; a < secencias.length; a++) {
            if (secencias.length-1 == a) {
                cadena = cadena + String.valueOf(secencias[a]) + "]";
            } else {
                cadena = cadena + String.valueOf(secencias[a]) + ", ";
            }
        }
        System.out.println(cadena);
    }

    public static void main() {
        int[] u = {1, 2, 3, 4, 5, 6};
        int[] v = {6, 5, 4, 3, 2, 1};
        int[] w = {1, 1, 1, 1, 1, 1};
        int[] resultado;
        long startTime;

        System.out.println("1. Ordenanza por insecion.");
        System.out.println("2. Ordenanza por seleccion.");
        Scanner scan = new Scanner(System.in);
        int opc = scan.nextInt();
        switch (opc) {
            case 1:

                System.out.println("ordenado ....");
                OrdenInsecionSeleccion.mostrarArray(u);
                startTime = System.nanoTime();
                resultado = OrdenInsecionSeleccion.ordenanzaInsecion(u);
                System.out.println("Tiempo de ejecución -> " + String.valueOf(System.nanoTime() - startTime)+" nanosegundos");
                OrdenInsecionSeleccion.mostrarArray(resultado);

                System.out.println("desordenado ....");
                OrdenInsecionSeleccion.mostrarArray(v);
                startTime = System.nanoTime();
                resultado = OrdenInsecionSeleccion.ordenanzaInsecion(v);
                System.out.println("Tiempo de ejecución -> " + String.valueOf(System.nanoTime() - startTime)+" nanosegundos");
                OrdenInsecionSeleccion.mostrarArray(resultado);

                System.out.println("iguales ....");
                OrdenInsecionSeleccion.mostrarArray(w);
                startTime = System.nanoTime();
                resultado = OrdenInsecionSeleccion.ordenanzaInsecion(w);
                System.out.println("Tiempo de ejecución -> " + String.valueOf(System.nanoTime() - startTime)+" nanosegundos");
                OrdenInsecionSeleccion.mostrarArray(resultado);

                main();
                break;
            case 2:

                System.out.println("ordenado ....");
                OrdenInsecionSeleccion.mostrarArray(u);
                startTime = System.nanoTime();
                resultado = OrdenInsecionSeleccion.ordenanzaSeleccionInternet(u);
                System.out.println("Tiempo de ejecución -> " + String.valueOf(System.nanoTime() - startTime)+" nanosegundos");
                OrdenInsecionSeleccion.mostrarArray(resultado);

                System.out.println("desordenado ....");
                OrdenInsecionSeleccion.mostrarArray(v);
                startTime = System.nanoTime();
                resultado = OrdenInsecionSeleccion.ordenanzaSeleccionInternet(v);
                System.out.println("Tiempo de ejecución -> " + String.valueOf(System.nanoTime() - startTime)+" nanosegundos");
                OrdenInsecionSeleccion.mostrarArray(resultado);

                System.out.println("iguales ....");
                OrdenInsecionSeleccion.mostrarArray(w);
                startTime = System.nanoTime();
                resultado = OrdenInsecionSeleccion.ordenanzaSeleccionInternet(w);
                System.out.println("Tiempo de ejecución -> " + String.valueOf(System.nanoTime() - startTime)+" nanosegundos");
                OrdenInsecionSeleccion.mostrarArray(resultado);

                main();
                break;
            default:
                System.out.println("NO EXISTE ESTA OPCIÓN.");
                break;
        }
    }
}
