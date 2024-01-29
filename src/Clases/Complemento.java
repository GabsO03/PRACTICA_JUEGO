package Clases;
public class Complemento {
    private String nombre;
    private int ataque;
    private int velocidad;
    private int defensa;
    private int vida;

    public Complemento(String nombre, int ataque, int velocidad, int defensa, int vida) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.vida = vida;
    }
    public Complemento (Complemento complemento) {
        this.nombre = complemento.getNombre();
        this.ataque = complemento.getAtaque();
        this.velocidad = complemento.getVelocidad();
        this.defensa = complemento.getDefensa();
        this.vida = complemento.getVida();
    }

    public String getNombre() {
        return nombre;
    }
    public int getAtaque() {
        return ataque;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public int getDefensa() {
        return defensa;
    }
    public int getVida() {
        return vida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nAtaque: " + ataque + "\nVelocidad: " + velocidad + "\nDefensa:" + defensa +  "\nVida: " + vida;
    }
}
