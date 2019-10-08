package ejercicios.de.algoritmos;

import ejercicios.de.algoritmos.OrdenInsecionSeleccion;
import ejercicios.de.algoritmos.AlgotimosVoraces;
import java.util.Scanner;

public class EjerciosDeAlgoritmos {

    public void menu() {
        int opc = 0;
        try{
        System.out.println("Ecoge el ejecicio a probar");
        System.out.println("1. Orden inseción seleccion.");
        System.out.println("2. Algoritmos de potenciacion.");
        System.out.println("3. Algoritmo de euclides.");
        System.out.println("4. Algoritmos voraces.");
        Scanner scan = new Scanner(System.in);
        opc = scan.nextInt();
        }catch(Exception e){
         System.out.println("Error en el numero ingresado ");
            menu();
        }
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
                break; 
            case 4:
                AlgotimosVoraces voraces = new AlgotimosVoraces();
                voraces.menu();
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
