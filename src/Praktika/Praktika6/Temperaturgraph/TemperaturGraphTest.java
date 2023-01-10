package Praktika.Praktika6.Temperaturgraph;

public class TemperaturGraphTest {
    public static void main(String[] args) {
        TemperaturGraph test = new TemperaturGraph(2004);
        test.addTemperatur(1,15);
        test.addTemperatur(2,14);
        test.addTemperatur(3,13);
        test.addTemperatur(4,15);
        test.addTemperatur(5,11);
        test.addTemperatur(6,11);
        test.addTemperatur(7,12);
        test.addTemperatur(8,13);
        test.addTemperatur(9,11);
        test.addTemperatur(10,12);
        test.addTemperatur(11,11);
        test.addTemperatur(12,11);
        test.plotGraph();
    }
}
