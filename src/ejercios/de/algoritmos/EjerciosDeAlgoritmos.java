package ejercios.de.algoritmos;

import ejercios.de.algoritmos.OrdenInsecionSeleccion;
import java.util.Scanner;

public class EjerciosDeAlgoritmos {

    public void menu() {
        System.out.println("Ecoge el ejecicio a probar");
        System.out.println("1. Orden inseción seleccion.");
        System.out.println("2. Algoritmos de potenciacion.");
        System.out.println("3. Algoritmo de euclides.");
        Scanner scan = new Scanner(System.in);
        int opc = scan.nextInt();
        switch(opc){
            case 1:
                OrdenInsecionSeleccion main = new OrdenInsecionSeleccion();
                main.main();
                break;
            case 2:
                Potencias potencia = new Potencias();
                potencia.main();
                break;
            case 3:
                AlgoritmoDeUclides uclides = new AlgoritmoDeUclides();
                uclides.euclides();
                menu();
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
