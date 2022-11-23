package Praktika.Praktika2.PrintSanduhr;
//OOP A2 a) Print a hourglass with the given width and height

public class PrintSanduhr {

    //variables
    private static int width;

    //hourglass class
    public static void hourglass(){
        if (width < 0){ //checks for negative width
            width = width * -1; //turns it positive if it is
        }
        if (width <3){ //checks if the width is less than 2
            System.out.println("Bitte gebe nur zahlen über 2 ein");
            width = 0; //2 ist too small for
        }

        System.out.println("Width: " + width);

        //upper half
        for(int i=1; i<=width; i=i+2) //for loop, till the width is reached
        {
            for(int k=1; k<=i-1; k++) //for printing out the spaces to format the stars correctly
            {
                System.out.print(" ");
            }
            for(int j=1; j<=width-i+1; j++) //for printing out the stars
            {
                System.out.print("* ");
            }
            System.out.println();
        }

        //lower half
        if (width % 2 == 0){ //even width
            for(int i=width-2; i>=1; i=i-2) //for loop from widht till 0, but the start cut out
            {
                
                for(int k=1; k<=i-2; k++) //for printing out the spaces to format the stars correctly
                {
                    System.out.print(" ");
                }
                for(int j=i; j-1<=width; j++) //for printing out the stars
                {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
        else { //odd width
            for(int i=width-2; i>=1; i=i-2) //for loop from widht till 0, but the start cut out
            {
                for(int k=1; k<=i-1; k++) //for printing out the spaces to format the stars correctly
                {
                    System.out.print(" ");
                }
                for(int j=i; j<=width; j++) //for printing out the stars
                {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
    //Getter / Setter
    public int getWidth(){
        return width; //returns entered width
    }

    public static void setHourglass(int hourglassWidth) {
        width = hourglassWidth; //sets entered width from test class to width integer
    }
}
