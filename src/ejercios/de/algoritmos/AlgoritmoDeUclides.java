package ejercios.de.algoritmos;

import java.util.Scanner;

public class AlgoritmoDeUclides {   

    public static int euclides(){
        int t, a, b; // 3
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la base a potenciar");
        a = scan.nextInt(); // 1
        System.out.println("Ingresa el exponente");
        b = scan.nextInt(); // 1
        
        while(a > 0){ // 1 
            t = a; // 1
            a = b % a; // 2
            b = t; // 1
        } // 1
        System.out.println(b);
        return b; // 1
        
        // 6 + 5a + 1
    } 
}
