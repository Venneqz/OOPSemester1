package Praktika.Praktika9.TicTacToe;

public class TicTacToeTest {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.zeigeSpielfeld();
        t.macheZug(2, 2);
        t.zeigeSpielfeld();
        t.macheZug(2, 0);
        t.zeigeSpielfeld();

        t.reset();
        t.zeigeSpielfeld();
    }
}
