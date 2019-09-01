package ejercios.de.algoritmos;

import java.util.Scanner;

public class AlgoritmoDeUclides {   

    public static int euclides(){
        int t, a, b;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la base a potenciar");
        a = scan.nextInt();
        System.out.println("Ingresa el exponente");
        b = scan.nextInt();
        
        while(a > 0){
            t = a;
            a = b % a;
            b = t;
        }
        System.out.println(b);
        return b;
    }    
}
