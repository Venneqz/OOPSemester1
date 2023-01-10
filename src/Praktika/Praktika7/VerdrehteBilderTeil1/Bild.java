package Praktika.Praktika7.VerdrehteBilderTeil1;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;


public class Bild {
    int[][] daten;
    int breite;
    int hoehe;
    int maxHelligkeit;
    String fileHeader;

    void leseBild(String dateiname) throws IOException {
        try {
            // Read file
            Path path = Paths.get(dateiname);
            String data = Files.readString(path, java.nio.charset.StandardCharsets.US_ASCII);
            String[] lines = data.split("\n"); // Split by line

            // Get width and height
            String formatLine = lines[1].trim(); //get the format and trim it
            String[] format = formatLine.split(" "); //split the format by whitespace
            int width = Integer.parseInt(format[0]); //get the width
            breite = width;
            int height = Integer.parseInt(format[1]);  //get the height
            hoehe = height;

            // Get maxHelligkeit
            String maxBrightness = lines[2].trim(); //get the maxHelligkeit and trim it
            maxHelligkeit = Integer.parseInt(maxBrightness); //parse the maxHelligkeit to an int

            // Get data
            String filedata = lines[0].trim(); //get the data and trim it
            fileHeader = filedata;


            //new temp int array
            int[][] temp = new int[height][width];
            //convert the data to int and put it in the temp array
            for (int i = 0; i < height; i++) {
                String[] numbers = lines[i + 3].split("\\s+"); //split the line by whitespace
                for (int j = 0; j < width; j++) {
                    try {
                        temp[i][j] = Integer.parseInt(numbers[j]); //parse the number to an int and put it in the temp array
                    }
                    catch (NumberFormatException e) {
                    }

                }
            }
            daten = temp;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cannot read file: " + dateiname);
            System.exit(0);
        }
    }

    //Printer
    void printBild(int[][] daten) {
        System.out.println("Ausgabe des Bildes: ");
        for (int i = 0; i < daten.length; i++) {
            for (int j = 0; j < daten[i].length; j++) {
                System.out.print(daten[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");
    }


    //c)
    void rotiereBild() {
        //with and height of the new array
        int rWidth = hoehe;
        int rHeight = breite;
        // matrix 90° gegen den Uhrzeigersinn drehen
        int[][] temp = new int[rHeight][rWidth];
        // Matrix transponieren
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = daten[j][daten[j].length - i - 1];
            }
        }
        daten = temp;
        //swap width and height
        hoehe = rHeight;
        breite = rWidth;
    }

    void schreibeBild(String verzeichnis) throws IOException, IOException {
        LocalDate date = LocalDate.now();
        try {
            Path file = Paths.get(verzeichnis + date + ".pgm");
            // if file doesnt exists, then create it
            if (!Files.exists(file)) {
                Files.createFile(file);
            }
            //put the 2D matrix in the file
            Files.writeString(file, fileHeader + "\n" + breite + " " + hoehe + "\n" + maxHelligkeit + "\n" + matrixToString(daten));
            System.out.println("File written to: " + file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cannot write file: " + verzeichnis);
            System.exit(0);
        }
    }

    private String matrixToString(int[][] matrix) {
        String result = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10) {
                    result += matrix[i][j] + "  ";
                } else {
                    result += matrix[i][j] + " ";
                }
            }
            result += "\n";
        }
        return result;
    }

}
