package Clases;
public class Test {

    public static void main(String[] args) {
        Heroe h1 = new Heroe("Aaron", 45, 30, 25, "Fornido");
        Heroe pc = new Heroe("Bruno", 36, 30, 25, "Cabezón");


        System.out.println("dsfgfjhjhg"+pc.getVida());

        System.out.println("Menú de batalla:\n1.Atacar\n2.Ver mi estado\n3.Usar complementos");
        int opcion = 1;
        switch (opcion) {
           // case 1 -> h1.atacaA(pc, frasesAtaque);
            case 2 -> System.out.println(h1);
            case 3 -> System.out.println("JNHN");
        }
        System.out.println("dsfgfjhjhg"+pc.getVida());


    }
}
