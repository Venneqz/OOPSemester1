package Praktika.Praktika6.Bruch;

public class BruchTest {
    public static void main(String[] args) {
        Bruch bruch1 = new Bruch(2,2);
        Bruch bruch2 = new Bruch(-1,-2);




        System.out.println("bruch1 + bruch2 = " + bruch1.add(bruch2));
        System.out.println("bruch1 * bruch2 = " + bruch1.multiply(bruch2));

        System.out.println("Bruch 1 als String: " + bruch1.toString());
    }
}
