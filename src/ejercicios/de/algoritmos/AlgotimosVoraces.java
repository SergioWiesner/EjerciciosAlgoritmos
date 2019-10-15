/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.de.algoritmos;

import java.util.Scanner;
import java.util.Random;
import java.security.SecureRandom;
import static ejercicios.de.algoritmos.OrdenInsecionSeleccion.ordenanzaSeleccionInternet;
import utilidades.Figuras;

/**
 *
 * @author sergio
 */
public class AlgotimosVoraces {

    public void menu() {
        int opc = 0;
        try {
            System.out.println("\t MENU DE ALGORITMOS VORACES \t \n\n\n");
            System.out.println("1. Ejercicio corrupción votantes.");
            System.out.println("2. Ejercicio tablero fichas.");
            Scanner scan = new Scanner(System.in);
            opc = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Error al ingresar el numero");
            menu();
        }
        switch (opc) {
            case 1:
                corrupcionVotantes();
                break;
            case 2:
                tableroFichas();
                break;
            default:
                break;
        }
    }

    public void corrupcionVotantes() {

        int candidatos, candidatoganar, votantes, lumbral, lum, g, intent, sumatoria;
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese a continuación la cantidad de votantes:");
        votantes = scan.nextInt();
        System.out.println("Ingrese a continuación la cantidad de candidatos:");
        candidatos = scan.nextInt();

        // DECLARACIÓN DE ELEMNTOS NECESARIOS
        int[][] tablero = new int[votantes][candidatos];
        int[][] mapa = new int[4][votantes];
        int[] valorcompra = new int[votantes];
        // Rellenar matriz con las intenciones de voto
        Random aleatorio = new Random(System.currentTimeMillis());
        try {
            for (int a = 0; a < votantes; a++) {
                sumatoria = 0;
                for (int b = 0; b < candidatos; b++) {
                    // Genera un numero entre 0 y 100
                    intent = 0;
                    if (b == 0) {
                        intent = aleatorio.nextInt(100);
                    } else if ((candidatos - 1) == b) {
                        intent = (100 - sumatoria);
                    } else {
                        intent = aleatorio.nextInt(100 - tablero[a][b - 1]);
                    }

                    sumatoria += intent;
                    tablero[a][b] = intent;

                }
                mapa[0][a] = a; // ASIGNANDO EL ID DEL VOTANTE
                mapa[1][a] = aleatorio.nextInt(101); // PRESUPUESTO POR VOTANTE
            }
        } catch (Exception e) {
            System.out.println("Se genero un error al insertar las intenciones de voto ");
            corrupcionVotantes();
        }

        // Posicion 0 -> comprar ID VOTANTE
        // Posicion 1 -> presupuesto del soborno por votante
        // Posicion 2 -> el porcentaje restante para comprar  
        // Posicion 3 -> valor del porcentaje restante de compra
        // PARA MOSTRAR EL ARRAY
        String muestra = "Votantes\t";
        for (int z = 0; z < candidatos; z++) {
            muestra += "Can. " + z + "\t";
        }
        muestra += "Valor\t \n";

        for (int d = 0; d < votantes; d++) {
            muestra += "Votante " + mapa[0][d] + "\t";
            for (int e = 0; e < candidatos; e++) {
                muestra += tablero[d][e] + "% \t";
            }
            muestra += mapa[1][d] + "\t \n";
        }

        System.out.println(muestra);

        // for(int pr = 0 ; pr < mapa[1].length; pr++){
        //     System.out.println(mapa[0][pr]+" "+mapa[1][pr]+" "+mapa[2][pr]+" "+mapa[3][pr]+"\n");
        // }
        System.out.println("¿Cual candidato quiere que gane?");
        candidatoganar = scan.nextInt();

        muestra = "\n\nCANDIDATO No. " + candidatoganar + "\n\nVot.\t %\t cXc\t pre\t Va\n";
        // CALCULA LA CANTIDAD POR COMPRAR DE CADA VOTANTE Y EL VALOR DE ESE PORCENTAJE A COMPRAR
        for (int f = 0; f < votantes; f++) {
            mapa[2][f] = (100 - tablero[f][candidatoganar]); // OBTIENE EL PORCENTAJE A COMPRAR
            mapa[3][f] = (mapa[2][f] * mapa[1][f] / 100); // OBTIENE EL VALOR A COMPRAR
            muestra += mapa[0][f] + "\t " + tablero[f][candidatoganar] + "\t " + mapa[2][f] + "%\t " + mapa[1][f] + " \t " + mapa[3][f] + "\n";
        }

        System.out.println(muestra);

        System.out.println("¿Cual es el lumbral para ganar?");
        lumbral = scan.nextInt();
        valorcompra = ordenanzaSeleccionInternet(mapa[3].clone());

        lum = (lumbral * votantes / 100);
        g = 0;
        sumatoria = 0;
        muestra = "Votante\t Va. compra\t \n";
        while (g < lum) {
            for (int h = 0; h < valorcompra.length; h++) {
                if (valorcompra[g] == mapa[3][h]) {
                    muestra += mapa[0][h] + "\t" + mapa[3][h] + "\n";
                    sumatoria += mapa[3][h];
                }
            }
            g++;
        }
        System.out.println(muestra);
        System.out.println("TOTAL DE DINERO PARA GANAR :" + sumatoria);
    }

