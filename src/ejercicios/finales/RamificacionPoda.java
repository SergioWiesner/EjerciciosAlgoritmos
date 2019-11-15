package ejercicios.finales;

import java.util.Random;
import java.util.Scanner;

public class RamificacionPoda {

    public Scanner in;
    public int[][] tabla;

    public RamificacionPoda() {
        this.in = new Scanner(System.in);
    }

    public void init() {
        int personas, tareas;
        System.out.println("\t EJERCICIO RAMIFICACIÓN Y PODA \t \n\n\n");
        System.out.println("ingrese el cantidad de personas");
        personas = in.nextInt();
        System.out.println("ingrese el cantidad de tareas");
        tareas = in.nextInt();
        this.tabla = new int[personas][tareas];
        tablero(personas, tareas);
        mostrarTablas(this.tabla);
    }

    public void tablero(int personas, int tareas) {
        Random aleatorio = new Random(System.currentTimeMillis());
        for (int a = 0; a < tareas; a++) {
            for (int b = 0; b < personas; b++) {
                this.tabla[a][b] = aleatorio.nextInt(100);
            }
        }
    }
    
    
     public void mostrarTablas(int[][] tabla) {
        String muestra = "\n\n";
        for (int a = 0; a < this.tabla.length; a++) {
            muestra += "[Persona "+a+"]\t";
            for (int b = 0; b < this.tabla[a].length; b++) {
                muestra += "[" + this.tabla[a][b] + "]\t";
            }
            muestra += "\n";
        }
        System.out.println(muestra + "\n");
    }
     
     
    public void conviancionOptima(){
    
    }
}
