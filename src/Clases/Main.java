package Clases;

import java.util.Scanner;

public class Main {
    public static String reader() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    public static int numReader() {
        return Integer.parseInt(reader());
    }

    public static Heroe heroeEscogido(int aleatorio, Heroe[] heroes) {
        return heroes[aleatorio];
    }
    public static void mostrarHeroes (Heroe[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] != null) System.out.println(i + ".-" + heroes[i]);
        }
    }
    public static void mostrarComplementos (Complemento[] complementos) {
        for (int i = 0; i < complementos.length; i++) {
            if (complementos[i] != null) System.out.println(i + ".-" + complementos[i]);
        }
    }
    public static Heroe elegirPersonajeInicio (int eleccionPersonaje, Heroe[] heroes) {
        Heroe player = new Heroe("Predeterminado", 0, 0, 0, "Predeterminado");
        switch (eleccionPersonaje) {
            case 1 -> {
                System.out.println("¿Qué personaje desea?");
                mostrarHeroes(heroes);
                do {
                    eleccionPersonaje = numReader();
                    if (eleccionPersonaje < 1 || eleccionPersonaje > heroes.length)
                        System.out.println("Introduzca una opción valida.");
                } while (eleccionPersonaje < 1 || eleccionPersonaje > heroes.length);
                player = new Heroe(heroeEscogido(eleccionPersonaje, heroes));
            }
            case 2 -> {
                eleccionPersonaje = (int) (Math.random() * 5);
                player = new Heroe(heroeEscogido(eleccionPersonaje, heroes));
                System.out.println("¡Felicidades! Te tocó " + player.getNombre());
            }
            case 3 -> {
                System.out.println("Tus habilidades serán asignadas de manera aleatoria.");
                System.out.println("Mi nombre es:");
                String nombre = reader();
                System.out.println("Mi nivel de ataque es:");
                int ataque = (int) (Math.random() * 40 + 1);
                System.out.println(ataque);
                System.out.println("Mi nivel de velocidad es:");
                int velocidad = (int) (Math.random() * 40 + 1);
                System.out.println(velocidad);
                System.out.println("Mi nivel de defensa es:");
                int defensa = (int) (Math.random() * 40 + 1);
                System.out.println(defensa);
                System.out.println("Mi apariencia es:");
                String apariencia = reader();
                player = new Heroe(nombre, ataque, velocidad, defensa, apariencia);
            }
        }
        return player;
    }
    public static void modificarPersonaje (Heroe player, Complemento[] complementos) {
        System.out.println("¿Qué deseas modificar?\n1. Nombre:\n2. Apariencia\n3. Complemento");
        int opcion = numReader();
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
                            mostrarComplementos(complementos);
                            opcion = numReader();
                            player.equiparComplemento(complementos[opcion]);
                        } else System.out.println("No puedes equipar más complementos");
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

    public static void main(String[] args) {
        // Array 5 heroes y 5 complementos
        //Heroe[] heroes = new Heroe[5];
        Heroe heroe1, heroe2, heroe3, heroe4, heroe5;
        heroe1 = new Heroe("Destructor", 33, 9, 22, "...");
        heroe2 = new Heroe("Destructor", 33, 9, 22, "...");
        heroe3 = new Heroe("Destructor", 33, 9, 22, "...");
        heroe4 = new Heroe("Destructor", 33, 9, 22, "...");
        heroe5 = new Heroe("Destructor", 33, 9, 22, "...");
        Heroe[] heroes = {heroe1, heroe2, heroe3, heroe4, heroe5};

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


        Heroe player1 = null, player2 = null;
        int inicio, eleccionPersonaje, opcion;
        //1.
        System.out.println("Bienvenido, escoja una opción:");
        System.out.println("Modo de juego:\n1. Player vs. PC\n2. Player vs. Player\n3. Salir");
        do {
            inicio = numReader();
            switch (inicio) {
                case 1 -> {
                    System.out.println("1. Escoger un personaje existente.\n2. Sorpréndeme.\n3. Crea un nuevo personaje.");
                    do {
                        eleccionPersonaje = numReader();
                        if (eleccionPersonaje < 1 || eleccionPersonaje > 3) System.out.println("Error, opción no disponible.");
                    } while (eleccionPersonaje < 1 || eleccionPersonaje > 3);
                    player1 = elegirPersonajeInicio(eleccionPersonaje, heroes);
                }
                case 2 -> {
                    System.out.println("Escoge el jugador 1:");
                    System.out.println("1. Escoger un personaje existente.\n2. Sorpréndeme.\n3. Crea un nuevo personaje.");
                    do {
                        eleccionPersonaje = numReader();
                        if (eleccionPersonaje < 1 || eleccionPersonaje > 3) System.out.println("Error, opción no disponible.");
                    } while (eleccionPersonaje < 1 || eleccionPersonaje > 3);
                    player1 = elegirPersonajeInicio(eleccionPersonaje, heroes);
                    System.out.println("Escoge el jugador 2:");
                    System.out.println("1. Escoger un personaje existente.\n2. Sorpréndeme.\n3. Crea un nuevo personaje.");
                    do {
                        eleccionPersonaje = numReader();
                        if (eleccionPersonaje < 1 || eleccionPersonaje > 3) System.out.println("Error, opción no disponible.");
                    } while (eleccionPersonaje < 1 || eleccionPersonaje > 3);
                    player2 = elegirPersonajeInicio(eleccionPersonaje, heroes);
                }
            }

            //2.
            if (inicio == 2)System.out.println("Excelente elección, ¿Están listos para la batalla? o ¿Deseas hacer algo antes?\n1. Iniciar una batalla\n2. Modificar personajes\n3. Ver mi personajes\n4. Salir");
            else System.out.println("Excelente elección, ¿Está listo para la batalla? o ¿Deseas hacer algo antes?\n1. Iniciar una batalla\n2. Modificar personaje\n3. Ver mi personaje\n4. Salir");

            do {
                opcion = numReader();
                if (opcion<1 || opcion>4) System.out.println("Error, opción no disponible.");
            } while (opcion != 4);
            switch (opcion) {
                case 1 -> {
                } //3. Inicia batalla
                case 2 -> {
                    if (inicio == 2) {
                        System.out.println(player1 + "(1) o " + player2 + "(2)");
                        opcion = numReader();
                        switch (opcion) {
                            case 1 -> modificarPersonaje(player1, complementos);
                            case 2 -> modificarPersonaje(player2, complementos);
                        }
                    }
                    else modificarPersonaje(player1, complementos);
                }
                case 3 -> {
                    if (inicio == 2){
                        System.out.println(player1 + "(1) o " + player2 + "(2)");
                        opcion = numReader();
                        switch (opcion) {
                            case 1 -> System.out.println(player1);
                            case 2 -> System.out.println(player2);
                        }
                    }
                    else System.out.println(player1);
                }
                case 4 -> System.out.println("Adios");
                default -> System.out.println("Error, opción no disponible.");
            }
            if (inicio<1 || inicio>3) System.out.println("Error, opción no disponible.");
        } while (inicio != 3);
    }
}
