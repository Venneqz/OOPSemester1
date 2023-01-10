package Praktika.Praktika9.TicTacToe;

public class TicTacToe {
    //the game board
    int [] feld = new int[9];
    //the current player
    int currentPlayer;

    //constructor
    public TicTacToe() {
        reset();
    }

    void reset(){
        feld = new int[9];
        currentPlayer = 1;
    }

    void macheZug(int x, int y){
        //check for invalid move
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            System.out.println("Invalid position");
            return;
        }
        //check for occupied position
        int pos = x + y * 3;
        if (feld[pos] != 0) {
            System.out.println("Die Position ist schon besetzt, bitte wählen Sie eine andere");
            System.out.println();
            zeigeSpielfeld();
            return;
        }
        //make the move
        feld[pos] = currentPlayer;
        //change the player
        currentPlayer = currentPlayer == 1 ? 2 : 1;
    }

    void zeigeSpielfeld() {
        System.out.println("Spielfeld:");
        System.out.println("Spieler " + currentPlayer + " ist am Zug");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int pos = i * 3 + j;
                char c = (feld[pos] == 0) ? ' ' : (feld[pos] == 1) ? 'X' : 'O';
                //dont print a line after the last column
                if (j < 2) {
                    System.out.print(c + " | ");
                } else {
                    System.out.println(c);
                }
            }
            //dont print a line after the last row
            if (i < 2) {
                System.out.println("- + - + -");
            }
        }
        System.out.println();
    }

    void isGameOver() {
        //check for horizontal win
        for (int i = 0; i < 3; i++) {
            int pos = i * 3;
            if (feld[pos] != 0 && feld[pos] == feld[pos + 1] && feld[pos] == feld[pos + 2]) {
                System.out.println("Spieler " + feld[pos] + " hat gewonnen!");
                System.out.println();
                return;
            }
        }
        //check for vertical win
        for (int i = 0; i < 3; i++) {
            if (feld[i] != 0 && feld[i] == feld[i + 3] && feld[i] == feld[i + 6]) {
                System.out.println("Spieler " + feld[i] + " hat gewonnen!");
                System.out.println();
                return;
            }
        }
        //check for diagonal win
        if (feld[0] != 0 && feld[0] == feld[4] && feld[0] == feld[8]) {
            System.out.println("Spieler " + feld[0] + " hat gewonnen!");
            System.out.println();
            return;
        }
        if (feld[2] != 0 && feld[2] == feld[4] && feld[2] == feld[6]) {
            System.out.println("Spieler " + feld[2] + " hat gewonnen!");
            System.out.println();
            return;
        }
        //check for draw
        for (int i = 0; i < 9; i++) {
            if (feld[i] == 0) {
                System.out.println("Das Spiel ist noch nicht vorbei");
                System.out.println();
                return;
            }
        }
    }
}
