package Praktika.Praktika1;


public class BerechneWochentag {
    public static void main(String[] args) {
        berechneWochentag(5,11,2003); //calls up Method berechneWochentag with the parameters
    }

    public static void berechneWochentag (int d , int m , int y_entry){ //Method berechenWochentag
        if ((d < 1) || (d > 31)) { //Checking for a valid range of days
            System.out.println("Please enter a valid date! (Hint: Day between 1-31)");
            System.exit(0); //Exiting if the day isn´t in range (1-31)
        }

        if ((m > 12) || (m < 1)) { //Checking for valid range of month
            System.out.println("Please enter a valid date! (Hint: Month between 1-12)");
            System.exit(0); //Exiting if the input isn´t in range
        }


        if (m < 3) { //Checking if the month is January or February
            m = m + 12; //adding 10 to month if above is the case to make it a month from the year before
            y_entry = y_entry - 1; //subtracting one year because it´s the year before
        }


        int c = y_entry / 100; //dividing year by 100 to get the century
        int y = y_entry % 100; //getting the modulo of y/100 to get the year in the century

        int w = (d + ((26 * (m + 1)) / 10) + ((5 * y) / 4) + (c / 4) + (5 * c) - 1) % 7; //given formula


        switch (w) { //switch case to determine the day of the week, starting with sunday as 0
            case 0:
                System.out.println("Sunday");
                break;

            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            case 3:
                System.out.println("Wednsday");
                break;

            case 4:
                System.out.println("Thursday");
                break;

            case 5:
                System.out.println("Friday");
                break;

            case 6:
                System.out.println("Saturday");
                break;
        }
    }
}
