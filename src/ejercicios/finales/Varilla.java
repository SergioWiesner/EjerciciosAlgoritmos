package ejercicios.finales;

import java.util.Random;
import java.util.Scanner;

public class Varilla {

    public int longitud, corte;
    public int[][] tabladeprecios = {{1,2,3,4,5,6,7,8,9,10},{1, 5, 8, 9, 10, 17, 17, 24, 30, 35}};
    public Scanner in;

    public Varilla() {
        this.in = new Scanner(System.in);
    }

    public void init() {
        System.out.println("\t EJERCICIO DE LA VARILLA \t \n\n\n");
        System.out.println("ingrese el tamaño de la varialla");
        this.longitud = in.nextInt();
        int[][] memoria;
        memoria = new int[(this.longitud+1)][(this.longitud+1)];
        mostrarTablas();
        memoria = corteOptimoDinamico(memoria);
        mostarTablaPrecios(memoria);
    }

    public void mostrarTablas() {
        String muestra = "\n\n[Longitud]\t";
        for (int a = 0; a < this.tabladeprecios.length; a++) {
            for (int b = 0; b < this.tabladeprecios[a].length; b++) {
            muestra += "[" + this.tabladeprecios[a][b] + "]\t";
        }
            if (a == 0) {
                muestra += "\n[Precio]\t";
            }
        }
        System.out.println(muestra + "\n");
    }

    public int[][] corteOptimoDinamico(int[][] memoria) {
        for (int a = 0; a < memoria.length; a++) { // hacia abajo            
            for (int b = 0; b < memoria.length; b++) { //hacia la derecha                
                if (a == 0) {
                    memoria[a][b] = (this.tabladeprecios[1][a] * (b+1));
                } else {
                    int mayor = memoria[(a - 1)][b];
                    int prec = 0;
                    int longitud = b;
                    
                    for(int d = a;d >= 0; d--){
                        boolean bandera = true;
                        while (bandera == true) {
                            if ((longitud - d) >= 0) {
                                prec += this.tabladeprecios[1][d];
                                System.out.println("longitud de " + longitud + " y corta por = "+this.tabladeprecios[0][d]+" y precio acumulado " + prec + " precio unitario " + this.tabladeprecios[1][d]);
                                longitud -= this.tabladeprecios[0][d];                            
                            }else {
                                bandera = false;
                            }
                        }

                        if (mayor < prec) {
                            mayor = prec;
                       //     System.out.println("----> en la posicion a = " + a + " y b = " + b + " va el precio " + mayor);
                        }
                    }
                    System.out.println("En la posicion a = " + a + " y b = " + b + " se agrega el mayor = " + mayor+"\n");
                    memoria[a][b] = mayor;                   
                }
            }
        }
        return memoria;
    }

    public void mostarTablaPrecios(int[][] memoria) {
        String muestra = "\n\nCor\\Lon\t";
        for (int d = 0; d < memoria.length; d++) {
            muestra += "Lon " + (d + 1) + "\t";
        }
        muestra += "\n";
        for (int a = 0; a < memoria.length; a++) {
            muestra += (a + 1) + " corte\t";
            for (int b = 0; b < memoria.length; b++) {
                muestra += "[" + memoria[a][b] + "]\t";
            }
            muestra += "\n";
        }
        System.out.println(muestra + "\n");
    }

}
