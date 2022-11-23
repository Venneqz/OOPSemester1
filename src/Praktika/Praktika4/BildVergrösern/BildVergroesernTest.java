package Praktika.Praktika4.BildVergrösern;

public class BildVergroesernTest {
    public static void main(String[] args) {
        BildVergroesern test1 = new BildVergroesern();
        int [][] testbild1 = {
                {1, 7, 0},
                {1, 0, 3},
                {0, 2, 1},
        };
        test1.setEntryMatrix(testbild1);
        ausgabe(test1.zoom(2));
        ausgabe(test1.zoom(3));




        BildVergroesern test2 = new BildVergroesern();
        int [][] testbild2 = {
                {1, 0, 2},
                {4, 2, 4},
                {2, 0, 1},
        };
        test2.setEntryMatrix(testbild2);
        ausgabe(test2.zoom(2));
        ausgabe(test2.zoom(3));
    }

    //print method
    public static void ausgabe(int [][] ausgabe){
        //print
        System.out.println("Zoomed Matrix");
        for (int i = 0; i < ausgabe.length; i++) {
            for (int j = 0; j < ausgabe.length; j++) {
                System.out.print(ausgabe[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
