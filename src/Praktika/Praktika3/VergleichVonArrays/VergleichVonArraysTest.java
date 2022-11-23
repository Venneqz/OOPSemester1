package Praktika.Praktika3.VergleichVonArrays;

public class VergleichVonArraysTest {
    public static void main(String[] args) {
        VergleichVonArrays test1 = new VergleichVonArrays();
        System.out.println(test1.isEqual(new int[]{1, 2, 3, 4}, new int[]{3, 1, 6, 2}));


        System.out.println();


        VergleichVonArrays test2 = new VergleichVonArrays();
        System.out.println(test2.isEqual(new int[]{3, 5, 1, 3}, new int[]{1, 5, 3, 3}));
    }
}
