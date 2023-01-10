package Praktika.Praktika9.OOPCode;

public class OOPCodeTest {
    public static void main(String[] args) {
        OOPCode oopCode = new OOPCode(3);
        boolean[][] image = {
            {false, false, false},
            {false, true, false},
            {false, false, true}
        };
        System.out.println("OOPCode: " + oopCode.calculateOOPCode(image));
        oopCode.calculateMaxOOPCode(image);

        System.out.println();

        oopCode = new OOPCode(4);
        image = new boolean[][] {
            {false, false, false, false},
            {false, true, false, false},
            {false, false, true, false},
            {false, false, false, true}
        };
        System.out.println("OOPCode: " + oopCode.calculateOOPCode(image));
        oopCode.calculateMaxOOPCode(image);
    }
}
