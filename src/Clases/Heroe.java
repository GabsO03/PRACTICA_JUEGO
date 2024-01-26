package Clases;

public class Heroe {
    //ATRIBUTOS
    private String nombre;
    private int ataque;
    private int velocidad;
    private int defensa;
    private int vida;
    private String apariencia;
    private Complemento complemento;

    //MÉTODOS
    public Heroe(String nombre, int ataque, int velocidad, int defensa, String apariencia, Complemento complemento) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.vida = 100;
        this.apariencia = apariencia;
        this.complemento = complemento;
    }
    public Heroe (Heroe heroe) {
        this.nombre = heroe.getNombre();
        this.ataque = heroe.getAtaque();
        this.velocidad = heroe.getVelocidad();
        this.defensa = heroe.getDefensa();
        this.vida = 100;
        this.apariencia = heroe.getApariencia();
        this.complemento = heroe.getComplemento();
    }
    public Heroe(String nombre, int ataque, int velocidad, int defensa, String apariencia) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.vida = 100;
        this.apariencia = apariencia;
    }

    //GETTERS
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
    public String getApariencia() {
        return apariencia;
    }
    public Complemento getComplemento() {
        return complemento;
    }

    //SETTERS
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
    public void setApariencia(String apariencia) {
        this.apariencia = apariencia;
    }
    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

    //OTROS
    public boolean estaVivo () {
        return vida > 0;
    }
    public int devuelveAtaqueTotal () {
        return 1;
    }
    public int devuelveVidaTotal () {
        return 2;
    }
    public int devuelveDefensaTotal () {
        return 3;
    }
    public int devuelveVelocidadTotal () {
        return 4;
    }
    public void equiparComplemento (Complemento complemento) {

    }
    public boolean desequiparComplemento () {
        return true;
    }
    public void restaVida (int ataque) {
        vida -= (ataque-defensa);
    }

    //ACCIONES
    public void atacar (Heroe computer) {
        computer.setVida(computer.getVida()-ataque);
    }
    public void recuperarVida () {
        this.vida += complemento.getVida();
    }

}
