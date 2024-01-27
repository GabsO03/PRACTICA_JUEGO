package Clases;

import java.util.Scanner;

public class Main {
    public static String reader () {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
    public static int numReader () {
        return Integer.parseInt(reader());
    }
    public static void main(String[] args) {
        //1. Primero empieza registrando al jugador (Se recoge los datos y los introduces en el constructor)
        //2. Luego le da las opciones, de modificar su personaje, equipar un complemento e iniciar una batalla
        //3. Para la batalla, que inicie presentando al presonaje del jugador y luego al personaje del PC que le tocó (aleatorio)
        //4. Va ir por turnos, se escoge el primer ataque al azar, usar usa función.
        //5. Al inicio de cada turno saldrán opciones: Acción, Ver estado de mi personaje, terminar partida (Si escoge esto, ponemos de ganador al contrincante y decimos quien es ganador)
        //6. De caso contrario, se sigue usando el mismo metodo que vea que siga teniendo vida.


        //1.
        System.out.println("Bienvenido, introduzca los datos de su personaje");
        String nombre = reader();
    }
}
