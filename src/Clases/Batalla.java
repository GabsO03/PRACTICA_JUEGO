package Clases;

import java.util.Scanner;

public class Batalla {
    //ATRIBUTOS
    private Heroe heroeJugador;
    private Heroe heroeComputer;
    private int turnos;
    private String inicio;
    private int turno = 0;

    //MÉTODOS
    public Batalla(Heroe heroeJugador, Heroe heroeComputer, String inicio, int turnos) {
        this.heroeJugador = heroeJugador;
        this.heroeComputer = heroeComputer;
        this.turnos = turnos;
        this.inicio = inicio;
        this.turno = 0;
    }

    //GETTERS
    public Heroe getHeroeJugador() {
        return heroeJugador;
    }

    public Heroe getHeroeComputer() {
        return heroeComputer;
    }

    public int getTurnos() {
        return turnos;
    }

    public String getInicio() {
        return inicio;
    }

    public int getTurno() {
        return turno;
    }

    //SETTERS

    public void setHeroeJugador(Heroe heroeJugador) {
        this.heroeJugador = heroeJugador;
    }

    public void setHeroeComputer(Heroe heroeComputer) {
        this.heroeComputer = heroeComputer;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    //OTROS

    public Heroe ganador(Heroe player1, Heroe player2, boolean sigueVivo1, boolean sigueVivo2, boolean sigueJugando1, boolean sigueJugando2) {
        if (turno == turnos) {
            if (player1.getVida() > player2.getVida())
                return player1;
            else if (player2.getVida() > player1.getVida()) {
                return player2;
            }
            int aleatorio = (int) (Math.random() * 2 + 1);
            if (aleatorio == 1) {
                return player1;
            }
        } else if (sigueVivo1 && sigueJugando1) {
            return player1;
        }
        return player2;

    }

    public int primerAtaque() {
        return (int) (Math.random() * 2 + 1);
    }

    public Heroe generaHeroeComputer(Heroe[] heroes) {
        int aleatorio = (int) (Math.random() * heroes.length);
        return heroes[aleatorio];
    }

    public Complemento generaComplementoComp(Complemento[] complementos) {
        int aleatorio = (int) (Math.random() * complementos.length);
        return complementos[aleatorio];
    }

    public void turno(Heroe player1, Heroe player2, int inicio, Batalla batalla1) {
        boolean sigueVivo1, sigueVivo2, sigueJugando1 = true, sigueJugando2 = true;
        do {
            if (player1.getVelocidad() > player2.getVelocidad()) {
                sigueJugando1 = sigueJugando(player1, player2);
                turno++;
                if (inicio == 2) sigueJugando2 = sigueJugando(player2, player1);
                else juegaCPU(player2, player1);
            } else if (player2.getVelocidad() > player1.getVelocidad()) {
                turno++;
                if (inicio == 2) sigueJugando2 = sigueJugando(player2, player1);
                else juegaCPU(player2, player1);
                sigueJugando1 = sigueJugando(player1, player2);

            } else {
                switch (batalla1.primerAtaque()) {
                    case 1: {
                        sigueJugando1 = sigueJugando(player1, player2);
                        if (inicio == 2) sigueJugando2 = sigueJugando(player2, player1);
                        else juegaCPU(player2, player1);
                        turno++;
                    }
                    case 2: {
                        if (inicio == 2) sigueJugando2 = sigueJugando(player2, player1);
                        else juegaCPU(player2, player1);
                        sigueJugando1 = sigueJugando(player1, player2);
                        turno++;
                    }
                }
            }
            sigueVivo1 = player1.estaVivo();
            sigueVivo2 = player2.estaVivo();
        } while (sigueVivo1 && sigueVivo2 && sigueJugando1 && sigueJugando2 && turno < turnos);
        System.out.println(batalla1.ganador(player1, player2, sigueVivo1, sigueVivo2, sigueJugando1, sigueJugando2));
    }

    public static boolean sigueJugando(Heroe ataca, Heroe recibe) {
        Scanner reader = new Scanner(System.in);
        String[] frasesAtaque = {"Toma mango", "Y eso no es todo", "Pim pam pum", "Por comerte mi chococrispis"};
        int opcion, complemento;
        System.out.println("Turno de " + ataca.getNombre());
        do {
            System.out.println("Menú de batalla:\n1.Atacar\n2.Ver mi estado\n3.Usar complementos\n4. Rendirse");
            opcion = Integer.parseInt(reader.nextLine());
            switch (opcion) {
                case 1 -> ataca.atacaA(recibe, frasesAtaque);
                case 2 -> System.out.println(ataca);
                case 3 -> {
                    if (ataca.getComplemento() != null) {
                        System.out.println("Elige sabiamente.\n1. Ataque\n2. Defensa\n3. Velocidad\n4. Recuperar vida\n5. Cancelar");
                        complemento = Integer.parseInt(reader.nextLine());
                        switch (complemento) {
                            case 1 -> ataca.usarComplementoAtaque();
                            case 2 -> ataca.usarComplementoDefensa();
                            case 3 -> ataca.usarComplementoVelocidad();
                            case 4 -> ataca.recuperarVida();
                            case 5 -> System.out.println("a");
                            default -> System.out.println("What?");
                        }
                    } else System.out.println("Debiste equipar complemento antes de la batalla");
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

    public static boolean juegaCPU(Heroe cpu, Heroe recibe) {
        String[] frasesAtaque = {"Toma mango", "Y eso no es todo", "Pim pam pum", "Por comerte mi chococrispis"};
        int opcion, complemento;
        System.out.println("Turno de " + cpu.getNombre());
        do {
            opcion = (int) (Math.random() * 2 + 1);
            switch (opcion) {
                case 1 -> cpu.atacaA(recibe, frasesAtaque);
                case 2 -> {
                    if (cpu.getComplemento() != null) {
                        complemento = (int) (Math.random() * 4 + 1);
                        switch (complemento) {
                            case 1 -> cpu.usarComplementoAtaque();
                            case 2 -> cpu.usarComplementoDefensa();
                            case 3 -> cpu.usarComplementoVelocidad();
                            case 4 -> cpu.recuperarVida();
                        }
                    }
                }
            }
            if (cpu.getVida() <= 50) cpu.recuperarVida();
            if (cpu.getVida() <= 10) return false;
        } while (opcion != 1 && opcion != 4);
        return true;
    }

}


