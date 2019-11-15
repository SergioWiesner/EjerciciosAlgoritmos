package ejercicios.finales;

import java.util.Random;
import java.util.Scanner;

public class Varilla {

    public int longitud, corte;
    public int[][] tabladeprecios;
    public int[] memoria;
    public Scanner in;

    public Varilla() {
        this.in = new Scanner(System.in);
    }

    public void init() {
        System.out.println("\t MENU PRINCIPAL \t \n\n\n");
        System.out.println("ingrese el tamaño de la varialla");
        this.longitud = in.nextInt();
        this.memoria = new int[this.longitud];
        //System.out.println("ingrese la cantidad de cortes");
        //this.corte = in.nextInt();

//        if((this.longitud%this.corte) != 0){
//          System.out.println("\n\n\nLa relacion de tamaño de varilla y cortes de la misma no dan cortes de longitun equitativos sobrarian -> "+(this.longitud%this.corte)+" puntos de longitud\n\n\n");
//          init();
//        }
        cargarTablaPrecios();
        mostrarTablas(this.tabladeprecios);
        
        buscarCorteOptimo(0, 0, 0, " ");

    }

    public void cargarTablaPrecios() {
        this.tabladeprecios = new int[2][this.longitud];
        int variable = 0;
        for (int a = 0; a < this.longitud; a++) {
            this.tabladeprecios[0][a] = a + 1;
            if (a > 0) {
                variable = obtenerValor(a, this.tabladeprecios[1][a - 1]);
            } else {
                variable = obtenerValor(a, this.tabladeprecios[1][a]);
            }
            this.tabladeprecios[1][a] = variable;
        }
    }

    public int obtenerValor(int semilla, int valoranterior) {
        Random r = new Random((semilla));
        int variable = r.nextInt((int) Math.round((valoranterior + 1) * 1.2));

        if (variable <= valoranterior) {
            variable = obtenerValor((semilla), (valoranterior + 2));
        }

        return variable;
    }

    public void mostrarTablas(int[][] tabla) {
        String muestra = "\n\n[Longitud]\t";
        for (int a = 0; a < this.tabladeprecios.length; a++) {
            for (int b = 0; b < this.tabladeprecios[a].length; b++) {
                muestra += "[" + this.tabladeprecios[a][b] + "]\t";
            }
            if (a == 0) {
                muestra += "\n[Precio]\t";
            }
        }
        System.out.println(muestra + "\n");
    }

    public int buscarCorteOptimo(int cortes, int precio, int posicion, String rutaposiciones) {
      rutaposiciones += " " + (this.tabladeprecios[0][posicion]);
      if(cortes == 0){
        cortes = 1;
      }
      
        if (cortes == this.longitud) {
            
            System.out.println("Acumulado de precio " + precio);
            System.out.println("Cortes " + cortes);
            System.out.println("Convinacion de cortes " + rutaposiciones);
            System.out.println("\n\n\n");
            return cortes;
        }

       

        if ((posicion - 1) >= 0) {
            if ((cortes+this.tabladeprecios[0][posicion-1]) <= this.longitud) {                
                // System.out.println("POR LA IZQUIERDA -> " + rutaposiciones);
                buscarCorteOptimo((cortes+this.tabladeprecios[0][posicion-1]),(precio + this.tabladeprecios[1][posicion-1]),(posicion - 1), rutaposiciones);
                
            }
        }
        
         if ((cortes+this.tabladeprecios[0][posicion]) <= this.longitud) {
            
            // System.out.println("POR EL CENTRO -> " + rutaposiciones);
            // System.out.println("CORTE ANTES -> " + cortes+ " CORTES DESPUES -> "+this.tabladeprecios[0][posicion]);
            buscarCorteOptimo((cortes+this.tabladeprecios[0][posicion]),(precio + this.tabladeprecios[1][posicion]), posicion, rutaposiciones);
        }
         
         
        if ((posicion + 1) <= this.tabladeprecios[0].length) {
            if ((cortes+this.tabladeprecios[0][posicion+1]) <= this.longitud) {                
                // System.out.println("POR LA DERECHA -> " + rutaposiciones);
                // System.out.println("CORTE ANTES -> " + cortes+ " CORTES DESPUES -> "+this.tabladeprecios[0][posicion+1]);
                int cortenuevo = (cortes+this.tabladeprecios[0][posicion+1]);
               // System.out.println("CORTE -> " + cortenuevo);
                buscarCorteOptimo(cortenuevo,(precio + this.tabladeprecios[1][posicion+1]),(posicion + 1), rutaposiciones);
            }
        }
        
        return cortes;
    }

    
    
    
    
    
    
    
    
    
    
//    public void buscarCorteOptimo() {
//        for (int z = 0; z < this.longitud; z++) {
//            int acumulado = this.tabladeprecios[0][z];
//            System.out.println("Suma una pieza de corte " + this.tabladeprecios[0][z]);
//            int precio = this.tabladeprecios[1][z];
//
//            for (int a = 0; a < this.longitud; a++) {
//                while ((acumulado + this.tabladeprecios[0][a]) <= this.longitud) {
//                    acumulado += this.tabladeprecios[0][a];
//                    precio += this.tabladeprecios[1][a];
//                    System.out.println("Suma una pieza de corte " + this.tabladeprecios[0][a]);
//                }
//            }
//            System.out.println("\nAcumulado de precio " + precio + "\n\n");
//        }
//        this.memoria[a] =
//    }
}
