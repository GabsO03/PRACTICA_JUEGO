package Clases;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Heroe h1 = new Heroe("Aaron", 45, 30, 25, "Fornido");
        Heroe h2 = new Heroe("Bruno", 36, 30, 25, "Cabezón");

        h1.atacaA(h2);

        System.out.println(h2.getVida());

    }
}
