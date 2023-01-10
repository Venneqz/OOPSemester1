package Praktika.Praktika9.OOPCode;
public class OOPCode {
    // Klassenvariable, die die Größe des OOPCode-Bildes speichert
    private int size;

    // Konstruktor, der die Größe des OOPCode-Bildes initialisiert
    public OOPCode(int size) {
        this.size = size;
    }

    // Methode zum Berechnen des OOPCode-Werts für ein gegebenes Bild
    public int calculateOOPCode(boolean[][] image) {
        int oopCode = 0;
        // Iterieren über jedes Pixel im Bild und berechnen des OOPCode-Wertes
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Wenn das Pixel schwarz ist, hinzufügen des Wertes zum OOPCode
                if (image[i][j]) {
                    // Berechnen des Wertes des Pixels anhand seiner Position im Bild
                    int value = (int) Math.pow(2, (size * size - 1) - (i * size + j));
                    oopCode += value;
                }
            }
        }
        return oopCode;
    }

    // Methode zum Berechnen des größten OOPCode-Werts für ein gegebenes Bild
    public void calculateMaxOOPCode(boolean[][] image) {
        int maxOOPCode = 0;
        int numRotations = 0;
        // Drehen des Bildes im Uhrzeigersinn um 90°, bis der größte OOPCode erreicht ist
        for (int i = 0; i < 4; i++) {
            // Berechnen des OOPCode-Wertes des aktuellen Bildes
            int oopCode = calculateOOPCode(image);
            // Wenn der OOPCode-Wert größer ist als der aktuelle größte OOPCode-Wert, aktualisieren des größten OOPCode-Wertes
            if (oopCode > maxOOPCode) {
                maxOOPCode = oopCode;
                numRotations = i;
            }
            // Drehen des Bildes um 90° im Uhrzeigersinn
            image = rotateImage(image);
        }
        // Ausgeben des größten OOPCode-Wertes und der Anzahl der Drehungen
        System.out.println("OOPCode zu Beginn: " + calculateOOPCode(image));
        System.out.println("Höchstmöglicher OOPCode: " + maxOOPCode);
        System.out.println("Benötigte Rotationen für den höchstmöglichen OOPCode: " + numRotations + "x 90° im Uhrzeigersinn");
    }

    // Methode zum Drehen eines Bildes um 90° im Uhrzeigersinn
    private boolean[][] rotateImage(boolean[][] image) {
        boolean[][] rotatedImage = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotatedImage[i][j] = image[size - j - 1][i];
            }
        }
        return rotatedImage;
    }
}