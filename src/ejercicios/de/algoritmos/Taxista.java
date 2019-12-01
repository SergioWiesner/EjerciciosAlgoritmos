/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.de.algoritmos;

import java.util.Scanner;

/**
 *
 * @author webdev
 */
public class Taxista {

    String[][] mapa;
    Scanner in;

    public Taxista() {
        in = new Scanner(System.in);

    }

    public void inicio() {
        int[] coordenadasinicio;
        int[] coordenadasfin;
        System.out.println("\n\n\n\t EJERCICIO DE ALGORITMOS \t \n\n\n");
        iniciarMapa();
        coordenadasinicio = puntoInicial();
        coordenadasfin = puntoFinal();
        int cantidadcaminos = generarCaminos(coordenadasinicio[0], coordenadasinicio[1], coordenadasfin);
        System.out.println("Cantidad de caminos ->" + cantidadcaminos);
        inicio();
    }

    public void iniciarMapa() {
        try {
            System.out.println("Ingrese Tamaño del mapa.\n");
            System.out.println("Ingrese ancho.");
            int ancho = in.nextInt();
            System.out.println("Ingrese alto.");
            int alto = in.nextInt();
            mapa = new String[ancho][alto];
            mostrar(mapa);
        } catch (Exception e) {
            System.out.println("No se pudo inicializar el mapa. -> " + e.getMessage());
            puntoInicial();
        }
    }

    public int[] puntoInicial() {
        int[] punto = new int[2];
        try {
            System.out.println("Ingrese punto de inicio.\n");
            System.out.println("Ingrese latitud ->.");
            int latitud = in.nextInt();
            System.out.println("                 |");
            System.out.println("Ingrese longitud v");
            int longitud = in.nextInt();
            mapa[latitud][longitud] = "[*]";
            mostrar(mapa);
            punto[0] = latitud;
            punto[1] = longitud;
        } catch (Exception e) {
            System.out.println("No se pudo agregar el punto inicial. -> " + e.getMessage());
            puntoInicial();
        }
        return punto;
    }

    public int[] puntoFinal() {
        int[] punto = new int[2];
        try {
            System.out.println("Ingrese punto de fin.\n");
            System.out.println("Ingrese latitud ->.");
            int latitud = in.nextInt();
            System.out.println("                 |");
            System.out.println("Ingrese longitud v");
            int longitud = in.nextInt();
            mapa[latitud][longitud] = "[*]";
            mostrar(mapa);
            punto[0] = latitud;
            punto[1] = longitud;
        } catch (Exception e) {
            System.out.println("No se pudo agregar el punto fianl. -> " + e.getMessage());
            puntoInicial();
        }
        return punto;
    }

    public int generarCaminos(int iniciox, int inicioy, int[] puntofinal) {
        int ejex = 0;
        int ejey = 0;

        if (iniciox == puntofinal[0] && inicioy == puntofinal[1]) {
            return 1;
        }
        if ((iniciox + 1) <= puntofinal[0]) {
            ejex = generarCaminos((iniciox + 1), inicioy, puntofinal);
        }

        if ((inicioy + 1) <= puntofinal[1]) {
            ejey = generarCaminos((iniciox), (inicioy + 1), puntofinal);
        }
        return ejex + ejey;
    }

    public void mostrar(String[][] matriz) {
        try {
            String muestra = "";
            for (int d = 0; d < matriz.length; d++) {
                for (int e = 0; e < matriz[d].length; e++) {
                    if (matriz[d][e] != null) {
                        muestra += matriz[d][e];
                    } else {
                        muestra += "[ ]";
                    }
                }
                muestra += "\n";
            }
            System.out.println(muestra);
        } catch (Exception e) {
            System.out.println("No se pudo mostrar el mapa, se reiniciara. -> " + e.getMessage());
            inicio();
        }
    }

}
