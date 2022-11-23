package Praktika.Praktika3.Bildbearbeitung;

public class BildTest {
    public static void main(String[] args) {

        int testbild1[][] = {
                {1, 1, 0, 1},
                {0, 1, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0},
        };

        int testbild2[][] = {
                {0, 0, 1, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 0, 0, 1, 1},
                {0, 1, 0, 1, 0},

        };

        int testbild3[][] = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
                {0, 1, 0},
        };


        Bild test1 = new Bild();
        test1.setMatrix(testbild1);
        test1.flipAndInvert();
        test1.ausgabe();


        Bild test2 = new Bild();
        test2.setMatrix(testbild2);
        test2.flipAndInvert();
        test2.ausgabe();

        Bild test3 = new Bild();
        test3.setMatrix(testbild3);
        test3.flipAndInvert();
        test3.ausgabe();

    }
}
