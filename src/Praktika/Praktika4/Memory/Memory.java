package Praktika.Praktika4.Memory;
import java.lang.Math;

public class Memory {

    //generating the field
    public int[][] generateField(int n) {
        //checking for even number
        if (n % 2 != 0 || n < 2) {
            System.out.println("Fields can only be created with even numbers");
            System.exit(0);
        }
        //creating new matrix as field
        int[][] field = new int[n][n];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = 0;
            }
        }
        //filling field
        int rnd1;
        int rnd2;
        int counter = 0;
        while(counter < (n*n)){
            rnd1 = (int) (Math.random()* n);
            rnd2 = (int) (Math.random()* n);
            if(field[rnd1][rnd2] == 0){
                field[rnd1][rnd2] = (counter /2) +5;
                counter++;
            }
        } return field;
    }

    //Printing out the field
    public void printField (int[][] field){
        System.out.println("Field for your entry: " + field.length);
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}