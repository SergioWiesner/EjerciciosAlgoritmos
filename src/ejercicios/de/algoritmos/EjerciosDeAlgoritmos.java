package ejercicios.de.algoritmos;

import ejercicios.de.algoritmos.OrdenInsecionSeleccion;
import ejercicios.de.algoritmos.AlgotimosVoraces;
import ejercicios.finales.Menu;

import java.util.Scanner;

public class EjerciosDeAlgoritmos {

    public void menu() throws Exception {
        int opc = 0;
        try{
        System.out.println("\t MENU PRINCIPAL \t \n\n\n");
        System.out.println("Ecoge el ejecicio a probar");
        System.out.println("1. Orden inseción seleccion.");
        System.out.println("2. Algoritmos de potenciacion.");
        System.out.println("3. Algoritmo de euclides.");
        System.out.println("4. Algoritmos voraces.");
        System.out.println("5. Ejercicio de taxista.");
        System.out.println("6. Ejercicios final corte.");
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
            case 5:
              Taxista taxi = new Taxista();
              taxi.inicio();
              break; 
            case 6:
              Menu menu = new Menu();
              menu.menu();
            default:
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        EjerciosDeAlgoritmos inicio = new EjerciosDeAlgoritmos();
        inicio.menu();
    }
}
