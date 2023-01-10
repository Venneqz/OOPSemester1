package Praktika.Praktiak11.RitterGegenDrachen;

import java.awt.*;

public class Tile{
    //for storing the tiletype

    private static int tileType;

    //for storing the tiles
    private static final int[] TILES = new int[49];

    //colors for the tiles
    private static final Color[] COLORS = {Color.GREEN, Color.BLUE, Color.RED, Color.BLACK};

    //getting the tile based on the coordinates
    public static int getTile(int x, int y) {
        //return the tile number
        int row = y / 70;
        x = x / 70;
        int tile = row * 7 + x;
        return tile;
    }

    public static int[] getCoordinates(int newTile) {
        //get the x and y coordinates of the tile
        int[] coordinates = new int[2];
        int x = newTile % 7;
        int y = newTile / 7;
        coordinates[0] = x * 70;
        coordinates[1] = y * 70;
        return coordinates;
    }

    public static double getTileStrength(int clickedTile) {
        //get the modifier of the tile
        int tileType = getTileType(clickedTile);
        //get the current player
        Player currentPlayer = GUI.currentPlayer;
        //get the current strength of the player
        double strength = 1;
        //check if the player is a dragon
        if (currentPlayer instanceof Dragon) {
            //check if the tile is a green tile
            if (tileType == 0) {
                //decrease the strength of the dragon by 10%
                strength = 0.9;
            }
            //check if the tile is a blue tile
            if (tileType == 1) {
                //dont change the strength of the dragon
                strength = 1;
            }
            //check if the tile is a red tile
            if (tileType == 2) {
                //increase the strength of the dragon by 10%
                strength = 1.1;
            }
        }
        //check if the player is a knight
        if (currentPlayer instanceof Knight) {
            if (tileType == 0) {
                strength = 1.1;
            }
            if (tileType == 1) {
                strength = 1;
            }
            if (tileType == 2) {
                strength = 0.9;
            }
        }
        //return the new strength of the player
        return strength;
    }

    public static void makeTiles() {
        for (int i = 0; i < 49; i++) {
            setTileType(i);
        }
        //print out the tiletype in a 7x7 grid in the console
        for (int i = 0; i < 49; i++) {
            System.out.print(TILES[i] + " ");
            if (i == 6 || i == 13 || i == 20 || i == 27 || i == 34 || i == 41 || i == 48) {
                System.out.println();
            }
        }
    }



    private static void setTileType(int i) {
        tileType = (int) (Math.random() * 3);
        TILES[i] = tileType;
        if (i == 0 || i == 48) {
            TILES[i] = 3;
        }
    }

    static int getTileType(int i) {
        tileType = TILES[i];
        return tileType;
    }

    public static int getTileY(int tile){
        int tyleY = tile / 7;
        return tyleY;
    }

    public static int getTileX(int tile){
        int tyleX = tile % 7;
        return tyleX;
    }

    public static int getTILES(int i){
        return TILES[i];
    }

    public static Color getCOLORS(int i){
        return COLORS[i];
    }
}
