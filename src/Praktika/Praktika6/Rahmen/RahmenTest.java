package Praktika.Praktika6.Rahmen;

public class RahmenTest {
    public static void main(String[] args) {
        Rahmen test = new Rahmen();
        test.setEntry(new String[]{"Rahmen", "sind", "toll"});
        test.frame();

        System.out.println("");

        Rahmen test1 = new Rahmen();
        test1.setEntry(new String[]{"Das ist", "ein", "Test"});
        test1.frame();
    }
}
