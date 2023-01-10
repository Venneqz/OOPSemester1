package Praktika.Praktika9.Arithmetik;

public class ArithmetikGenerisch <T extends Rechenweg>{
    private T rechenweg;

    public ArithmetikGenerisch(T rechenweg) {
        System.out.println();
        System.out.println("Operation: " + rechenweg.getClass().getSimpleName() + ", Generisch");
        this.rechenweg = rechenweg;
    }

    public double berechne(double a, double b){
        System.out.println("a: " + a + "," + " b: " + b);
        System.out.println("Ergebnis der Rechnung:");
        return rechenweg.berechneErgebnis(a, b);
    }
}
