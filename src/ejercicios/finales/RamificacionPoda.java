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

        System.out.println("ingrese la cantidad de personas");
        personas = in.nextInt();
        System.out.println("ingrese la cantidad de tareas");
        tareas = in.nextInt();

        this.tabla = new int[personas][tareas];
        this.tablabanneos = new int[personas][tareas];
        tablero(personas, tareas);

        mostrarTablas(this.tabla);
        int[] resultado = new int[3];
        resultado = conviancionOptima(this.tabla, 0, 0, 0);

        System.out.println("\n\n Este es el resultado -> " + resultado[0]);
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

    public int[] conviancionOptima(int[][] tableroactual, int persona, int tarea, int totalsumatoria) {
        int[] manejador = new int[3];
        manejador[0] = totalsumatoria + tableroactual[persona][tarea];// acumulativo actual
        manejador[1] = persona; //personas
        manejador[2] = tarea; //tarea
        //System.out.println("VALOR CON QUE ENTRA "+manejador[0]+" EN PERONSA  "+manejador[1]+" Y TAREA "+manejador[2]);

        int[] siguientepersona = new int[3];
        int[] siguientetarea = new int[3];

        if ((persona + 1) < tableroactual.length) {
            siguientepersona = conviancionOptima(tableroactual, (persona + 1), tarea, totalsumatoria);
            if (siguientepersona[0] < manejador[0]) {
              //  System.out.println("La siguiente persona ->" + (siguientepersona[1] + 1) + " es menos que la persona actual -> " + (manejador[1] + 1) + " con valor de siguiente persona -> " + siguientepersona[0] + " y persona actual ->" + manejador[0]);
                manejador[0] = siguientepersona[0];
                manejador[1] = siguientepersona[1];
            }
        }

        if ((tarea + 1) < tableroactual[0].length) {
            siguientetarea = conviancionOptima(tableroactual, 0, (manejador[2] + 1), manejador[0]);
            System.out.println("Entra con "+manejador[0]+" y sale con "+siguientetarea[0]);
            if (siguientetarea[2] == manejador[2] && siguientetarea[0] < manejador[0]) {
                System.out.println("En la tarea ->" + siguientetarea[2] + " la persona -> " + siguientetarea[1] + " tuvo menor valor -> " + siguientetarea[0]);
                manejador[0] = siguientetarea[0];
                manejador[1] = siguientetarea[1];
            } 
        }
        
        System.out.println("RETORNO -> " + manejador[0]);
        return manejador;
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
