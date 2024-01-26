package Clases;

public class Batalla {
    //ATRIBUTOS
    private Heroe heroeJugador;
    private Heroe heroeComputer;
    private int turnos;
    private String inicio;
    private int turno;

    //MÉTODOS
    public Batalla(Heroe heroeJugador, Heroe heroeComputer, int turnos, String inicio, int turno){
        this.heroeJugador = heroeJugador;
        this.heroeComputer = heroeComputer;
        this.turnos = turnos;
        this.inicio = inicio;
        this.turno = turno;
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

   /* public Heroe ganador(){

    }*/
}
