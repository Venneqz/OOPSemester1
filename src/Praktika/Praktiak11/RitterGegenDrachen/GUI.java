package Praktika.Praktiak11.RitterGegenDrachen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements MouseListener, KeyListener {
    //create the window
    static JFrame window;
    private static final int WIDTH = 700;
    private static final int HEIGHT = 550;


    //create the panels
    JPanel rightSide = new JPanel(new BorderLayout());
    JPanel top = new JPanel(new GridLayout(2,5));
    JPanel bottom = new JPanel(new GridLayout(2,1));
    JPanel middle = new JPanel(new BorderLayout());


    //right side of the GUI: display the infos
    JPanel knightStatus = new JPanel(new FlowLayout());
    JPanel dragonStatus = new JPanel(new FlowLayout());
    JPanel info = new JPanel(new FlowLayout());
    JPanel action = new JPanel(new GridLayout(2,1));
    //Labels for the right side
    JLabel knightLabel = new JLabel("Spielstärke des Ritters: ");
    JLabel dragonLabel = new JLabel("Spielstärke des Drachen: ");
    JLabel infoLabel = new JLabel("-");
    JLabel diceOutcome = new JLabel("Ergebnis des Würfels: ");

    //dice button
    JButton diceButton = new JButton("Würfeln");

    //for drawing the board
    Board board = new Board();

    //initializing the players
    static Player knight = new Knight();
    static Player dragon = new Dragon();
    static Player currentPlayer = knight;

    //for running the game
    private int diceOutcomeInt;
    private int playerX;
    private int playerY;
    private int playerTile;
    private int clickedTile;
    private boolean validMove = false;
    private static int mouseX;
    private static int mouseY;
    public static Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //get mouse position relative to the window position on screen
            PointerInfo a = MouseInfo.getPointerInfo();
            Point point = new Point(a.getLocation());
            SwingUtilities.convertPointFromScreen(point, window);
            mouseX = (int) point.getX();
            mouseY = (int) point.getY();
            //request focus
            window.requestFocus();
            //update the players
            Board.setUpdatePlayers(true);
            //repaint the board
            window.repaint();
        }
    });



    //--------------------------make the GUI---------------------------------------------------------------------
    public GUI() {
        //set window title
        window = new JFrame("Dragon vs Knight");

        //not resizable
        window.setResizable(false);

        //set window size
        window.setSize(WIDTH, HEIGHT);

        //set visible
        window.setVisible(true);

        //set Layout
        window.setLayout(new BorderLayout());


        //right side of the GUI: display the infos
        rightSide();

        //add the canvas
        addCanvas();

        //update the info Label to display the current player
        infoLabel.setText("Der " + currentPlayer.getName() + " ist am Zug");

        //update the knight and dragon status
        knightLabel.setText("Spielstärke des Ritters: " + knight.getStrength());
        dragonLabel.setText("Spielstärke des Drachen: " + dragon.getStrength());

        //dice Button and change the Label
        diceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get the dice outcome
                diceOutcomeInt = Dice.roll();
                //update the label
                diceOutcome.setText("Ergebnis des Würfels: " + diceOutcomeInt);
                //make it unable to click again until the next turn
                diceButton.setEnabled(false);
                //add how many moves the player has to the info label
                if (currentPlayer == knight) {
                    infoLabel.setText("Der Ritter ist am Zug.");
                } else {
                    infoLabel.setText("Der Drache ist am Zug.");
                }
            }
        });

        //add the mouse listener
        board.addMouseListener(this);

        //set starting position of the players
        knight.setPosition(25, 50);
        dragon.setPosition(445, 470);

        //start the timer
        timer.start();
    }

    //add the canvas
    void addCanvas(){
        window.add(board, BorderLayout.CENTER);
    }

    //right side of the GUI: display the infos
    void rightSide(){
        //add the labels
        top.add(knightStatus);
        top.add(dragonStatus);
        middle.add(info);
        bottom.add(action);

        //add the labels to the panels
        knightStatus.add(knightLabel);
        dragonStatus.add(dragonLabel);
        info.add(infoLabel);
        action.add(diceButton);
        action.add(diceOutcome);


        //add the panels to the right side
        rightSide.add(top, BorderLayout.NORTH);
        rightSide.add(middle, BorderLayout.CENTER);
        rightSide.add(bottom, BorderLayout.SOUTH);

        //add the Border
        knightStatus.setBorder(BorderFactory.createTitledBorder("Ritter"));
        dragonStatus.setBorder(BorderFactory.createTitledBorder("Drache"));
        info.setBorder(BorderFactory.createTitledBorder("Info"));
        action.setBorder(BorderFactory.createTitledBorder("Aktion"));

        //add the right side to the window
        window.add(rightSide, BorderLayout.EAST);

    }

    //---------------methodes for running the game--------------------------------------------------------------------



    //method for checking if the move is valid
    public void switchPlayer(){
        if (currentPlayer == knight){
            currentPlayer = dragon;
        } else {
            currentPlayer = knight;
        }
        //update the info label
        infoLabel.setText("Der " + currentPlayer.getName() + " ist am Zug");
    }

    //method for checking if the move is valid and if the player has won, then update the labels
    public boolean checkMove(){
        validMove = false;
        //check if the clicked on tile is a valid move
        if (diceOutcomeInt >= 1){
                //check if the clicked on tile is within 1 tile of the current tile
            if (clickedTile == playerTile + 1 || clickedTile == playerTile - 1 || clickedTile == playerTile + 8 || clickedTile == playerTile - 8 || clickedTile == playerTile + 7 || clickedTile == playerTile - 7 || clickedTile == playerTile + 6 || clickedTile == playerTile - 6) {
                    validMove = true;
                }
                if (diceOutcomeInt >=2){
                    //check if the clicked on tile is within 2 tiles of the current tile
                    if (clickedTile == playerTile + 2 || clickedTile == playerTile - 2 || clickedTile == playerTile + 16 || clickedTile == playerTile - 16 || clickedTile == playerTile + 14 || clickedTile == playerTile - 14 || clickedTile == playerTile + 12 || clickedTile == playerTile - 12 || clickedTile == playerTile + 15 || clickedTile == playerTile - 15 || clickedTile == playerTile + 13 || clickedTile == playerTile - 13 || clickedTile == playerTile + 5 || clickedTile == playerTile - 5 || clickedTile == playerTile + 9 || clickedTile == playerTile - 9) {
                        validMove = true;
                    }
                    if (diceOutcomeInt >= 3){
                        //check if the clicked tile is within 3 tiles of the current tile
                        if (clickedTile == playerTile + 3 || clickedTile == playerTile - 3 || clickedTile == playerTile + 24 || clickedTile == playerTile - 24 || clickedTile == playerTile + 21 || clickedTile == playerTile - 21 || clickedTile == playerTile + 18 || clickedTile == playerTile - 18 || clickedTile == playerTile + 17 || clickedTile == playerTile - 17 || clickedTile == playerTile + 19 || clickedTile == playerTile - 19 || clickedTile == playerTile + 10 || clickedTile == playerTile - 10 || clickedTile == playerTile + 11 || clickedTile == playerTile - 11 || clickedTile == playerTile + 4 || clickedTile == playerTile - 4 || clickedTile == playerTile + 20 || clickedTile == playerTile - 20 || clickedTile == playerTile + 22 || clickedTile == playerTile - 22 || clickedTile == playerTile + 23 || clickedTile == playerTile - 23) {
                            validMove = true;
                        }
                    }
                }
            }
        else {
            //update the info label to say the move is invalid
            infoLabel.setText("Ungültiger Zug!");
            validMove = false;
        }
        //so the player can't move again
        if (diceButton.isEnabled() == true){
            validMove = false;
        }
        return validMove;
    }


    //update the strength of the players based on the tiles they are moving to
    public void updatePlayerStrength(){
        //check if the player is on a tile with a strength modifier
        if (Tile.getTileStrength(clickedTile) != 0){
            //update the strength of the player
            System.out.println("Strength before: " + currentPlayer.getStrength());
            System.out.println("Strength modifier: " + Tile.getTileStrength(clickedTile));
            System.out.println("Strength after: " + (currentPlayer.getStrength() * Tile.getTileStrength(clickedTile)));
            currentPlayer.setStrength(currentPlayer.getStrength() * Tile.getTileStrength(clickedTile));
            //update the strength label
            if (currentPlayer == knight){
                knightLabel.setText("Spielstärke des Ritters: " + knight.getStrength());
            } else {
                dragonLabel.setText("Spielstärke des Drachen: " + dragon.getStrength());
            }
        }
    }

    //print out all information about the game in the console
    public void printGameInfo() {
        System.out.println("Der " + currentPlayer.getName() + " ist am Zug");
        System.out.println("Der " + currentPlayer.getName() + " ist auf dem Feld " + playerTile);
        System.out.println("Das Feld auf dem geklickt wurde ist " + clickedTile);
        System.out.println("Das Feld ist vom Typ " + Tile.getTileType(clickedTile));
        System.out.println("Der " + currentPlayer.getName() + " hat " + currentPlayer.getStrength() + " Spielstärke");
        System.out.println("Der " + currentPlayer.getOpponent().getName() + " hat " + currentPlayer.getOpponent().getStrength() + " Spielstärke");
        System.out.println("Der " + currentPlayer.getName() + " ist auf dem Feld " + playerTile);
        System.out.println("Der " + currentPlayer.getOpponent().getName() + " ist auf dem Feld " + Tile.getTile(currentPlayer.getOpponent().getX(), currentPlayer.getOpponent().getY()));
        System.out.println();
    }


    //method for checking if the player has won
    void hasWon(){
        //check if the players are on the same tile
        if (currentPlayer.getX() == currentPlayer.getOpponent().getX() && currentPlayer.getY() == currentPlayer.getOpponent().getY()){
            //check if the player has more strength than the opponent
            if (currentPlayer.getStrength() > currentPlayer.getOpponent().getStrength()){
                //check if the player is the knight
                if (currentPlayer == knight){
                    infoLabel.setText("Der Ritter hat gewonnen!");
                } else {
                    infoLabel.setText("Der Drache hat gewonnen!");
                }
            } else {
                //check if the player is the knight
                if (currentPlayer == knight){
                    infoLabel.setText("Der Drache hat gewonnen!");
                } else {
                    infoLabel.setText("Der Ritter hat gewonnen!");
                }
            }
            diceButton.setEnabled(false);
        }
    }


    //mouse listener
    @Override
    public void mouseClicked(MouseEvent e) {
        //get current players coordinates
        playerX = currentPlayer.getX();
        playerY = currentPlayer.getY();
        //get the players tile
        playerTile = Tile.getTile(playerX, playerY);
        //get where the mouse clicked
        int x = e.getX();
        int y = e.getY();
        //get the tile where the mouse clicked
        clickedTile = Tile.getTile(x, y);
        //check the players move
        checkMove();
        if (checkMove()){
            //move the player
            currentPlayer.move(x, y);
            //update the players strength
            updatePlayerStrength();
            //repaint all the tiles to update the players position
            Board.setUpdatePlayers(true);
            board.repaint();
            //check if the player has made the amount of moves the dice outcome was
            //reset the dice outcome label
            diceOutcome.setText("Ergebnis des Würfels: ");
            //switch the player
            switchPlayer();
            //enable the dice button
            diceButton.setEnabled(true);
            printGameInfo();
        }
        else {
            //do nothing
        }
        hasWon();
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    //key listener (I tryed to do a replay funciton but it didnt work)
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    //-------------------------------------getter and setter------------------------------------------------
    public static int getMouseX(){
        return mouseX;
    }

    public static int getMouseY(){
        return mouseY;
    }
}
