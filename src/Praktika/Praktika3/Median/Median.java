package Praktika.Praktika3.Median;

import java.util.*;


public class Median {
    private static int[] a;


    public int median(int[] a) {
        //checking for empty arrays
        if (a == null || a.length == 0) {
            System.out.println("Leeres Array");
            System.exit(0);
        }

        int n = a.length;


        //Sorting the array
        Arrays.sort(a);

        // check for even case
        if (n % 2 != 0) {
            return (int) a[n / 2];
        } else {//odd case
            return (int) (a[(n - 1) / 2] + a[n / 2]) * 1 / 2;
        }
    }

    //getter and setter

    public static int[] getA() {
        return a;
    }

    public static void setA(int[] a) {
        Median.a = a;
    }
}