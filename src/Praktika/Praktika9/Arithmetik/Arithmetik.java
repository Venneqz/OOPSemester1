package Praktika.Praktika9.Arithmetik;

public class Arithmetik{
    private Rechenweg rechnung;

    public void bestimmeRechenweg(Rechenweg rechnung){
        System.out.println();
        System.out.println("Operation: " + rechnung.getClass().getSimpleName());
        this.rechnung = rechnung;
    }

    public double berechne (double a, double b){
        System.out.println("a: " + a + "," + " b: " + b);
        System.out.println("Ergebnis der Rechnung:");
        return rechnung.berechneErgebnis(a, b);
    }
}
