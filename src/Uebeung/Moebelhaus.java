package Uebeung;

public class Moebelhaus {
    //Anzahl an verfügbaren Schränken ausgeben
    public static void anzahlSchränke(Schrank[] schränke) {
        int anzahl = 0;
        for (Schrank schrank : schränke) {
            if (schrank.isVorhanden()) {
                anzahl++;
            }
        }
        System.out.println("Es sind " + anzahl + " Schränke vorhanden");
    }
}
