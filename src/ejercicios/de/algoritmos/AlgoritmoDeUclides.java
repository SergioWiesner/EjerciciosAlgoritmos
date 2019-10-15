package ejercicios.de.algoritmos;

import java.util.Scanner;

public class AlgoritmoDeUclides {   

    public static int euclides(){
        System.out.println("\t ALGORITMO DE EUCLIDES \t \n\n\n");
        int t, a, b; // 3
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el primer numero");
        a = scan.nextInt(); // 1
        System.out.println("Ingresa el segundo numero");
        b = scan.nextInt(); // 1
        
        while(a > 0){ // 1 
            t = a; // 1
            a = b % a; // 2
            b = t; // 1
        } // 1
        System.out.println("Residuos "+b);
        return b; // 1
        
        // 6 + 5a + 1
    } 
}
