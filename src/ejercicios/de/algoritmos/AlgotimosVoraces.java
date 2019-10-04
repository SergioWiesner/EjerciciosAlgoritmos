/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.de.algoritmos;

import java.util.Scanner;
import java.util.Random;
import java.security.SecureRandom;
/**
 *
 * @author sergio
 */
public class AlgotimosVoraces {
    
    public void menu(){
    AlgotimosVoraces yo = new AlgotimosVoraces();
    System.out.println("1. Ejercicio corrupción votantes.");
        Scanner scan = new Scanner(System.in);
        int opc = scan.nextInt();
        switch(opc){
            case 1:
                yo.corrupcionVotantes();
                break;
            default:
                break;
        }
    }
    
    
    public void corrupcionVotantes(){
    int candidatos, candidato, votantes;
    Scanner scan = new Scanner(System.in);
    System.out.println("Ingrese a continuación la cantidad de votantes:");
    candidatos = scan.nextInt();
    System.out.println("Ingrese a continuación la cantidad de candidatos:");
    votantes = scan.nextInt();
    int[][] tablero = new int[candidatos][votantes];
    Random aleatorio = new Random(System.currentTimeMillis());
    // Rellenar matriz
    for(int a = 0; a < candidatos; a++){        
        for(int b = 0; b < votantes; b++){
    // Genera un numero entre 0 y 100
        tablero[a][b] = aleatorio.nextInt(101);                
        }
      }    
    String muestra = "";
    for(int z = 0; z < candidatos; z++){
            muestra += "[C"+z+"]";
    }
    muestra += "\n";
    for(int c = 0; c < candidatos; c++){
        muestra += "[V"+c+"]";        
        for(int d = 0; d < votantes; d++){               
        muestra += "["+tablero[c][d]+"]";              
        }
        muestra += "\n"; 
      }
     System.out.println(muestra);
     System.out.println("¿Cual candidato quiere que gane?");     
     candidato = scan.nextInt();
     
     

    }
    
    
}
