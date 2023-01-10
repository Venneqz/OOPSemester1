

public abstract class Artikel {
    private int artikelnummer;
    private double nettopreis;

    //for the abstract class Artikel, we need a constructor
    public Artikel(int artikelnummer, double nettopreis) {
        this.artikelnummer = artikelnummer;
        this.nettopreis = nettopreis;
    }

    public abstract String getInfo();
    public abstract double getPreis();
}

