package ejercicios.finales;

import java.util.Random;
import java.util.Scanner;

public class Varilla {

    public int longitud, corte;
    public int[][] tabladeprecios;
    public int[] memoria;
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
        this.memoria = new int[(this.longitud * 2)];
        cargarTablaPreciosAutomatico();
        //cargarTablaPreciosManual();
        mostrarTablas(this.tabladeprecios);
        buscarCorteOptimo();
        mostarTablaPrecios();
    }

    public void cargarTablaPreciosAutomatico() {
        this.tabladeprecios = new int[2][this.longitud];
        int variable = 0;
        for (int a = 0; a < this.longitud; a++) {
            this.tabladeprecios[0][a] = a + 1;
            if (a > 0) {
                variable = obtenerValor(a, this.tabladeprecios[1][a - 1]);
            } else {
                variable = obtenerValor(a, this.tabladeprecios[1][a]);
            }
            this.tabladeprecios[1][a] = variable;
        }
    }

    public void cargarTablaPreciosManual() {
        this.tabladeprecios = new int[2][this.longitud];
        int variable = 0;
        for (int a = 0; a < this.longitud; a++) {
            System.out.println("Ingrese el valor para el corte de varilla de tamaño " + (a + 1));
            this.tabladeprecios[0][a] = a + 1;
            this.tabladeprecios[1][a] = this.in.nextInt();
        }
    }

    public int obtenerValor(int semilla, int valoranterior) {
        Random r = new Random((semilla));
        int variable = r.nextInt((int) Math.round((valoranterior + 1) * 1.2));

        if (variable <= valoranterior) {
            variable = obtenerValor((semilla), (valoranterior + 2));
        }

        return variable;
    }

    public void mostrarTablas(int[][] tabla) {
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

    public void buscarCorteOptimo() {
        // inicia la busqueda de convinaciones a partir de cortes de 1 
        for (int z = 0; z < this.longitud; z++) {

            System.out.println("Convinacion " + (z + 1));
            // inicia el acumulado a partir del indice de cortes en donde vaya
            int acumulado = this.tabladeprecios[0][z];

            System.out.println("Suma una pieza de corte " + this.tabladeprecios[0][z]);

            // inicia el precio a partir del corte en que vaya
            int precio = this.tabladeprecios[1][z];
            
            System.out.println("Numero de convinaciones de "+z+" por esa longitud "+this.longitud);
            for (int a = 0; a < this.longitud; a++) {
                // inicia convinacion de cortes
                while ((acumulado + this.tabladeprecios[0][a]) <= this.longitud) {
                    acumulado += this.tabladeprecios[0][a];
                    precio += this.tabladeprecios[1][a];
                    System.out.println("Suma una pieza de corte " + this.tabladeprecios[0][a]);
                }
            }
            System.out.println("\nAcumulado de precio " + precio + "\n\n");
            this.memoria[this.globalindice++] = precio;
        }
    }

    public void mostarTablaPrecios() {
        int preciomax = this.memoria[0];
        int conviacion = 0;
        String muestra = "\n\nCONVINA\t";
        for (int b = 0; b < this.memoria.length; b++) {
            muestra += " " + (b + 1) + "\t";
        }

        muestra += "\nPRECIOS\t";
        for (int a = 0; a < this.memoria.length; a++) {
            muestra += " " + this.memoria[a] + "\t";
            if (this.memoria[a] > preciomax) {
                preciomax = this.memoria[a];
                conviacion = a;
            }
        }
        System.out.println(muestra + "\n");
        System.out.println("LA CONVIANCION " + (conviacion + 1) + " POSEE EL MAYOR PRECIO, EL PRECIO ES -> " + preciomax + "\n");
    }


}
