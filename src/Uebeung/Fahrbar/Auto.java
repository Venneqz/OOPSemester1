package Uebeung.Fahrbar;

public class Auto implements Fahrbar {
    public void beschleunigen(double wert) {
        System.out.println("Auto beschleunigt");
        System.out.println(wert + READER);
    }
    public void verzoegern(double wert) {
        System.out.println("Auto verzoegert");
        System.out.println(wert * READER);
    }
}
