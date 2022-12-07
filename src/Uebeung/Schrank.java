package Uebeung;

public class Schrank {
    private int laenge;
    private int breite;
    private int hoehe;
    private int counter = 0;

    public Schrank(String name, int [] abmessung, int preis) {
        if (abmessung.length != 3) {
            throw new IllegalArgumentException("Abmessung muss 3 Werte enthalten");
        }
        this.laenge = abmessung[0];
        this.breite = abmessung[1];
        this.hoehe = abmessung[2];
        boolean vorhanden = false;

        if (laenge != 0) {
            if (breite != 0) {
                if (hoehe != 0) {
                    if (preis >= 100) {
                        vorhanden = true;
                    }
                }
            }
        }
        else {
            vorhanden = false;
        }
        if (vorhanden == true) {
            System.out.println("Der Schrank " + name + " ist vorhanden");
            counter++;
        }
        else if (vorhanden == false) {
            System.out.println("Der Schrank " + name + " ist nicht vorhanden");
        }
    }

    public boolean isVorhanden() {
        return counter > 0;
    }
}
