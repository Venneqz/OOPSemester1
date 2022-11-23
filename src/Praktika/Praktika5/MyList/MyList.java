package Praktika.Praktika5.MyList;

public class MyList {
    private static int list[] = new int[0];


    public static void addToList(int index, int item) {
        //create new array with lengt 1 more than original for new int
        int[] tempArray = new int[list.length + 1];


        //check for index bigger than the list
        if (index > list.length + 1 || index < 0) {
            System.out.println("This index is not available (bigger than array or smaller then 0)");
            System.exit(0);
        }


        //rearranging the array
        System.out.println("Adding: " + item + " at index: " + index);
        for (int i = 0; i < index; i++) {//copy the untouched items in front of the index into the new array
            tempArray[i] = list[i];
        }
        for (int i = index; i < list.length; i++) {//rearrange the items into the new array behind the index (+1 for each)
            tempArray[i + 1] = list[i];
        }
        tempArray[index] = item; //copy in the new item on index


        //copy the temp/new array the old array
        list = tempArray;
    }


    public static void removeFromList(int index) {
        //check for index bigger than the list
        if (index > list.length || index < 0) {
            System.out.println("This index isnt available");
            System.exit(0);
        }
        if (list.length < 0){
            System.out.println("Your list is empty");
            System.exit(0);
        }

        //rearranging the arrays
        System.out.println("Removing: " + list[index] + " from index: " + index);
        int[] tempArray = new int[list.length - 1]; //create new array one smaller than the old to fit the new length
        int counter = 0;
        for (int i = 0; i < tempArray.length + counter; i++) { //copy all items except the index into new array one after another
            if (i != index) {
                tempArray[i - counter] = list[i];
            } else counter++;
        }

        //make the told array the new/temp array
        list = tempArray;
    }


    public static void sortList() {
        //selection sort
        int n = list.length;
        for (int i = 0; i < n-1; i++)
        {
            // Find the smallest element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (list[j] < list[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first element
            int temp = list[min_idx];
            list[min_idx] = list[i];
            list[i] = temp;
        }
        System.out.println("");
        System.out.println("Sorting done!");
        System.out.println("");
    }


    public static int removeDuplicates() {
        System.out.println("");
        System.out.println("Removing duplicates...");
        int doubles = 0;
        int current = 0;
        boolean checker = false;

        while (!checker) {
            for (int i = current + 1; i < list.length; i++) { //for loop to go through the array
                if (list[current] == list[i]) { //check if current item is equal to the one before
                    removeFromList(i); //using the remove methode to remove it
                    doubles++;
                }
            }
            current++; //for going throught the loop
            if (current >= list.length) { //end for loop at the end of the list
                checker = true;
            }
        }
        //looking if doubles were found
        if (doubles == 0) {
            System.out.println("There are no duplications");
        } else {
            System.out.println("Amount of delted duplicates: " + doubles);
            System.out.println("");
        }
        return doubles;
    }

    public static int kombiZahlen(int zahl) {
        int counter = 0;
        System.out.println("");
        System.out.println("Combinations:");
        //one for loop for each int of the operation
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                for (int k = j + 1; k < list.length; k++) {
                    if (list[i] + list[j] + list[k] == zahl) { //check if the integers match the sum
                        counter++;
                        System.out.print(list[i] + "(" + i + ")" + "+" + list[j] + "(" + j + ")" + "+" + list[k] + "(" + k + ")" + "=" + zahl);
                        System.out.println("");
                    }
                }
            }
        }
        System.out.println("");
        System.out.println("Amount of combinations: " + counter + " for sum " + zahl);
        System.out.println("");
        return counter;
    }


    public static void ausgabe() {
        //for printing out the list (wasnt needed, just for checking purposes)
        System.out.println("");
        System.out.println("Items on List: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println("");
    }
}
