package Praktika.Praktika3.Median;

public class MedianTest {
    public static void main(String[] args) {
        Median test1 = new Median();
        System.out.println("Der Median ist " + test1.median(new int[]{12, 16, 2, 63, 55, 8}));

        System.out.println();

        Median test2 = new Median();
        System.out.println("Der Median ist " + test2.median(new int[]{42, 7, 543, 77, 87, 876, 143}));
    }
}
