package Praktika.Praktika6.Temperaturgraph;

public class TemperaturGraph {
    private int[] temp = new int[12];
    private int entry_year;


    public TemperaturGraph(int year) {
        //for entering the year
        entry_year = year;
    }


    public void addTemperatur(int month, int temperature) {
        //no negative temperatures
        if (temperature < 0) {
            System.out.println("Temperature cant be negative");
        } else {
            temp[month - 1] = temperature; //adding the temperature to the array
        }
    }


    public void plotGraph() {
        System.out.println("Temperatur Graph for the year: " + entry_year);
        //find the lowest index of the array
        int lowest = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) { //checking if every index is filled
                System.out.println("No temperature for month: " + (i + 1));
                System.exit(0);
            }
            if (temp[i] < temp[lowest]) {
                lowest = i;
            }
        }

        //find the highest index of the array
        int highest = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > temp[highest]) {
                highest = i;
            }
        }

        //print out # for every month according to the temperature vertically, on the left display the temperature
        for (int i = temp[highest]; i >= temp[lowest]; i--) {
            System.out.print(i + "  ");
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] >= i) {
                    System.out.print("# ");
                } else System.out.print("  ");
            }
            System.out.println();
        }
    }
}


