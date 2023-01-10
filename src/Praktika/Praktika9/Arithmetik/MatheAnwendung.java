package Praktika.Praktika9.Arithmetik;

public class MatheAnwendung {
    public static void main(String[] args) {
        Arithmetik plus = new Arithmetik();
        plus.bestimmeRechenweg(new RechenwegPlus());
        System.out.println(plus.berechne(2, 3));

        Arithmetik minus = new Arithmetik();
        minus.bestimmeRechenweg(new RechenwegMinus());
        System.out.println(minus.berechne(2, 3));

        Arithmetik mal = new Arithmetik();
        mal.bestimmeRechenweg(new RechenwegMal());
        System.out.println(mal.berechne(2, 3));

        ArithmetikGenerisch<RechenwegPlus> plusGenerisch = new ArithmetikGenerisch<>(new RechenwegPlus());
        System.out.println(plusGenerisch.berechne(2, 3));

        ArithmetikGenerisch<RechenwegMinus> minusGenerisch = new ArithmetikGenerisch<>(new RechenwegMinus());
        System.out.println(minusGenerisch.berechne(2, 3));

        ArithmetikGenerisch<RechenwegMal> malGenerisch = new ArithmetikGenerisch<>(new RechenwegMal());
        System.out.println(malGenerisch.berechne(2, 3));
    }
}
