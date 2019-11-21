package parcial;

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
        int resultado = conviancionOptima(this.tabla, 0, 0, 0);
        
        System.out.println("Este es el resultado -> "+resultado);
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
            muestra += "[Persona " + (a + 1) + "]\t";
            for (int b = 0; b < this.tabla[a].length; b++) {
                muestra += "[" + this.tabla[a][b] + "]\t";
            }
            muestra += "\n";
        }
        System.out.println(muestra + "\n");
    }

    public int conviancionOptima(int[][] tableroactual, int persona, int tarea, int totalsumatoria) {

        if (persona >= tableroactual.length || tarea >= tableroactual[0].length) {
            return totalsumatoria;
        }
        
        int actual = tableroactual[persona][tarea];
        int siguientepersona = 0;
        int siguientetarea = 0;

        if (persona < tableroactual.length) {
            
            //System.out.println("Entra en persona " + (persona + 1) + " En  tarea -> " + tarea);
            siguientepersona = conviancionOptima(tableroactual, (persona + 1), tarea, totalsumatoria);
            //System.out.println("ESTO RESULTA DE LA PERSONAS "+(persona + 1)+" -> "+siguientepersona+" ESTO HAY EN EL TABLERO -> "+tableroactual[persona][tarea]);
                if ((totalsumatoria + siguientepersona) < (totalsumatoria + actual) && siguientepersona != 0) {
                    System.out.println("Persona -> " + (persona + 1) + " En la tarea -> " + tarea);
                    totalsumatoria = totalsumatoria + siguientepersona;
                    System.out.println("Con una sumatoria de -> " + totalsumatoria);
                }else{
                    totalsumatoria = totalsumatoria + actual;
              //      System.out.println("Opc 1 -> " + (totalsumatoria + siguientepersona) + " Opc 2 -> "+(totalsumatoria + actual));
                }
               

        }

        if (tarea < tableroactual[persona].length) {
            System.out.println("Entra en tarea ------------> " + (tarea+1));
            siguientetarea = conviancionOptima(tableroactual, persona, (tarea + 1), totalsumatoria);
            if ((totalsumatoria + siguientetarea) < (totalsumatoria + actual)) {
                System.out.println("Persona -> " + (persona + 1) + " En la tarea -> " + tarea);
                totalsumatoria = totalsumatoria + siguientetarea;
                System.out.println("Con una sumatoria de -> " + totalsumatoria);
            }else{
            }
        }

        return totalsumatoria;
    }
}
