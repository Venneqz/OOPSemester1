package Uebeung;

public class zufallszahl {
    static int zufallszahl = (int) (Math.random() * 100);

    public static void main(String[] args) {
        while(zufallszahl != 0) {
            System.out.println(zufallszahl);
            zufallszahl = (int) (Math.random() * 100);
        }
        if(zufallszahl == 0) {
            System.out.println("Zufallszahl ist 0");
            Exception e = new Exception("Zufallszahl ist 0");
        }
    }
}