    public void tableroFichas() {
        int ancho, alto, n, beneficio, areaTablero, sumatoriabeneficios;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese las dimensiones del tablero");
        System.out.println("Ingrese el ancho.");
        ancho = scan.nextInt();
        System.out.println("Ingrese el alto.");
        alto = scan.nextInt();
        sumatoriabeneficios = 0;
        int[][] tablero = new int[ancho][alto];
        areaTablero = ancho * alto;
        System.out.println("Ingrese el numero de figuras.");
        n = scan.nextInt();
        // 0. Id pieza
        // 1. Ancho
        // 2. Alto
        // 3. Beneficio
        Figuras arrayObjetos[] = new Figuras[n];

        //0. Id Pieza
        //1. Beneficio real
        int[][] beneficiosReales = new int[2][n];
        int[] resultados = new int[n];
        for (int a = 0; a < n; a++) {
            System.out.println("Ingrese las dimensiones de la figura " + a);
            System.out.println("Ancho:");
            ancho = scan.nextInt();
            System.out.println("Alto:");
            alto = scan.nextInt();
            System.out.println("Beneficio:");
            beneficio = scan.nextInt();
            arrayObjetos[a] = new Figuras(a, ancho, alto, beneficio);
            
            beneficiosReales[0][a] = arrayObjetos[a].getId();
            beneficiosReales[1][a] = arrayObjetos[a].getBeneficio();
        }
        
        // ORDENAMIENTO
        resultados = ordenanzaSeleccionInternet(beneficiosReales[1].clone());
        
        int residuo = 0;
        //areaTablero
        while (areaTablero != 0) {
            for (int i = (resultados.length-1); i > 0; i--) {
                if (beneficiosReales[1][i] == resultados[i]) {
                    if ((areaTablero - arrayObjetos[i].getAreaTotalFigura()) > 0) {
                        System.out.println("Se tomo todos los cuadros de la figura con id -> " + beneficiosReales[0][i]);
                        areaTablero -= arrayObjetos[i].getAreaTotalFigura();
                        sumatoriabeneficios += arrayObjetos[beneficiosReales[0][i]].beneficio;
                    } else {                  
                        residuo = arrayObjetos[i].getAreaTotalFigura() - areaTablero;
                        System.out.println("Se tomo "+areaTablero+" cuadros de la figura con id -> " + arrayObjetos[beneficiosReales[0][i]].getId()+" quedaron sobrando "+residuo+" cuadros");
                        sumatoriabeneficios += (areaTablero* arrayObjetos[beneficiosReales[0][i]].getBeneficioReal());
                        areaTablero = 0;
                    }
                }
            }
        }

        System.out.println("SUMATORIA DEL BENEFICIO TOTAL -> " + sumatoriabeneficios);
    }
}
