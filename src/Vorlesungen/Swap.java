package Vorlesungen;

public class Swap {
    public static void swap(int[] a, int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a [j];
        a[j] = temp;

    }
}
