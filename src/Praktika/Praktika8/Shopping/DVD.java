
public class DVD extends Artikel {
    private int bruttomwst = 19;
    private double bruttoPreis;
    private String titel;
    private String dauer;
    private int artikelnummer;

    //constructor
    public DVD(int artikelnummer, double nettopreis, String titel, String dauer) {
        super(artikelnummer, nettopreis);
        this.bruttoPreis = Math.round(nettopreis + (nettopreis * bruttomwst / 100));
        this.titel = titel;
        this.dauer = dauer;
        this.artikelnummer = artikelnummer;
    }

    @Override //override the abstract method getInfo() from the abstract class Artikel
    public String getInfo() {
        return artikelnummer + " - " + "DVD - " + titel + " (" + dauer + ")" + " : " + bruttoPreis;
    }

    @Override //override the abstract method getPreis() from the abstract class Artikel
    public double getPreis() {
        return bruttoPreis;
    }
}

