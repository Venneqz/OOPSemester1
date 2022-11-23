package Praktika.Praktika1;

import java.util.Scanner; //importing the Scanner for user inputs


public class RateZahl {
    public static void main(String[] args) {
        rateZahl();
    } //calls up Method rateZahl
    public static void rateZahl() {
        int randomNumber = (int) (Math.random() * 101.0); //generating a random number between 0-100
        Scanner sc = new Scanner(System.in); //adding a new scanner
        int entry; //integer for user input
        int input_counter = 0; //integer for counting the number of inputs

        do { //starting the loop
            System.out.print("Enter your guess: ");
            entry = sc.nextInt(); //making the user input from scanner an integer
            if (entry < randomNumber && entry >= 0) { //checking if the input ist smaller than the random number but not negative
                System.out.println("Wrong guess! The number you´re looking for is bigger than your entry! Try again!");
                input_counter++; //updating the input counter
            }
            if (entry > randomNumber && entry <= 100) { //checking if the input is bigger than the number and 100
                System.out.println("Wrong guess! The number you´re looking for is smaller than your entry! Try again!");
                input_counter++;//updating the input counter
            }
            if (entry > 100 || entry < 0) { //chekcing if number isnt in range (0-100)
                System.out.println("Please only enter numbers between 0-100. Try again!");
            }
            if (entry == randomNumber) { //cheking if the user guessed the right number
                System.out.println("Good Job! You guessed the right number: " + randomNumber); //printing the result
                System.out.println("Number of tries: " + input_counter); //printing the number of tries
            }
        } while (entry != randomNumber); //continuing the loop unless the user guessed the right number
    }
}