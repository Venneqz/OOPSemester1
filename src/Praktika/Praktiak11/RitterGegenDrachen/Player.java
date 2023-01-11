package Praktika.Praktiak11.RitterGegenDrachen;

import java.awt.*;

public abstract class Player {
    //attributes
    private int speed;
    private int intelligence;
    private int strength;
    private int x;
    private int y;


    //constructor
    public Player() {
        //speed random number between 6 and 8
        this.speed = (int) (Math.random() * 3) + 6;
        //intelligence random number between 6 and 8
        this.intelligence = (int) (Math.random() * 3) + 6;


        //set the strength and the x and y coordinates of the player
        //check if player is a dragon
        if (this instanceof Dragon) {
            strength = 2 * speed + intelligence;
            int variability = (int) (Math.random() * 41) - 20;
            strength += (strength * variability) / 100;
            //bottom left corner
            x = 300;
            y = 300;
        }
        //check if player is a knight
        if (this instanceof Knight) {
            strength = speed + 2 * intelligence;
            int variability = (int) (Math.random() * 41) - 20;
            strength += (strength * variability) / 100;
            //top right corner
            x = 0;
            y = 0;
        }
    }

    //update the x and y coordinates of the player
    public void setPosition(int xPosition, int yPostion) {
        //set the x and y coordinates of the player
        x = xPosition;
        y = yPostion;
        //check if player is a dragon
        if (this instanceof Dragon) {
            //bottom left corner
            Board.setDragonY(y);
            Board.setDragonX(x);
        }
        //check if player is a knight
        if (this instanceof Knight) {
            //top right corner
            Board.setKnightY(y);
            Board.setKnightX(x);
        }
    }


    //make the player move
    public void move(int x, int y) {
        //get the new tile the player is on
        int newTile = Tile.getTile(x, y);
        //make the player move to the center of the tile
        if (newTile == 0) {
            setPosition(35, 35);
        } else if (newTile == 48) {
            setPosition(465, 465);
        } else {
            // get the x and y coordinates of the tile
            int[] coordinates = Tile.getCoordinates(newTile);
            //set the x and y coordinates of the player
            setPosition(coordinates[0] + 25, coordinates[1] + 50);
        }
    }




    //-------------------------getter and setter-------------------------
    public int getX(){
        //get the x coordinates of the player
        return x;
    }

    public int getY(){
        //get the y coordinates of the player
        return y;
    }

    public String getName() {
        //check if player is a dragon
        if (this instanceof Dragon) {
            return "Dragon";
        }
        //check if player is a knight
        if (this instanceof Knight) {
            return "Knight";
        }
        return null;
    }

    public int getStrength() {
        //get the strength of the player
        return strength;
    }

    public Player getOpponent() {
        //check if player is a dragon
        if (this instanceof Dragon) {
            return GUI.knight;
        }
        //check if player is a knight
        if (this instanceof Knight) {
            return GUI.dragon;
        }
        return null;
    }

    public void setStrength(double v) {
        //set the strength of the player
        strength = (int) v;
    }
}
