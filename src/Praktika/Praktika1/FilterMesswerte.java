package Praktika.Praktika1;

import java.util.Scanner; //importing the scanner for inputs

public class FilterMesswerte {
    public static void main(String[] args) {
        filterMesswerte();
    } //calls up Methode filterMesswerte

    public static void filterMesswerte() {
        Scanner sc = new Scanner(System.in); //adding a new scanner
        int entry; //integer for user input
        int one_counter = 0; //counter for inputs of 1
        int zero_counter = 0; //counter for inputs of 0

        do { //starting the loop
            System.out.print("Entered Data: ");
            entry = sc.nextInt(); //Scanner for filter input

            if (entry > 0) { //filtering of numbers bigger than 0
                if (entry == 1) {
                    one_counter++; //checking if entry is 1 and updating the one counter
                } else {
                    one_counter = 0; //resetting one and zero counter because last input isnt 0 or 1
                }
            }
            else if (entry == 0) { //checking for 0
                one_counter = 0; //resetting one counter because input isn´t 1
                if (zero_counter < 1) { //checking if the last input was a zero
                    System.out.println("Output Data: 0"); //printing out a 0 if it wasnt
                    zero_counter++; //updating the 0 counter so next output cant be a 0
                }
            }
            else {
                entry = entry * -1; //making negative numbers positive
                System.out.println("Output Data: " + entry);
                zero_counter = 0; //resetting the zero counter
                one_counter = 0; //resetting the one counter
            }

        } while (one_counter != 3); //ending the while loop when 3 ones were input back to back
    }
}
