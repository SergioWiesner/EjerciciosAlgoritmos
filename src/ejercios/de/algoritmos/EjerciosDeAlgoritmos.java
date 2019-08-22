/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercios.de.algoritmos;

import ejercios.de.algoritmos.OrdenInsecionSeleccion;
import java.util.Scanner;

/**
 *
 * @author PC-47050
 */
public class EjerciosDeAlgoritmos {

    public void menu() {
        System.out.println("Ecoge el ejecicio a probar");
        System.out.println("1. Orden inseción seleccion.");
        Scanner scan = new Scanner(System.in);
        int opc = scan.nextInt();
        switch (opc) {
            case 1:
                OrdenInsecionSeleccion main = new OrdenInsecionSeleccion();
                main.main();
                break;
            default:
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EjerciosDeAlgoritmos inicio = new EjerciosDeAlgoritmos();
        inicio.menu();
    }

}
