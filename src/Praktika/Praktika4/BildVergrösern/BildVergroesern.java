package Praktika.Praktika4.BildVergrösern;

public class BildVergroesern {
    private static int[][] entryMatrix;
    private static int[][] outputMatrix;


    public int[][] zoom(int f) {
        //checker
        for (int i = 0; i < entryMatrix.length; i++) {
            for (int j = 0; j < entryMatrix[0].length; j++) {
                if (entryMatrix[i][j] > 8 || entryMatrix[i][j] < 0){
                    System.out.println("Bitte gebe nur Zahlen zwischen 0 und  ein");
                    System.exit(0);
                }
                if (entryMatrix == null || entryMatrix.length == 0){
                    System.out.println("Die Eingabe ist leer");
                    System.exit(0);
                }
            }
        }

        //zoom
        outputMatrix = new int[entryMatrix.length * f][entryMatrix.length * f];
        for (int i = 0; i < outputMatrix.length; i++){
            for (int j = 0; j < outputMatrix[0].length; j++){
                outputMatrix[i][j] = entryMatrix[i / f][j / f];
            }
        }
        return outputMatrix;
    }

    //Setter and Getter
    public int[][] getEntryMatrix() {
        return entryMatrix;
    }

    public void setEntryMatrix(int[][] entryMatrix) {
        this.entryMatrix = entryMatrix;
    }

    public int[][] getNewMatrix() {
        return outputMatrix;
    }

    public void setNewMatrix(int[][] newMatrix) {
        this.outputMatrix = newMatrix;
    }


}
