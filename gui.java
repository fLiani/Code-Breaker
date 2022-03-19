import javax.sql.RowSetEvent;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Gui implements ActionListener
{                                                                                                      // Declaring the basis of the GUI window:
    private JFrame window;                                                          
    private JPanel mainPanel;
    private JPanel colourMenu;
    private JPanel block;
    private JPanel scorePanel;
    private JPanel wholePanel;


    private Row row = new Row();                                                                       // Creating 6 instances of the class row -- puts in 6 rows on the panel
    private Row row1 = new Row();
    private Row row2 = new Row();
    private Row row3 = new Row();
    private Row row4 = new Row();
    private Row row5 = new Row();

    Row[] rowArray = new Row[6];                                                                       // Creating an array for the 6 rows


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

    private Picture[] colourArr = new Picture[7];


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
    int counter = 0;
    int checkCounter = 0;
    int rightCol = 0;
    int buffer = 0;

    Integer guessArray[] = new Integer[4];
    Integer combination[] = new Integer[4];

    int arrayLength = guessArray.length;

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


        colourArr[0] = red;
        colourArr[1] = orange;
        colourArr[2] = yellow;
        colourArr[3] = green;
        colourArr[4] = blue;
        colourArr[5] = indigo;
        colourArr[6] = violet;


        block.add(mainPanel);

        wholePanel.add(block);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);

        window.setLocation(450, 30);

        window.pack();

        codeGen();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == r)
        {
            guessArray[guessCounter] = 0;
            rowArray[lineCounter].rowButton[guessCounter].setIcon(colourArr[0]);
            guessCounter++;
            counter++;
            System.out.println("Element 0 " + guessArray[0]);
            System.out.println("Element 1 " + guessArray[1]);
            System.out.println("Element 2 " + guessArray[2]);
            System.out.println("Element 3 " + guessArray[3]);
        }

        if(e.getSource() == o)
        {
            guessArray[guessCounter] = 1;
            rowArray[lineCounter].rowButton[guessCounter].setIcon(colourArr[1]);
            guessCounter++;
            counter++;
            System.out.println("Element 0 " + guessArray[0]);
            System.out.println("Element 1 " + guessArray[1]);
            System.out.println("Element 2 " + guessArray[2]);
            System.out.println("Element 3 " + guessArray[3]);
        }

        if(e.getSource() == y)
        {
            guessArray[guessCounter] = 2;
            rowArray[lineCounter].rowButton[guessCounter].setIcon(colourArr[2]);
            guessCounter++;
            counter++;
            System.out.println("Element 0 " + guessArray[0]);
            System.out.println("Element 1 " + guessArray[1]);
            System.out.println("Element 2 " + guessArray[2]);
            System.out.println("Element 3 " + guessArray[3]);
        }

        if(e.getSource() == g)
        {
            guessArray[guessCounter] = 3;
            rowArray[lineCounter].rowButton[guessCounter].setIcon(colourArr[3]);
            guessCounter++;
            counter++;
            System.out.println("Element 0 " + guessArray[0]);
            System.out.println("Element 1 " + guessArray[1]);
            System.out.println("Element 2 " + guessArray[2]);
            System.out.println("Element 3 " + guessArray[3]);
        }

        if(e.getSource() == b)
        {
            guessArray[guessCounter] = 4;
            rowArray[lineCounter].rowButton[guessCounter].setIcon(colourArr[4]);
            guessCounter++;
            counter++;
            System.out.println("Element 0 " + guessArray[0]);
            System.out.println("Element 1 " + guessArray[1]);
            System.out.println("Element 2 " + guessArray[2]);
            System.out.println("Element 3 " + guessArray[3]);
        }

        if(e.getSource() == i)
        {
            guessArray[guessCounter] = 5;
            rowArray[lineCounter].rowButton[guessCounter].setIcon(colourArr[5]);
            guessCounter++;
            counter++;
            System.out.println("Element 0 " + guessArray[0]);
            System.out.println("Element 1 " + guessArray[1]);
            System.out.println("Element 2 " + guessArray[2]);
            System.out.println("Element 3 " + guessArray[3]);
        }

        if(e.getSource() == v)
        {
            guessArray[guessCounter] = 6;
            rowArray[lineCounter].rowButton[guessCounter].setIcon(colourArr[6]);
            guessCounter++;
            counter++;
            System.out.println("Element 0 " + guessArray[0]);
            System.out.println("Element 1 " + guessArray[1]);
            System.out.println("Element 2 " + guessArray[2]);
            System.out.println("Element 3 " + guessArray[3]);
        }

        if(counter > 3)
        {
            winChecker();
        }

        if(guessCounter == 4)
        {
            guessCounter = 0;
            counter = 0;
            lineCounter++;
        }

        if(lineCounter > 5)
        {
            End endGame = new End();
            window.dispose();
            endGame.lose();
        }
    }

    public void winChecker()
    {
        if(Arrays.equals(guessArray, combination))
        {
            for(int j = 0; j < 4; j++)
            {
                rowArray[lineCounter].gridButton[j].setIcon(blackTickImage);
            }

            End w = new End();

            w.win();
        }
        else if(Arrays.equals(guessArray, combination) == false)
        {
            posChecker();
        }
    }

    public void colourChecker()
    {
        for(int dc = 0; dc < arrayLength; dc++)
        {
            for(int i = dc + 1; i < arrayLength; i++)
            {
                if(combination[dc].equals(combination[i]))
                {
                    buffer++;
                }
            }
        }

        Set<Integer> tempGuess = new HashSet<>(Arrays.asList(guessArray));
        
        for(int c = 0; c < arrayLength; c++)
        {
            if(tempGuess.contains(combination[c]))
            {
                rightCol++;
                counter++;
            }
        }

        for(int p = 0; p < ((rightCol - buffer) + counter); p++)
        {
            rowArray[lineCounter].gridButton[checkCounter].setIcon(whiteTickImage);

            System.out.println(tempGuess);
        }

            if(guessCounter == 4)
            {
                checkCounter = 0;
            }
    }


    public void posChecker()
    {
        if(guessArray[0] == combination[0])
        {
            rowArray[lineCounter].gridButton[checkCounter].setIcon(blackTickImage);
            checkCounter++;
            buffer++;
            counter++;
            guessArray[0] = 7;
            
        }

        if(guessArray[1] == combination[1])
        {
            rowArray[lineCounter].gridButton[checkCounter].setIcon(blackTickImage);
            checkCounter++;
            buffer++;
            counter++;
            guessArray[1] = 7;
        }

        if(guessArray[2] == combination[2])
        {
            rowArray[lineCounter].gridButton[checkCounter].setIcon(blackTickImage);
            checkCounter++;
            buffer++;
            counter++;
            guessArray[2] = 7;
        }

        if(guessArray[3] == combination[3])
        {
            rowArray[lineCounter].gridButton[checkCounter].setIcon(blackTickImage);
            checkCounter++;
            buffer++;
            counter++;
            guessArray[3] = 7;
        }

        colourChecker();

        if(guessCounter == 4)
        {
            checkCounter = 0;
        }
    }

    public void codeGen()
    {
        Random r = new Random();

        for(int i = 0; i < 4; i++)
        {
            combination[i] = r.nextInt(7);
        }

        System.out.println("Comb Elem 0: " + combination[0]);
        System.out.println("Comb Elem 1: " + combination[1]);
        System.out.println("Comb Elem 2: " + combination[2]);
        System.out.println("Comb Elem 3: " + combination[3] + "\n");
    }

    public JFrame getWindow()
    {
        return window;
    }

}