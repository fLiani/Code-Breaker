import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui
{
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel colourMenu;
    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    private JPanel row4;
    private JPanel row5;
    private JPanel row6;

    private BorderLayout mainLayout = new BorderLayout();
    private GridLayout scoreLayout = new GridLayout();


    private Picture red = new Picture("Colour_0.png");
    private Picture orange = new Picture("Colour_1.png");
    private Picture yellow = new Picture("Colour_2.png");
    private Picture green = new Picture("Colour_3.png");
    private Picture blue = new Picture("Colour_4.png");
    private Picture indigo = new Picture("Colour_5.png");
    private Picture violet = new Picture("Colour_6.png");
    private Picture emptyImage = new Picture("Empty.png");
    private Picture whiteTickImage = new Picture("Score_1.png");
    private Picture blackTickImage = new Picture("Score_0.png");



    private JButton empty = new JButton(emptyImage);
    //private JButton whiteTick = new JButton(whiteTickImage);
    //private JButton blackTick = new JButton(blackTickImage);
    private JButton r = new JButton(red);
    private JButton o = new JButton(orange);
    private JButton y = new JButton(yellow);
    private JButton g = new JButton(green);
    private JButton b = new JButton(blue);
    private JButton i = new JButton(indigo);
    private JButton v = new JButton(violet);


    public gui()
    {
        frame = new JFrame("Code Breaker! - By Fabrizio Liani");

        mainPanel = new JPanel();
        colourMenu = new JPanel();

        frame.setContentPane(mainPanel);

        frame.getContentPane().setBackground(Color.GRAY);

        frame.setSize(360,640);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        row1 = new JPanel();
        row2 = new JPanel();
        row3 = new JPanel();
        row4 = new JPanel();
        row5 = new JPanel();
        row6 = new JPanel();

        for(int j = 0; j < 4; j++)
        {
            row1.add(empty);
        }


        colourMenu.add(r);
        colourMenu.add(o);
        colourMenu.add(y);
        colourMenu.add(g);
        colourMenu.add(b);
        colourMenu.add(i);
        colourMenu.add(v);


        mainPanel.setLayout(mainLayout);
        row1.setLayout(scoreLayout);
        row2.setLayout(scoreLayout);
        row3.setLayout(scoreLayout);
        row4.setLayout(scoreLayout);
        row5.setLayout(scoreLayout);
        row6.setLayout(scoreLayout);

        mainPanel.add("South", colourMenu);
        mainPanel.add("East", row1);
        //mainPanel.add("East", row2);
        //mainPanel.add("East", row3);
        //mainPanel.add("East", row4);
        //mainPanel.add("East", row5);
        //mainPanel.add("East", row6);


        frame.setVisible(true);
    }
}