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
        return ataque + complemento.getAtaque();
    }
    public int devuelveVidaTotal () {
        return vida + complemento.getVida();
    }
    public int devuelveDefensaTotal () {
        return defensa + complemento.getDefensa();
    }
    public int devuelveVelocidadTotal () {
        return velocidad + complemento.getVelocidad();
    }
    public void equiparComplemento (Complemento complemento) {
        this.complemento = complemento;
    }
    public boolean desequiparComplemento () {
        if (complemento != null ) {
            ataque -= complemento.getAtaque();
            defensa -= complemento.getDefensa();
            velocidad -= complemento.getVelocidad();
            complemento = null;
            return true;
        }
        return false;
    }
    public void restaVida (int ataque) {
        vida -= (ataque-defensa);
    }

    //ACCIONES
    public void atacaA (Heroe recibe, String[] frasesAtaque) {
        System.out.println("Jugador " + nombre + ":" + frasesAtaque[(int)(Math.random()* frasesAtaque.length)]);
        recibe.restaVida(ataque);
    }
    public void recuperarVida () {
        this.vida = devuelveVidaTotal();
        if (vida > 100) {
            complemento.setVida(vida-100);
            vida = 100;
        }
    }
    public void usarComplementoAtaque () {
        ataque = devuelveAtaqueTotal();
    }
    public void usarComplementoDefensa () {
        defensa = devuelveDefensaTotal();
    }
    public void usarComplementoVelocidad () {
        velocidad = devuelveVelocidadTotal();
    }


    @Override
    public String toString() {
        return "Nombre:"+nombre+"\nAtaque:"+ataque+"\nVelocidad:"+velocidad+"\nDefensa:"+defensa+"\nVida:"+vida+"\nApariencia:"+apariencia;
    }
}
