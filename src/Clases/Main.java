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
    public static Heroe elegirPersonajeInicio (Heroe[] heroes) {
        Heroe player = new Heroe("Predeterminado", 0, 0, 0, "Predeterminado");
        System.out.println("1. Escoger un personaje existente.\n2. Sorpréndeme.\n3. Crea un nuevo personaje.");
        int eleccionPersonaje;
        do {
            eleccionPersonaje = numReader();
            if (eleccionPersonaje < 1 || eleccionPersonaje > 3)
                System.out.println("Error, opción no disponible.");
        } while (eleccionPersonaje < 1 || eleccionPersonaje > 3);
        switch (eleccionPersonaje) {
            case 1 -> {
                System.out.println("¿Qué personaje desea?");
                mostrarHeroes(heroes);
                do {
                    eleccionPersonaje = numReader();
                    if (eleccionPersonaje < 0 || eleccionPersonaje > heroes.length)
                        System.out.println("Introduzca una opción valida.");
                } while (eleccionPersonaje < 0 || eleccionPersonaje > heroes.length);
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
                        boolean tenia = player.desequiparComplemento();
                        if (!tenia) System.out.println("No tienes complementos para desequipar");
                        else System.out.println("Complemeto desequipado correctamente");
                    }
                }
            }
        }
    }

    public static void cuentaRegresiva () {
        System.out.println("3 . . .");
        System.out.println("2 . . .");
        System.out.println("1 . . .");
    }

    public static void main(String[] args) {
        Complemento complemento1, complemento2, complemento3, complemento4, complemento5;
        complemento1 = new Complemento("🧊 Corazón Ártico 🧊", 30, 15, 25, 35);
        complemento2 = new Complemento("🎇 Espada de fuego 🎇", 35, 20, 20, 30);
        complemento3 = new Complemento("🦅 Feníx 🦅", 30, 25, 20, 40);
        complemento4 = new Complemento("🌌 Vacío existencial 🌌", 25, 15, 25, 50);
        complemento5 = new Complemento("💩 Diarrea 💩", 35, 15, 25, 25);
        Complemento[] complementos = {complemento1, complemento2, complemento3, complemento4, complemento5};

        Heroe heroe1, heroe2, heroe3, heroe4, heroe5;
        heroe1 = new Heroe("Destructor", 50, 15, 30, "Fornido, armadura de hierro");
        heroe2 = new Heroe("👤 Cazador ‍👤", 45, 25, 25, "Ágil, vestimenta de cuero");
        heroe3 = new Heroe("🕵️‍♂️ Espía 🕵️‍", 45, 40, 25, "Impredecible, vestimenta de ciudadano promedio");
        heroe4 = new Heroe("🧙‍♂️ Mago 🧙‍♂️", 40, 35, 15, "Lleva gafas y una extraña cicatriz que le dejó un señor pelón");
        heroe5 = new Heroe("👼 Pacífico 👼", 35, 35, 30, "Siempre lleva la ropa sucia de trabajar, tiene una navaja escondida");
        Heroe[] heroes = {heroe1, heroe2, heroe3, heroe4, heroe5};
        Batalla batalla1 = null;

        Heroe player1 = null, player2 = null;
        int inicio, opcion;

        //1.
        do {
            System.out.println("Bienvenido, escoja una opción:");
            System.out.println("Modo de juego:\n1. Player vs. PC\n2. Player vs. Player\n3. Salir");
            do {
                inicio = numReader();
                switch (inicio) {
                    case 1 -> {
                        player1 = elegirPersonajeInicio(heroes);
                        player2 = batalla1.generaHeroeComputer(heroes);
                        player2.setComplemento(batalla1.generaComplementoComp(complementos));
                        System.out.println("Te tocó pelear contra " + player2.getNombre());
                    }
                    case 2 -> {
                        player1 = elegirPersonajeInicio(heroes);
                        player2 = elegirPersonajeInicio(heroes);
                    }
                    case 3 -> System.out.println("Adios.");
                    default -> System.out.println("Error, opción no disponible.");
                }
            } while (inicio<1 || inicio>3);

            //2.
            if (inicio<3){
                System.out.println("Excelente elección, ¿Estás listos para la batalla? o ¿Deseas hacer algo antes?");
                do {
                    do {
                        System.out.println("1. Iniciar una batalla\n2. Modificar personaje\n3. Ver mi personaje\n4. Salir");
                        opcion = numReader();
                        if (opcion < 1 || opcion > 4) System.out.println("Error, opción no disponible.");
                    } while (opcion < 1 || opcion > 4);

                    switch (opcion) {

                        case 1 -> {
                            System.out.println("Introduce la fecha:");
                            String fecha = reader();
                            System.out.println("Introduce la cantidad de turnos:");
                            int turnos= numReader();
                            batalla1 = new Batalla(player1, player2, fecha, turnos);
                            cuentaRegresiva();
                            batalla1.turno(player1, player2,inicio,batalla1);
                        }
                        case 2 -> {
                            if (inicio == 2) {
                                System.out.println(player1.getNombre() + "(1) o " + player2.getNombre() + "(2)");
                                opcion = numReader();
                                switch (opcion) {
                                    case 1 -> modificarPersonaje(player1, complementos);
                                    case 2 -> modificarPersonaje(player2, complementos);
                                }
                            } else modificarPersonaje(player1, complementos);
                        }
                        case 3 -> {
                            if (inicio == 2) {
                                System.out.println(player1.getNombre() + "(1) o " + player2.getNombre() + "(2)");
                                opcion = numReader();
                                switch (opcion) {
                                    case 1 -> System.out.println(player1);
                                    case 2 -> System.out.println(player2);
                                }
                            } else System.out.println(player1);
                        }
                        case 4 -> System.out.println("Saliendo.");
                        default -> System.out.println("Error, opción no disponible.");
                    }
                } while (opcion != 4);
            }
        } while (inicio != 3);
    }
}
