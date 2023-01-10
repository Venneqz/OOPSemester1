
public class Kleidung extends Artikel {
    private final int bruttomwst = 19;
    private double bruttoPreis;
    private String typ;
    private String groesse;
    private String farbe;
    private int artikelnummer;

    //constructor
    public Kleidung(int artikelnummer, double nettopreis, String groesse, String farbe , String typ) {
        super(artikelnummer, nettopreis);
        this.bruttoPreis = nettopreis + (nettopreis * bruttomwst / 100);
        this.groesse = groesse;
        this.farbe = farbe;
        this.typ = typ;
        this.artikelnummer = artikelnummer;
    }

    @Override //override the abstract method getInfo() from the abstract class Artikel
    public String getInfo() {
        return "Kleidung - " + typ + ", " + farbe + " (" + groesse + ")" + " : " + bruttoPreis;
    }
    @Override
    public double getPreis() {
        return bruttoPreis;
    }
}
