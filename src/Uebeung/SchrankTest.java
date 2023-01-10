package Uebeung;

public class SchrankTest {
    public static void main(String[] args) {
        Schrank schrank = new Schrank("Rexilius", new int[]{1,2,3,}, 100);
        Schrank schrank2 = new Schrank("OOP", new int[]{1,2,3}, 99);
        Schrank schrank3 = new Schrank("Uebung", new int[]{1,2,3}, 101);
        Moebelhaus.anzahlSchränke(new Schrank[]{schrank, schrank2, schrank3});
    }
}
