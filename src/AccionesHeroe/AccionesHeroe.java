package AccionesHeroe;

import Clases.Heroe;

import java.util.Scanner;

public class AccionesHeroe {
    public static String readString () {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
    public static int readInt () {
        return Integer.parseInt(readString());
    }


}
