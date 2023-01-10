package Praktika.Praktika8.Poststation;

public class PoststationTest {
    public static void main(String[] args) {
        Fahrrad rad1 = new Fahrrad(20);
        Fahrrad rad2 = new Fahrrad(25);
        Fahrrad rad3 = new Fahrrad(30);
        Fahrrad rad4 = new Fahrrad(35);


        Fahrradgruppe gruppe = new Fahrradgruppe();
        gruppe.addFahrrad(rad1);
        gruppe.addFahrrad(rad2);
        gruppe.addFahrrad(rad3);
        gruppe.uebersicht();
        gruppe.addFahrrad(rad4);
        gruppe.uebersicht();
        gruppe.addLadung(50);
        gruppe.uebersicht();
    }
}
