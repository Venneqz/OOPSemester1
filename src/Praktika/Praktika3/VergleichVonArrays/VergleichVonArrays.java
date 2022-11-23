package Praktika.Praktika3.VergleichVonArrays;

public class VergleichVonArrays {


    //bubbleSort to sort the arrays
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; ++i) {

            for (int j = 0; j < n - i - 1; ++j) {

                if (arr[j + 1] < arr[j]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
    }


    //check if the arrays are equal
    public static boolean isEqual(int[] arr1, int[] arr2) {
        //checking for empty arrays
        if (arr1 == null || arr1.length == 0) {
            System.out.println("Leeres Array");
            System.exit(0);
        }
        if (arr2 == null || arr2.length == 0) {
            System.out.println("Leeres Array");
            System.exit(0);
        }
        bubbleSort(arr1);
        bubbleSort(arr2);
        boolean check = false;
        //Going through the arrays and comparing them one by one
        if (arr1.length == arr2.length) {
            for (int m = 0; m < arr1.length; m++) {
                if (arr1[m] == arr2[m]) {
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }
        }
        System.out.println("Are these arrays Equal?");
        return check;
    }
}
