import javax.sql.RowSetEvent;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;

public class Gui
{
    private JFrame window;
    private JPanel mainPanel;
    private JPanel colourMenu;
    private JPanel guessPanel;
    private JPanel scorePanel;


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

    private JButton[] row1 = new JButton[4];

    int btnSize = 65;

    public Gui()
    {
        window = new JFrame("Code Breaker!");

        mainPanel = new JPanel();
        colourMenu = new JPanel();
        guessPanel = new JPanel();
        scorePanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        guessPanel.setLayout(new FlowLayout());

        window.setContentPane(mainPanel);

        mainPanel.setBackground(Color.GRAY);
        colourMenu.setBackground(Color.GRAY);
        guessPanel.setBackground(Color.GRAY);
        scorePanel.setBackground(Color.GRAY);

        window.setSize(500, 700);


        colourMenu.add(r);
        colourMenu.add(o);
        colourMenu.add(y);
        colourMenu.add(g);
        colourMenu.add(b);
        colourMenu.add(i);
        colourMenu.add(v);

        r.setPreferredSize(new Dimension(btnSize, btnSize));
        o.setPreferredSize(new Dimension(btnSize, btnSize));
        y.setPreferredSize(new Dimension(btnSize, btnSize));
        g.setPreferredSize(new Dimension(btnSize, btnSize));
        b.setPreferredSize(new Dimension(btnSize, btnSize));
        i.setPreferredSize(new Dimension(btnSize, btnSize));
        v.setPreferredSize(new Dimension(btnSize, btnSize));

        //for(int j = 0; j < 4; j++)
        //{
          //  row1[j] = new JButton(emptyImage);
            //guessPanel.add(row1[j]);
        //    row1[j].setPreferredSize(new Dimension(btnSize, btnSize));
        //}

        
        

        mainPanel.add("South", colourMenu);
        mainPanel.add("West", guessPanel);
        mainPanel.add("Center", Row panel1 = new row());


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);

    }
}