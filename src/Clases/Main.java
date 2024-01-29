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
    public static boolean sigueJugando (Heroe ataca, Heroe recibe) {
        String[] frasesAtaque = {"Toma mango", "Y eso no es todo", "Pim pam pum", "Por comerte mi chococrispis"};
        int opcion, complemento;
        System.out.println("Turno de " + ataca.getNombre());
        do {
            System.out.println("Menú de batalla:\n1.Atacar\n2.Ver mi estado\n3.Usar complementos\n4. Rendirse");
            opcion = numReader();
            switch (opcion) {
                case 1 -> ataca.atacaA(recibe, frasesAtaque);
                case 2 -> System.out.println(ataca);
                case 3 -> {
                    if (ataca.getComplemento() != null) {
                        System.out.println("Elige sabiamente.\n1. Ataque\n2. Defensa\n3. Velocidad\n4. Recuperar vida\n5. Cancelar");
                        complemento = numReader();
                        switch (complemento) {
                            case 1 -> ataca.usarComplementoAtaque();
                            case 2 -> ataca.usarComplementoDefensa();
                            case 3 -> ataca.usarComplementoVelocidad();
                            case 4 -> ataca.recuperarVida();
                            case 5 -> System.out.println("a");
                            default -> System.out.println("What?");
                        }
                    }
                    else System.out.println("Debiste equipar complemento antes de la batalla");
                }
                case 4 -> {
                    System.out.println("Me rindo. Gana: " + recibe.getNombre());
                    return false;
                }
                default -> System.out.println("What?");
            }
        } while (opcion != 1 && opcion != 4);
        return true;
    }

    public static boolean juegaCPU (Heroe cpu, Heroe recibe) {
        String[] frasesAtaque = {"Toma mango", "Y eso no es todo", "Pim pam pum", "Por comerte mi chococrispis"};
        int opcion, complemento;
        System.out.println("Turno de " + cpu.getNombre());
        do {
            opcion = (int) (Math.random()*2+1);
            switch (opcion) {
                case 1 -> cpu.atacaA(recibe, frasesAtaque);
                case 2 -> {
                    if (cpu.getComplemento() != null) {
                        complemento = (int) (Math.random()*4+1);
                        switch (complemento) {
                            case 1 -> cpu.usarComplementoAtaque();
                            case 2 -> cpu.usarComplementoDefensa();
                            case 3 -> cpu.usarComplementoVelocidad();
                            case 4 -> cpu.recuperarVida();
                        }
                    }
                }
            }
            if (cpu.getVida()<=50) cpu.recuperarVida();
            if (cpu.getVida()<=10) return false;
        } while (opcion!=1 && opcion!=4);
        return true;
    }

    public static void cuentaRegresiva () {
        System.out.println("3 . . .");
        for (int i = 0; i < 100000; i++) {}
        System.out.println("2 . . .");
        for (int i = 0; i < 100000; i++) {}
        System.out.println("1 . . .");
        for (int i = 0; i < 100000; i++) {}
    }

    public static void main(String[] args) {
        // Array 5 heroes y 5 complementos
        Complemento complemento1, complemento2, complemento3, complemento4, complemento5;
        complemento1 = new Complemento("🧊 Corazón Ártico 🧊", 30, 15, 22, 35);
        complemento2 = new Complemento("🎇 Espada de fuego 🎇", 35, 9, 22, 12);
        complemento3 = new Complemento("🦅 Feníx 🦅", 0, 15, 20, 19);
        complemento4 = new Complemento("🌌 Vacío existencial 🌌", 33, 9, 22, 2);
        complemento5 = new Complemento("💩 Diarrea 💩", 33, 9, 22, 23);
        Complemento[] complementos = {complemento1, complemento2, complemento3, complemento4, complemento5};


        //Heroe[] heroes = new Heroe[5];
        Heroe heroe1, heroe2, heroe3, heroe4, heroe5;
        heroe1 = new Heroe("Destructor", 50, 20, 30, "...");
        heroe2 = new Heroe("👤 Cazador ‍👤", 45, 9, 30, "...");
        heroe3 = new Heroe("🕵️‍♂️ Espía 🕵️‍", 45, 50, 25, "...", complemento1);
        heroe4 = new Heroe("🧙‍♂️ Mago 🧙‍♂️", 40, 9, 15, "...");
        heroe5 = new Heroe("👼 Pacífico 👼", 30, 40, 30, "...");
        Heroe[] heroes = {heroe1, heroe2, heroe3, heroe4, heroe5};



        Heroe player1 = null, player2 = null;
        int inicio, opcion;
        boolean sigueVivo1 = true, sigueVivo2 = true, sigueJugando1 = true, sigueJugando2 = true;

        //1.
        do {
            System.out.println("Bienvenido, escoja una opción:");
            System.out.println("Modo de juego:\n1. Player vs. PC\n2. Player vs. Player\n3. Salir");
            do {
                inicio = numReader();
                switch (inicio) {
                    case 1 -> {
                        player1 = elegirPersonajeInicio(heroes);
                        player2 = heroeEscogido((int)(Math.random()*heroes.length),heroes);
                        System.out.println("Te tocó jugar con " + player2.getNombre());
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
                        //3. Inicia batalla
                        // También falta contador de turnos.
                        // También falta controlar que al atacar solo le reste vida...
                        case 1 -> {
                            cuentaRegresiva();
                            do {
                                if (player1.getVelocidad() > player2.getVelocidad()) {
                                    sigueJugando1 = sigueJugando(player1, player2);
                                    if (inicio == 2) sigueJugando2 = sigueJugando(player2, player1);
                                    else juegaCPU(player2, player1);
                                    //Falta agregar función de generar turno aleatorio
                                }
                                else if (player2.getVelocidad() > player1.getVelocidad())  {
                                    if (inicio == 2) sigueJugando2 = sigueJugando(player2, player1);
                                    else juegaCPU(player2, player1);
                                    sigueJugando1 = sigueJugando(player1, player2);
                                    //Falta agregar función de generar turno aleatorio
                                }
                                sigueVivo1 = player2.estaVivo();
                                sigueVivo2 = player1.estaVivo();
                            } while (sigueVivo1 && sigueVivo2 && sigueJugando1 && sigueJugando2);
                            //Poner estado del ganador y cantidad de turnos.
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
                } while (opcion != 4 && sigueVivo1 && sigueVivo2 && sigueJugando1 && sigueJugando2);
            }
        } while (inicio != 3);
    }
}
