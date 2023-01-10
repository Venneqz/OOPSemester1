package Praktika.Praktika10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyListener;



public class WeihnachtsGUI extends JFrame implements KeyListener{
    // constants for the window dimensions
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int DELAY = 10;


    // left side of the GUI: canvas for drawing the trees
    public static Leinwand canvas;


    // right side of the GUI: input field and parameter controls
    public static JTextField authorField;
    public static JRadioButton treeButton;
    public static JRadioButton forestButton;
    public static JCheckBox santaCheckBox;
    public static JButton startButton;


    // status bar at the bottom of the window
    public static JLabel info = new JLabel();


    // variables for the Santa image
    private Image santaImage;
    public static int santaY;
    public static boolean santaVisible;
    public static int santaX;
    private static int santaVelocityX;
    private static int santaVelocityY;

    // timer for animating the Santa image
    public static Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // update the position of the Santa image
            santaX += santaVelocityX;
            santaY += santaVelocityY;
            if (santaY + 100 > 250){
                santaY = 250 - 100;
            }
            if (santaY < 0){
                santaY = 0;
            }

            // change direction when reaching the edge of the canvas
            if (santaX < 0 || santaX + 93 > canvas.getWidth()) {
                santaVelocityX *= -1;
            }
            //repaint the stars
            canvas.repaint(0,0,canvas.getWidth(),251);
            // repaint the santa image
            canvas.repaint(santaX, santaY, 100, 93);
            canvas.requestFocus();
        }
    });

    //variables for the options
    public static boolean tree , forest, santa;


    public WeihnachtsGUI() {
        // set the window title
        super("WeihnachtsGUI");

        // create the canvas for drawing the trees
        canvas = new Leinwand();

        //status bar
        String status = "-";
        info.setText(status);


        // create the input field for the author's name
        authorField = new JTextField();
        authorField.setToolTipText("Enter the author's name here");


        // create the parameter controls
        JPanel control = new JPanel();
        control.setLayout(new BorderLayout());
        control.setPreferredSize(new Dimension(350, 100));

        //create the top menu
        JPanel topMenu = new JPanel();
        topMenu.setPreferredSize(new Dimension(100, 600));
        topMenu.setLayout(new FlowLayout(FlowLayout.LEADING));
        control.add(topMenu, BorderLayout.NORTH);

        //create the line
        JPanel line = new JPanel();
        line.setPreferredSize(new Dimension(350, 30));
        line.setLayout(new FlowLayout(FlowLayout.LEADING));
        topMenu.add(line);

        //cerate the AutorLabel
        JLabel AutorLabel = new JLabel("Autor:");
        AutorLabel.setPreferredSize(new Dimension(50, 20));
        line.add(AutorLabel);

        //create the Text field for Autor Label
        JTextField Autor = new JTextField("Autor");
        Autor.setPreferredSize(new Dimension(200, 20));
        line.add(Autor);

        //Create the parameterpanel
        JLabel Parameter = new JLabel("Parameter");
        topMenu.add(Parameter);

        //create the treebutton option
        treeButton = new JRadioButton("Tannenbaum");
        treeButton.setPreferredSize(new Dimension(350, 30));
        topMenu.add(treeButton);
        treeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (treeButton.isSelected()) {
                    tree = true;
                    forest = false;
                }
            }
        });

        //create the forestButton option
        forestButton = new JRadioButton("Wald");
        forestButton.setPreferredSize(new Dimension(350, 30));
        topMenu.add(forestButton);
        forestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (forestButton.isSelected()) {
                    forest = true;
                    tree = false;
                }
            }
        });

        //add both to a ButtonGroup
        ButtonGroup group = new ButtonGroup();
        group.add(treeButton);
        group.add(forestButton);

        //create the santa checkbox
        santaCheckBox = new JCheckBox("Santa");
        santaCheckBox.setPreferredSize(new Dimension(350, 30));
        topMenu.add(santaCheckBox);
        santaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (santaCheckBox.isSelected()) {
                    santa = true;
                } else {
                    santa = false;
                }
            }
        });

        //create the startButton
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(10, 40));
        control.add(startButton, BorderLayout.SOUTH);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.repaint();
                // update the status label
                String status = "-";
                if (treeButton.isSelected()) {
                    status = "Tannenbaum";
                } else if (forestButton.isSelected()) {
                    status = "Wald";
                }
                if (santaCheckBox.isSelected()) {
                    status += " plus Santa";
                }
                info.setText(status);
            }
        });

        //add everything to the panel, and add the panel to the right side of the GUI
        JPanel parameterPanel = new JPanel();
        parameterPanel.setPreferredSize(new Dimension(100, 30));
        parameterPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        info.setAlignmentX(SwingConstants.LEFT);
        parameterPanel.add(info);

        //create the GUI and add everything
        JFrame gui = new JFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setResizable(false);
        gui.setTitle("WeihnachtsGUI");
        gui.setSize(1280, 720);
        gui.setLayout(new BorderLayout());
        gui.add(canvas, BorderLayout.CENTER);
        gui.add(control, BorderLayout.EAST);
        gui.add(parameterPanel, BorderLayout.SOUTH);

        // initialize the Santa image variables
        santaImage = Toolkit.getDefaultToolkit().getImage("santa.png");
        santaX = 0;
        santaY = 0;
        santaVelocityX = 3; // 3 for right, -3 for left
        santaVisible = false;

        // add a KeyListener to the canvas
        canvas.addKeyListener(this);
        canvas.requestFocus();



        canvas.repaint();
    }
    //Key listener
    @Override
    public void keyPressed(KeyEvent e) {
        // update the santaY variable according to the key that was pressed
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                santaY -= 5;
                break;
            case KeyEvent.VK_DOWN:
                santaY += 5;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}