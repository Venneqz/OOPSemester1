package Praktika.Praktika7.VerdrehteBilderTeil1;

import java.io.IOException;

public class BildTest {
    public static void main(String[] args) throws IOException {
        Bild bild = new Bild();
        bild.leseBild("C:/Users/matti/Downloads/java.pgm");
        bild.rotiereBild();
        bild.schreibeBild("C:/Users/matti/Downloads/");
    }
}
