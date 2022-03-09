import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;

public class gui
{
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel colourMenu;
    private JPanel centerPanel;

    private BorderLayout mainLayout = new BorderLayout();
    private GridLayout scoreLayout = new GridLayout();
    private FlowLayout flow = new FlowLayout();


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



    private JButton empty;
    private JButton r = new JButton(red);
    private JButton o = new JButton(orange);
    private JButton y = new JButton(yellow);
    private JButton g = new JButton(green);
    private JButton b = new JButton(blue);
    private JButton i = new JButton(indigo);
    private JButton v = new JButton(violet);

    private int buttonSize = 65;


    public gui()
    {
        frame = new JFrame("Code Breaker! - By Fabrizio Liani");

        mainPanel = new JPanel();
        colourMenu = new JPanel();
        centerPanel = new JPanel();

        frame.setContentPane(mainPanel);

        frame.getContentPane().setBackground(Color.GRAY);
        mainPanel.setBackground(Color.GRAY);
        colourMenu.setBackground(Color.GRAY);
        centerPanel.setBackground(Color.GRAY);

        frame.setSize(400, 680);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        for(int j = 0; j < 4; j++)
        {
            centerPanel.add(empty = new JButton(emptyImage));
            empty.setPreferredSize(new Dimension(buttonSize, buttonSize));
        }


        r.setPreferredSize(new Dimension(buttonSize, buttonSize));
        o.setPreferredSize(new Dimension(buttonSize, buttonSize));
        y.setPreferredSize(new Dimension(buttonSize, buttonSize));
        g.setPreferredSize(new Dimension(buttonSize, buttonSize));
        b.setPreferredSize(new Dimension(buttonSize, buttonSize));
        i.setPreferredSize(new Dimension(buttonSize, buttonSize));
        v.setPreferredSize(new Dimension(buttonSize, buttonSize));

        colourMenu.add(r);
        colourMenu.add(o);
        colourMenu.add(y);
        colourMenu.add(g);
        colourMenu.add(b);
        colourMenu.add(i);
        colourMenu.add(v);


        mainPanel.setLayout(mainLayout);

        mainPanel.add("South", colourMenu);
        mainPanel.add("Center", centerPanel);
        //mainPanel.add("East", row2);
        //mainPanel.add("East", row3);
        //mainPanel.add("East", row4);
        //mainPanel.add("East", row5);
        //mainPanel.add("East", row6);


        frame.setVisible(true);
    }
}