package Praktika.Praktiak11.RitterGegenDrachen;

public class Dice {

    Dice() {

    }

    //roll the dice
    public static int roll() {
        //random number between 1 and 3
        int rnd = (int) (Math.random() * 3) + 1;
        return rnd;
    }
}
