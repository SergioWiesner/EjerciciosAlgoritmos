package ejercicios.finales;

import java.util.Random;
import java.util.Scanner;

public class RamificacionPoda {

    public Scanner in;
    public int[][] tabla;
    public int[][] tablabanneos;

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
        this.tablabanneos = new int[personas][tareas];
        tablero(personas, tareas);

        mostrarTablas(this.tabla);
        int resultado = conviancionOptima(this.tabla, 0, 0, 0, this.tablabanneos);

        System.out.println("\n\n Este es el resultado -> " + resultado);
        init();
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
        String muestra = "\n\n [pers tare]\t";
        for (int b = 0; b < this.tabla.length; b++) {
            muestra += "[t" + (b + 1) + "]\t";
        }
        muestra += "\n";
        for (int a = 0; a < this.tabla.length; a++) {
            muestra += " [Persona " + (a + 1) + "]\t";
            for (int b = 0; b < this.tabla[a].length; b++) {
                muestra += "[" + this.tabla[a][b] + "]\t";
            }
            muestra += "\n";
        }
        System.out.println(muestra + "\n");
    }

    public int conviancionOptima(int[][] tableroactual, int persona, int tarea, int totalsumatoria, int[][] tablaBanneos) {
        int sumatoriaparcial = totalsumatoria + tableroactual[persona][tarea];
        int siguientepersona = 0;
        int siguientetarea = 0;

        // Si existe una persona mas 
        if ((persona + 1) < tableroactual.length) {
                // busque el valor de la siguiente persona 
                siguientepersona = conviancionOptima(tableroactual, (persona + 1), tarea, totalsumatoria, tablaBanneos);
        } else {
            // si no es porque en la persona que esta actualmente es la ultima persona
            // System.out.println("LLEGO A LA ULTIMA PERSONA -> " + (persona + 1) + " DE LA  TAREA -> " + (tarea + 1) + " CON VALOR -> " + tableroactual[persona][tarea]);
            // entonces retorne el valor de esta persona
            return sumatoriaparcial;
        }

        // si el valor de la siguiente persona es menor que el valor de la persona actual entonces 
        if (siguientepersona < sumatoriaparcial) {
            sumatoriaparcial = siguientepersona;
        }

        if ((tarea + 1) < tableroactual[0].length) {
            siguientetarea = conviancionOptima(tableroactual, 0, (tarea + 1), sumatoriaparcial, tablaBanneos);
        } else {
            siguientetarea = sumatoriaparcial;
        }

        System.out.println("RETORNO -> " + siguientetarea);
        return siguientetarea;
    }

    public boolean averiguarBaneo(int[][] tablaban) {
        for (int a = 0; a < tablaban.length; a++) {
            for (int b = 0; b < tablaban[a].length; b++) {
                if (tablaban[a][1] == 1) {
                    return true;
                }
            }
        }
        return false;
    }


}
