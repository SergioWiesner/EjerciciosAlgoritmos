package ejercicios.finales;

import java.util.Scanner;

public class Menu {

    public void menu() {
        int opc = 0;
        System.out.println("\t Ejercicios final \t \n\n\n");
        System.out.println("2. Ejercicio de varillas.");
        System.out.println("3. Ejercicio de ramificacion y poda.");
        Scanner scan = new Scanner(System.in);
        opc = scan.nextInt();
        switch (opc) {
            case 1:

                break;
            case 2:
                Varilla Varilla = new Varilla();
                Varilla.init();
                break;
            case 3:
                RamificacionPoda RP = new RamificacionPoda();
                RP.init();
                break;
            default:
                break;
        }
    }
}
