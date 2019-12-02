package ejercicios.finales;

import java.util.Random;
import java.util.Scanner;

public class Varilla {

    public int longitud, corte;
    public int[] tabladeprecios = {1, 5, 8, 9, 10, 17, 17, 24, 30};
    public int[][] memoria;
    public Scanner in;

    public Varilla() {
        this.in = new Scanner(System.in);
    }

    public void init() {
        System.out.println("\t EJERCICIO DE LA VARILLA \t \n\n\n");
        System.out.println("ingrese el tamaño de la varialla");
        this.longitud = in.nextInt();
        this.memoria = new int[this.longitud][this.longitud];
        mostrarTablas();
        corteOptimoDinamico();
        mostarTablaPrecios();
    }

    public void mostrarTablas() {
        String muestra = "\n\n[Precio]\t";
        for (int a = 0; a < this.tabladeprecios.length; a++) {
            muestra += "[" + this.tabladeprecios[a] + "]\t";
        }
        System.out.println(muestra + "\n");
    }

    public void corteOptimoDinamico() {

        for (int a = 0; a < this.memoria.length; a++) { // hacia abajo            
            for (int b = 0; b < this.memoria.length; b++) { //hacia la derecha                
                if (a == 0) {
                    this.memoria[a][b] = (this.tabladeprecios[a] * (b + 1));
                } else {
                    int mayor = this.memoria[(a - 1)][b];
                    int prec = 0;
                    int longitud = b;

                    for (int d = a; d > 0; d--) {
                        boolean bandera = true;
                        while (bandera == true) {
                            if ((longitud - d) >= 0) {
                                prec += this.tabladeprecios[(d - 1)];
                                //System.out.println("longitud de " + longitud + " en b = " + b + " y d = " + d + " y precio acumulado " + prec + " precio unitario " + this.tabladeprecios[(d - 1)]);
                                longitud -= d;
                            } else {
                                bandera = false;
                            }
                        }

                        if (mayor < prec) {
                            mayor = prec;
                            System.out.println("en la posicion a = " + a + " y b = " + b + " va el precio " + mayor);
                        }
                    }
                    
                        this.memoria[a][b] = mayor;                   
                }
            }
        }
    }

    public void mostarTablaPrecios() {
        String muestra = "\n\nCor\\Lon\t";
        for (int d = 0; d < this.memoria.length; d++) {
            muestra += "Lon " + (d + 1) + "\t";
        }
        muestra += "\n";
        for (int a = 0; a < this.memoria.length; a++) {
            muestra += (a + 1) + " corte\t";
            for (int b = 0; b < this.memoria.length; b++) {
                muestra += "[" + this.memoria[a][b] + "]\t";
            }
            muestra += "\n";
        }
        System.out.println(muestra + "\n");
    }

}
