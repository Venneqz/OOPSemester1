package Praktika.Praktika4.Memory;

public class MemoryTest {
    public static void main(String[] args) {
        Memory test = new Memory();
        test.printField(test.generateField(4));

        System.out.println("");

        Memory test1 = new Memory();
        test1.printField(test1.generateField(6));
    }
}
