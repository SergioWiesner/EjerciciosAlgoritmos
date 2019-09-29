/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.de.algoritmos;

import java.util.Scanner;

/**
 *
 * @author sergio
 */
public class Potencias {

    public static int formaUno() {
        int y, z, p;
        p = 1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la base a potenciar");
        y = scan.nextInt();
        System.out.println("Ingresa el exponente");
        z = scan.nextInt();
        while (z > 0) {
            p = p * y;
            z = z - 1;
        }
        return p;
    }

    public static int formaDos() {
        int y, z, p;
        p = 1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la base a potenciar");
        y = scan.nextInt();
        System.out.println("Ingresa el exponente");
        z = scan.nextInt();
        while (z > 0) {
            p = p * y;
            z = z / 2;
            y = y * y;
        }
        return p;
    }
    
    public static void main() {
        System.out.println("1. potenciacion altgoritmo 1");
        System.out.println("2. potenciacion altgoritmo 2");
        Scanner scan = new Scanner(System.in);
        int opc = scan.nextInt();
        switch (opc) {
            case 1:
                formaUno();
                break;
            case 2:
                formaDos();
                break;
            default:
                break;
        }
    }
    
    

}
