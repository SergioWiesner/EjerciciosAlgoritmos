/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.de.algoritmos;

import java.util.Scanner;
import java.util.Random;
import java.security.SecureRandom;
import ejercicios.de.algoritmos.OrdenInsecionSeleccion;

/**
 *
 * @author sergio
 */
public class AlgotimosVoraces {

    public void menu() {
        AlgotimosVoraces yo = new AlgotimosVoraces();
        System.out.println("1. Ejercicio corrupción votantes.");
        Scanner scan = new Scanner(System.in);
        int opc = scan.nextInt();
        switch (opc) {
            case 1:
                yo.corrupcionVotantes();
                break;
            default:
                break;
        }
    }

    public void corrupcionVotantes() {
        int candidatos, candidatoganar, votantes, lumbral;
        Scanner scan = new Scanner(System.in);
        
        OrdenInsecionSeleccion or = new OrdenInsecionSeleccion();
        
        System.out.println("Ingrese a continuación la cantidad de votantes:");
        votantes = scan.nextInt();
        System.out.println("Ingrese a continuación la cantidad de candidatos:");
        candidatos = scan.nextInt();
        
        // DECLARACIÓN DE ELEMNTOS NECESARIOS
        int[][] tablero = new int[votantes][candidatos];
        int[][] mapa = new int[4][votantes];
        int[] valorcompra= new int[votantes];
        // Rellenar matriz con las intenciones de voto
        Random aleatorio = new Random(System.currentTimeMillis());
        try{
        for (int a = 0; a < votantes; a++) {
            for (int b = 0; b < candidatos; b++) {
                // Genera un numero entre 0 y 100
                int intent;
                if (b == 0) {
                    intent = aleatorio.nextInt(100);
                } else {
                    intent = aleatorio.nextInt(100 - tablero[a][b - 1]);
                }

                tablero[a][b] = intent;
            }
        }
        }catch(Exception e){
            System.out.println("Se genero un error al insertar las intenciones de voto ");
            corrupcionVotantes();
        }

        // Rellena el vector con el presupuesto de compra para cada votantes
        for (int c = 0; c < votantes; c++) {
            mapa[3][c] = aleatorio.nextInt(101); // INGRESA EL PRESUPUESTO DE CADA VOTANTE
        }
        
        // PARA MOSTRAR EL ARRAY
        String muestra = "\tVotantes\t";
        for (int z = 0; z < candidatos; z++) {
            muestra += "\tCan. " + z + "\t";
        }        
        muestra += "\tPrecio\t \n";
        
        for (int d = 0; d < votantes; d++) {
            muestra += "\tVotante " + d + "\t";
            for (int e = 0; e < candidatos; e++) {
                muestra += "\t" + tablero[d][e] + "% \t";
            }
            muestra += "\t" + mapa[3][d] + "\t \n";
        }
        
        System.out.println(muestra);
        
        System.out.println("¿Cual candidato quiere que gane?");
        candidatoganar = scan.nextInt();
        
        muestra = "CANDIDATO No. "+candidatoganar+"\nVot.\t %\t cXc\t pre\t Va\n";
        // CALCULA LA CANTIDAD POR COMPRAR DE CADA VOTANTE Y EL VALOR DE ESE PORCENTAJE A COMPRAR
        for(int f = 0; f < votantes; f++){
         mapa[2][f] = f; // Identificador del votante
         mapa[0][f] = (100-tablero[f][candidatoganar]); // OBTIENE EL PORCENTAJE A COMPRAR
         mapa[1][f] = (mapa[0][f]*mapa[3][f]/100); // OBTIENE EL VALOR A COMPRAR
         muestra += mapa[2][f]+"\t "+tablero[f][candidatoganar]+"\t "+mapa[0][f]+"%\t "+mapa[3][f]+" \t "+ mapa[1][f]+"\n"; 
        }
        System.out.println(muestra);
        
        System.out.println("¿Cual es el lumbral para ganar?");
        lumbral = scan.nextInt();
  
        valorcompra = or.ordenanzaSeleccionInternet(mapa[1]);
        
        //for(int g = 0; g < valorcompra.length; g++){
        //    muestra += ""+valorcompra[g]+"\n";
        //}
        
        //muestra = "\t CANDIDATOS A COMPRAR \nvot.\t  cXc\t Val\n";
        muestra = "\n \n \nVal.";
        int g = 0;
        
        
        
        int lum = (lumbral*votantes/100);
        
        while( g < lum){
           System.out.println(valorcompra[g]+"\n");
           for(int h = 0; h < mapa[2].length; h++){
           if(mapa[1][h] == valorcompra[g]){
               System.out.println(mapa[2][h]+" ESTE ES EL ULTIMO VALOR QUE RELACIONA ->"+valorcompra[g]+"\n");
           }
        }
         g++;
        }
        
        
        

        menu();

    }
    
    

}
