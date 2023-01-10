
import java.util.ArrayList;

public class Warenkorb {
    private static ArrayList<Artikel> list = new ArrayList<Artikel>(0);

    //Artikel hinzufügen
    void addArtikel(Artikel artikel){
        System.out.println("");
        System.out.println("Folgender Artikel wurde hinzugefügt: ");
        System.out.println(artikel.getInfo());
        System.out.println("");
        list.add(artikel);
    }

    //Artikel entfernen
    void removeArtikel(int artikelnummer){
        System.out.println("");
        System.out.println("Artikelnummer " + artikelnummer + " wurde entfernt");
        System.out.println(" ");
        int counter;
        list.remove(artikelnummer - 1);
    }

    //Artikel ANZEIGEN
    void zeigeWarenkorb(){
        System.out.println("");
        System.out.println("Warenkorb:");
        System.out.println("");
        for (Artikel artikel : list) {
            System.out.println(artikel.getInfo());
        }
    }
}
