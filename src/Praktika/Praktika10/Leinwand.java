package Praktika.Praktika10;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Leinwand extends JPanel {
    //black background
    @Override
    public Color getBackground() {
        return Color.BLACK;
    }

    // colors for the trees
    private static final Color[] COLORS = {
            Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW, Color.ORANGE, Color.PINK
    };

    // random number generator for selecting colors and positions
    private Random rnd = new Random();

    //santa image
    private BufferedImage image;


    // paint the tree
    public void drawTree(Graphics g, int x, int y, Color color, double size) {
        // draw the three triangles that make up the tree
        g.setColor(color);
        int[] xPoints = {(int) ((15 + x) * size), (int) ((60 + x) * size), (int) ((105 + x) * size)};
        int[] yPoints = {(int) ((325 + y) * size), (int) ((250 + y) * size), (int) ((325 + y) * size)};
        int[] xPoints1 = {(int) ((10 + x) * size), (int) ((60 + x) * size), (int) ((110 + x) * size)};
        int[] yPoints1 = {(int) ((360 + y) * size), (int) ((300 + y) * size), (int) ((360 + y) * size)};
        int[] xPoints2 = {(int) ((0 + x) * size), (int) ((60 + x) * size), (int) ((120 + x) * size)};
        int[] yPoints2 = {(int) ((400 + y) * size), (int) ((325 + y) * size), (int) ((400 + y) * size)};
        //check if the tree is not fully visible
        if (xPoints2[0] < 0 || xPoints[2] > 900 || yPoints2[0] > 650) {
            //draw the tree again
            drawTree(g, rnd.nextInt(800), rnd.nextInt(400), COLORS[rnd.nextInt(COLORS.length)], 1 + Math.random() * 0.5);
        }
        else {
            //draw the tree
            g.fillPolygon(xPoints, yPoints, 3);
            g.fillPolygon(xPoints1, yPoints1, 3);
            g.fillPolygon(xPoints2, yPoints2, 3);
        }
    }


    //draw the forest
    public void drawForest(Graphics g) {
        // draw a random number of trees with random colors, sizes, and positions
        int numTrees = 10 + rnd.nextInt(20);
        for (int i = 0; i < numTrees; i++) {
            int x = rnd.nextInt(800);
            int y = rnd.nextInt(400);
            int colorIndex = (int) (Math.random() * COLORS.length);
            //make a random size between 1 and 1.5
            double size = 1 + Math.random() * 0.5;
            g.setColor(COLORS[colorIndex]);
            drawTree(g, x, y, COLORS[colorIndex], size);
        }
    }

    //draw the santa image
    public void drawSanta(Graphics g, int x, int y) {
        // draw the Santa image
        try {
            image = ImageIO.read(new File("src/Praktika/Praktika10/santa.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image, x, y, null);
    }

    // paint the canvas
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the night sky with stars
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        for (int i = 0; i < 100; i++) {
            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * 250);
            g.fillOval(x, y, 2, 2);
        }

        // check the selection in the GUI and draw the appropriate trees
        if (WeihnachtsGUI.treeButton.isSelected()) {
            // draw a single tree in the center of the canvas
            drawTree(g, 350, 0, Color.GREEN, 1);
        } else if (WeihnachtsGUI.forestButton.isSelected()) {
            // draw a forest on the canvas
            drawForest(g);
        }
        if (WeihnachtsGUI.santaCheckBox.isSelected()) {
            // draw Santa Claus on the canvas
            drawSanta(g, WeihnachtsGUI.santaX, WeihnachtsGUI.santaY);
            WeihnachtsGUI.timer.start();
        }
        else {
            WeihnachtsGUI.timer.stop();
            //reset the santa position
            WeihnachtsGUI.santaX = 0;
            WeihnachtsGUI.santaY = 0;
        }
    }
}
