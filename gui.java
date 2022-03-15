import javax.sql.RowSetEvent;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.*;

public class Gui implements ActionListener
{
    private JFrame window;
    private JPanel mainPanel;
    private JPanel colourMenu;
    private JPanel block;
    private JPanel scorePanel;
    private JPanel wholePanel;


    private Row row = new Row();
    private Row row1 = new Row();
    private Row row2 = new Row();
    private Row row3 = new Row();
    private Row row4 = new Row();
    private Row row5 = new Row();

    private Row[] rowArray = new Row[6];


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



    private JButton r = new JButton(red);
    private JButton o = new JButton(orange);
    private JButton y = new JButton(yellow);
    private JButton g = new JButton(green);
    private JButton b = new JButton(blue);
    private JButton i = new JButton(indigo);
    private JButton v = new JButton(violet);

    int btnSize = 65;

    int lineCounter = 0;
    int guessCounter = 0;

    public Gui()
    {
        window = new JFrame("Code Breaker!");

        mainPanel = new JPanel();
        colourMenu = new JPanel();
        block = new JPanel();
        scorePanel = new JPanel();
        wholePanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        block.setLayout(new BoxLayout(block, BoxLayout.Y_AXIS));

        window.setContentPane(wholePanel);

        mainPanel.setBackground(Color.GRAY);
        colourMenu.setBackground(Color.GRAY);
        block.setBackground(Color.GRAY);
        scorePanel.setBackground(Color.GRAY);
        wholePanel.setBackground(Color.GRAY);


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

        r.addActionListener(this);
        o.addActionListener(this);
        y.addActionListener(this);
        g.addActionListener(this);
        b.addActionListener(this);
        i.addActionListener(this);
        v.addActionListener(this);
        

        mainPanel.add("South", colourMenu);

        block.add(row.getLink());
        block.add(row1.getLink());
        block.add(row2.getLink());
        block.add(row3.getLink());
        block.add(row4.getLink());
        block.add(row5.getLink());


        rowArray[0] = row5;
        rowArray[1] = row4;
        rowArray[2] = row3;
        rowArray[3] = row2;
        rowArray[4] = row1;
        rowArray[5] = row;


        block.add(mainPanel);

        wholePanel.add(block);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);

        window.setLocation(450, 30);

        window.pack();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(guessCounter > 3)
        {
            guessCounter = 0;
            lineCounter++;
        }

        if(lineCounter > 5)
        {
            End endGame = new End();
            window.dispose();
        }

        if(e.getSource() == r)
        {
            rowArray[lineCounter].rowButton[guessCounter].setIcon(red);
            guessCounter++;
        }

        if(e.getSource() == o)
        {
            rowArray[lineCounter].rowButton[guessCounter].setIcon(orange);
            guessCounter++;
        }

        if(e.getSource() == y)
        {
            rowArray[lineCounter].rowButton[guessCounter].setIcon(yellow);
            guessCounter++;
        }

        if(e.getSource() == g)
        {
            rowArray[lineCounter].rowButton[guessCounter].setIcon(green);
            guessCounter++;
        }

        if(e.getSource() == b)
        {
            rowArray[lineCounter].rowButton[guessCounter].setIcon(blue);
            guessCounter++;
        }

        if(e.getSource() == i)
        {
            rowArray[lineCounter].rowButton[guessCounter].setIcon(indigo);
            guessCounter++;
        }

        if(e.getSource() == v)
        {
            rowArray[lineCounter].rowButton[guessCounter].setIcon(violet);
            guessCounter++;
        }
    }
}