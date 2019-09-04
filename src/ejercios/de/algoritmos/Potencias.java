/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercios.de.algoritmos;

import java.util.Scanner;

/**
 *
 * @author sergio
 */
public class Potencias {

    public static int formaUno() {
        int y, z, p; // 3
        p = 1; // 1
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la base a potenciar");
        y = scan.nextInt(); // 1
        System.out.println("Ingresa el exponente");
        z = scan.nextInt(); // 1
        while (z > 0) { // 1
            p = p * y;  // 2
            z = z - 1; // 2
        } //1
        System.out.println("resultado es -> " + p);
        return p; //1

        //z = 1      7 + 5z + 1
        //z = 2      7 + 5z + 1
    }

    public static int formaDos() {
        int y, z, p; // 3
        p = 1; // 1
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la base a potenciar");
        y = scan.nextInt(); // 1
        System.out.println("Ingresa el exponente");
        z = scan.nextInt(); // 1
        while (z > 0) { // 1
            
            if ((z % 2) != 0) { // 2
                p = p * y; // 2
            }
            
            z = z / 2; // 2
            y = y * y; // 2
        } // 1
        System.out.println("resultado es -> " + p);
        return p; //1 
        //z = 1           7 + 8z + 1
        //z = 2           7 + 8z + 1
    }

    public static void main() {
        System.out.println("1. potenciacion altgoritmo 1");
        System.out.println("2. potenciacion altgoritmo 2");
        Scanner scan = new Scanner(System.in);
        int opc = scan.nextInt();
        switch (opc) {
            case 1:
                formaUno();
                main();
                break;
            case 2:
                formaDos();
                main();
                break;
            default:
                break;
        }
    }

}
