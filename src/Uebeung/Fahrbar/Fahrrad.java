package Uebeung.Fahrbar;

public class Fahrrad implements Fahrbar {
    public void beschleunigen(double wert) {
        System.out.println("Fahrrad beschleunigt");
        System.out.println(wert + READER);
    }
    public void verzoegern(double wert) {
        System.out.println("Fahrrad verzoegert");
        System.out.println(wert * READER);
    }
}
