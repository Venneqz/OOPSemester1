
public class Buch extends Artikel {
    private int bruttomwst = 7;
    private double bruttoPreis;
    private String autor;
    private String titel;
    private int erscheinungsjahr;
    private int artikelnummer;

    //constructor
    public Buch(int artikelnummer, double nettopreis, String autor, String titel, int erscheinungsjahr) {
        super(artikelnummer, nettopreis);
        this.bruttoPreis = Math.round(nettopreis + (nettopreis * bruttomwst / 100));
        this.autor = autor;
        this.titel = titel;
        this.erscheinungsjahr = erscheinungsjahr;
        this.artikelnummer = artikelnummer;
    }
    @Override //override the abstract method getInfo() from the abstract class Artikel
    public String getInfo() {
        return artikelnummer + " - " + "Buch - " + autor + ", " + titel + " (" + erscheinungsjahr + ") " + " : " + bruttoPreis;
    }
    @Override //override the abstract method getPreis() from the abstract class Artikel
    public double getPreis() {
        return bruttoPreis;
    }
}
