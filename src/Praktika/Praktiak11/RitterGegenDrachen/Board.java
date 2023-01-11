package Praktika.Praktiak11.RitterGegenDrachen;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    //black background
    @Override
    public Color getBackground() {
        return Color.BLACK;
    }



    //for knight
    private static int knightX;
    private static int knightY;

    //for dragon
    private static int dragonX;
    private static int dragonY;
    //for checking if the players must be updated
    private static boolean updatePlayers = false;

    //for drawing the tiles
    private static int x = 0;
    private int y = 0;

    Board() {
    }


    //-----------------------------------methodes-----------------------------------------------

    //for drawing the tiles
    public void drawTiles(Graphics g) {
        //creating the tiles
        Tile.makeTiles();
        //drawing the tiles by looping through the tiles and giving them a color based on their type
        for (int i = 0; i < 49; i++) {
            int tileType = Tile.getTILES(i);
            if (tileType == 0) {
                //green tile
                g.setColor(Tile.getCOLORS(0));
            }
            if (tileType == 1) {
                //blue tile
                g.setColor(Tile.getCOLORS(1));
            }
            if (tileType == 2) {
                //red tile
                g.setColor(Tile.getCOLORS(2));
            }
            if (tileType == 3) {
                //black tile
                g.setColor(Tile.getCOLORS(3));
            }
            //drawing the tile
            g.fillRect(x, y, 70, 70);
            //for making a outline
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 70, 70);
            //updazing the x and y coordinates for the next tile
            x += 70;
            if (x == 490) {
                x = 0;
                y += 70;
            }
        }
        //reset the x and y coordinates, for drawing again
        x = 0;
        y = 0;
    }

    public void redrawOldTiles(Graphics g){
        //redrawing the old tiles
        for (int i = 0; i < 49; i++) {
            //getting alredy drawn tiles
            int tileType = Tile.getTILES(i);
            //same as in drawTiles
            if (tileType == 0) {
                g.setColor(Tile.getCOLORS(0));
            }
            if (tileType == 1) {
                g.setColor(Tile.getCOLORS(1));
            }
            if (tileType == 2) {
                g.setColor(Tile.getCOLORS(2));
            }
            if (tileType == 3) {
                g.setColor(Tile.getCOLORS(3));
            }
            g.fillRect(x, y, 70, 70);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 70, 70);
            x += 70;
            if (x == 490) {
                x = 0;
                y += 70;
            }
        }
        //reset the x and y coordinates
        x = 0;
        y = 0;
    }

    //hover function... little extra ;)
    public static void tileHover(Graphics g) {
        //change the outline of the tile the mouse is hovering over to white
        int mouseX = GUI.getMouseX();
        int mouseY = GUI.getMouseY();
        if (mouseX < 490 && mouseY < 490) {
            if (mouseX > 0 && mouseY > 0) {
                //get the tile the mouse is hovering over, based on the window postion on screen
                int tile = Tile.getTile(mouseX - 8, mouseY - 30);
                int[] coordinates = Tile.getCoordinates(tile);
                g.setColor(Color.WHITE);
                g.drawRect(coordinates[0], coordinates[1], 70, 70);
            }
        }
    }



    //drawing the knight
    public void drawKnight(Graphics g, int x, int y) {
        //draw a K on the board
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 36));
        g.drawString("R", x, y);
    }


    //drawing the dragon
    public void drawDragon(Graphics g, int x, int y) {
        //draw a D on the board
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 36));
        g.drawString("D", x, y);
    }



    //drawing the board
    public void paintComponent(Graphics g) {
        if (updatePlayers){
            //redrawing the old tiles and new players
            redrawOldTiles(g);
            drawKnight(g, knightX, knightY);
            drawDragon(g, dragonX, dragonY);
        }
        else {
            //basically only for forst time drawing
            drawTiles(g);
            drawKnight(g, knightX, knightY);
            drawDragon(g, dragonX, dragonY);
        }
        //drawing the tile the mouse is hovering over
        tileHover(g);
    }


    //-----------------------------------getter and setter-----------------------------------------------

    public static int getKnightX() {
        return knightX;
    }

    public static void setKnightX(int knightX) {
        Board.knightX = knightX;
    }

    public static int getKnightY() {
        return knightY;
    }

    public static void setKnightY(int knightY) {
        Board.knightY = knightY;
    }


    public int getX() {
        return x;
    }

    public static void setX(int setX) {
        x = setX;
    }


    public int getY() {
        return y;
    }

    public void setY(int setY) {
        y = setY;
    }


    public static int getDragonY() {
        return dragonY;
    }

    public static void setDragonX(int dragonX) {
        Board.dragonX = dragonX;
    }

    public static int getDragonX() {
        return dragonX;
    }

    public static void setDragonY(int dragonY) {
        Board.dragonY = dragonY;
    }

    public static void setUpdatePlayers(boolean updatePlayers) {
        Board.updatePlayers = updatePlayers;
    }

    public static boolean getUpdatePlayers() {
        return updatePlayers;
    }

}
