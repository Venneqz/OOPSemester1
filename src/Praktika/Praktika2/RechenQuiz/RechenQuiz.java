package Praktika.Praktika2.RechenQuiz;
//OOP A2 b)

public class RechenQuiz {

    //variables
    private static int operand1 =  (int)(Math.random() * 20.0) + 1; //to generate a number between 1-20
    private static int operand2 =  (int)(Math.random() * 20.0) + 1; //to generate a number between 1-20
    private static int operator = (int) (Math.random() * 3); //to generate a random number between 0-2 for a random operator
    private static int result;

    //Exercise class
    public static void getExercise(){
        do { //repetition for checking the operator
            if (operator == 0) { //option of operator (+)
                result = ( operand1 + operand2 ); //calculating the result
                System.out.println(operand1 + " + " + operand2 + " = ?"); //printing out the exercise


            } else if (operator == 1) { //option of operator (-)
                result = ( operand1 - operand2 ); //calculating the result
                if (result < 0){ //checking for a negative result in the subtraction
                    operand1 =  (int)(Math.random() * 20.0) + 1; //resetting the operands
                    operand2 =  (int)(Math.random() * 20.0) + 1; //resetting the operands
                }
                else {
                    System.out.println(operand1 + " - " +operand2 + " = ?"); //printing out the exercise
                }


            } else if (operator == 2) { //option of operator (*)
                result = ( operand1 * operand2 ); //calculating the result
                System.out.println(operand1 + " * "+ operand2 + " = ?"); //printing out the exercise
            }
        } while (result < 0); //repeating until the result isnt negative
    }

    //Getter
    public int getResult(){
        return result;
    }
}