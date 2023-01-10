
public class ShoppingTest {
    public static void main(String[] args) {
        Warenkorb warenkorb = new Warenkorb();
        warenkorb.addArtikel(new Buch(1, 32.55, "Max Mustermann", "Java das Buch", 2011) );
        warenkorb.addArtikel(new Kleidung(2, 20.0, "M", "blau", "T-Shirt") );
        warenkorb.addArtikel(new DVD(3, 30.0, "Java: Der Film, Classic Collection", "2:21") );
        warenkorb.addArtikel(new DVD(4, 30.0, "Rexilius und der OOP unterricht", "2:21") );
        warenkorb.addArtikel(new Buch(5, 32.55, "Kreienkamp", "Carry Flag", 2011) );
        warenkorb.zeigeWarenkorb();
        warenkorb.removeArtikel(2);
        warenkorb.zeigeWarenkorb();
    }
}
