package ejercicios.finales;

import java.util.Random;
import java.util.Scanner;

public class Varilla {

    public int longitud, corte;
    public int[] tabladeprecios = {1, 5, 8, 9, 10, 17, 17, 24, 30};
    public int[][] memoria;
    public int globalindice;
    public Scanner in;

    public Varilla() {
        this.in = new Scanner(System.in);
    }

    public void init() {
        System.out.println("\t EJERCICIO DE LA VARILLA \t \n\n\n");
        System.out.println("ingrese el tamaño de la varialla");
        this.longitud = in.nextInt();
        this.globalindice = 0;
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
            for (int b = 0, c = 1; b < this.memoria.length; b++, c++) { //hacia la derecha                
                if (a == 0) {
                    this.memoria[a][b] = (this.tabladeprecios[a] * c);
                } else {
                    int mayor = this.memoria[(a - 1)][b];
                    int indice = 0; // corre hacia abajo                     
                    while (indice <= b) {
                        int prec = 0;
                        int corte = 0;

                        for (int d = 0, z = 1; d < b; d++, z++) {
                            while (corte < b) {                 
                                if(corte < b){
                                 prec = prec + this.tabladeprecios[z]; 
                                }
                                corte += z;
                            }
                            if (mayor < prec) {
                                mayor = prec;
                            }
                        }

                        indice++;
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
