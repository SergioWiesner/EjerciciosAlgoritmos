/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.finales;

import java.util.*;

/**
 *
 * @author webdev
 */
public class DivideYVenceras {

    /**
     * @param args the command line arguments
     */
    public void main() {
        double c = 0;

        System.out.println("ingrese el grado de la ecuacion: ");
        Scanner lea = new Scanner(System.in);
        int d = lea.nextInt();
        d = d + 1;

        int e[] = new int[d];

        for (int i = 0, k = d - 1; i < d; i++) {
            int l = i + 1;
            System.out.print("ingrese el valor del termino " + l + ": ");
            int f = lea.nextInt();
            e[k] = f;
            k--;
        }

        System.out.println("Ecuacion:");

        for (int i = 0, k = d - 1; i < d; i++) {

            if (k > 0) {
                System.out.print(e[k] + "x^" + k + " + ");
            } else {
                System.out.print(e[k] + " = 0");
            }

            k--;

        }

        System.out.println();

        System.out.println("ingrese el punto inicial del intervalo: ");
        double a = lea.nextInt();

        System.out.println("ingrese el punto final del intervalo: ");
        double b = lea.nextInt();

        if (f(a, d, e) * f(b, d, e) > 0) {
            System.out.println("no se cumple que f(a)*f(b)<0");
        }

        while (true) {
            c = (a + b) / 2;
            
            if (f(a, d, e) * f(c, d, e) < 0) {
                b = c;
            } else {
                a = c;
            }
        }
    }
    
  //  public void obtenerRaiz(){
  //  if (Math.abs(f(c, d, e)) < 1e-10) {
  //              System.out.println("la raiz estimada es = " + c);
  //              return;
  //   }
  //  }
    
    

    public static double f(double x, int d, int e[]) {
        double z = 0;
        for (int i = d - 1; i >= 0; i--) {
            z = (e[i] * (Math.pow(x, i))) + z;

        }
        return z;
    }

}
