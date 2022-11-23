package Praktika.Praktika3.Bildbearbeitung;

public class Bild {
    private static int[][] matrix;

    public Bild flipAndInvert() {
        //checking for empty arrays
        if (matrix == null || matrix.length == 0) {
            System.out.println("Leeres Array");
            System.exit(0);
        }
        //To flip the image
        int store;
        for (int i = 0; i < Bild.matrix.length / 2; i++) {
            for (int j = 0; j < Bild.matrix[i].length; j++) {
                store = Bild.matrix[i][j];
                Bild.matrix[i][j] = Bild.matrix[Bild.matrix.length - 1 - i][j];
                Bild.matrix[Bild.matrix.length - 1 - i][j] = store;
            }
        }
        //to invert the image
        for (int i = 0; i < Bild.matrix.length; i++) {
            for (int j = 0; j < Bild.matrix[i].length; j++) {
                if (Bild.matrix[i][j] == 0) {
                    Bild.matrix[i][j] = 1;
                } else {
                    Bild.matrix[i][j] = 0;
                }
            }
        }
        return this;
    }

    //to print out the flipped and inverted image
    public static void ausgabe() {
        System.out.println("Flipped and inverted: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }


    //Getter and setter
    public static int[][] getMatrix() {
        return matrix;
    }

    public static void setMatrix(int[][] matrix) {
        Bild.matrix = matrix;
    }
}