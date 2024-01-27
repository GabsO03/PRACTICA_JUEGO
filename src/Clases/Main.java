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
    public static Heroe heroeEscogido (int aleatorio, Heroe[] heroes) {
        return heroes[aleatorio];
    }
    public static void main(String[] args) {
        // Array 5 heroes y 5 complementos
        Heroe[] heroes = new Heroe[5];
        Heroe heroe1, heroe2, heroe3, heroe4, heroe5;
        heroe1 = new Heroe("Destructor", 33, 9, 22, "...");
        heroe2 = new Heroe("Destructor", 33, 9, 22, "...");
        heroe3 = new Heroe("Destructor", 33, 9, 22, "...");
        heroe4 = new Heroe("Destructor", 33, 9, 22, "...");
        heroe5 = new Heroe("Destructor", 33, 9, 22, "...");
        Complemento[] complementos = new Complemento[5];
        Complemento complemento1, complemento2, complemento3, complemento4, complemento5;
        complemento1 = new Complemento("Corazón Ártico", 14, 7, 22, 35);
        complemento2 = new Complemento("Corazón Ártico", 33, 9, 22, 12);
        complemento3 = new Complemento("Corazón Ártico", 33, 9, 22, 19);
        complemento4 = new Complemento("Corazón Ártico", 33, 9, 22, 2);
        complemento5 = new Complemento("Corazón Ártico", 33, 9, 22, 23);

        //1. Primero empieza registrando al jugador (Se recoge los datos y los introduces en el constructor)
        //2. Luego le da las opciones, de modificar su personaje, equipar un complemento e iniciar una batalla
        //3. Para la batalla, que inicie presentando al presonaje del jugador y luego al personaje del PC que le tocó (aleatorio)
        //4. Va ir por turnos, se escoge el primer ataque al azar, usar usa función.
        //5. Al inicio de cada turno saldrán opciones: Acción, Ver estado de mi personaje, terminar partida (Si escoge esto, ponemos de ganador al contrincante y decimos quien es ganador)
        //6. De caso contrario, se sigue usando el mismo metodo que vea que siga teniendo vida.


        //1.
        Heroe player = new Heroe("Predeterminado", 0, 0, 0, "Predeterminado");
        System.out.println("Bienvenido, escoja una opción:");
        System.out.println("1. Escoger un personaje existente.\n2. Sorpréndeme.\n3. Crea un nuevo personaje.\n4. Salir");
        int eleccionPersonaje = numReader();
        switch (eleccionPersonaje) {
            case 1 -> {
                System.out.println("¿Qué personaje desea?");
                //Lista de personajes
                player = new Heroe(heroeEscogido(numReader(), heroes));
            }
            case 2 -> {
                int aleatorio = (int) (Math.random()*5+1);
                player = new Heroe(heroeEscogido(aleatorio, heroes));
                System.out.println("¡Felicidades! Te tocó " + player.getNombre());
            }
            case 3 -> {
                System.out.println("Tus habilidades serán asignadas de manera aleatoria.");
                System.out.println("Mi nombre es:");
                String nombre = reader();
                System.out.println("Mi nivel de ataque es:");
                int ataque = (int) (Math.random()*40+1);
                System.out.println(ataque);
                System.out.println("Mi nivel de velocidad es:");
                int velocidad = (int) (Math.random()*40+1);
                System.out.println(velocidad);
                System.out.println("Mi nivel de defensa es:");
                int defensa = (int) (Math.random()*40+1);
                System.out.println(defensa);
                System.out.println("Mi apariencia es:");
                String apariencia = reader();
                player = new Heroe(nombre, ataque, velocidad, defensa, apariencia);
            }
        }

        //2.
        System.out.println("Excelente elección, ¿Está listo para la batalla? o ¿Deseas hacer algo antes?\n1. Iniciar una batalla\n2. Modificar personaje\n3. Salir");
        int opcion = numReader();
        switch (opcion) {
            case 1 -> {} //3. Inicia batalla
            case 2 -> {
                System.out.println("¿Qué deseas modificar?\n1. Nombre:\n2. Apariencia\n3. Complemento");
                opcion = numReader();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Introduce el nombre:");
                        player.setNombre(reader());
                    }
                    case 2 -> {
                        System.out.println("Introduce la apariencia:");
                        player.setApariencia(reader());
                    }
                    case 3 -> {
                        System.out.println("1. Equipar.\n2. Desequipar.");
                        opcion = numReader();
                        switch (opcion) {
                            case 1 -> {
                                if (player.getComplemento() == null) {
                                    System.out.println("Elige tu complemento:");
                                    //Lista de complementos
                                    opcion = numReader();
                                    player.equiparComplemento(complementos[opcion]);
                                }
                                else System.out.println("No puedes equipar más complementos");
                            }
                            case 2 -> {
                                boolean tiene = player.desequiparComplemento();
                                if (!tiene) System.out.println("No tienes complementos para desequipar");
                                else System.out.println("Complemeto desequipado correctamente");
                            }
                        }
                    }
                }
            }
            case 3 -> System.out.println("Adios");
            default -> System.out.println("Introduce una opción valida.");
        }
    }
}
