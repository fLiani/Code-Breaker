import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Gui class is the main functioning class of the program.
 * Creates the whole game.
 * Action Listener class.
 */
public class Gui implements ActionListener
{
    // Declaring the basis of the GUI window:
    private JFrame window;                                                          
    private JPanel mainPanel;
    private JPanel colourMenu;
    private JPanel block;
    private JPanel wholePanel;


    // Creating 6 instances of the class row -- (inserts in 6 rows on the panel):
    private Row row = new Row();
    private Row row1 = new Row();
    private Row row2 = new Row();
    private Row row3 = new Row();
    private Row row4 = new Row();
    private Row row5 = new Row();

    // Creating an array for the 6 rows:
    private Row[] rowArray = new Row[6];


    // Declaring all the images that will be used in the class:
    private Picture red = new Picture("Colour_0.png");
    private Picture orange = new Picture("Colour_1.png");
    private Picture yellow = new Picture("Colour_2.png");
    private Picture green = new Picture("Colour_3.png");
    private Picture blue = new Picture("Colour_4.png");
    private Picture indigo = new Picture("Colour_5.png");
    private Picture violet = new Picture("Colour_6.png");
    private Picture whiteTickImage = new Picture("Score_1.png");
    private Picture blackTickImage = new Picture("Score_0.png");

    // Creating an array for the colours:
    private Picture[] colourArr = new Picture[7];


    // Creating buttons and assigning a colour to every button:
    private JButton r = new JButton(red);
    private JButton o = new JButton(orange);
    private JButton y = new JButton(yellow);
    private JButton g = new JButton(green);
    private JButton b = new JButton(blue);
    private JButton i = new JButton(indigo);
    private JButton v = new JButton(violet);


    // Creating Integer arrays to hold the values of the user inputted guess and the randomly generated combination:
    private Integer guessArray[] = new Integer[4];
    private Integer combination[] = new Integer[4];

    // Creating a list to hold the amount of white ticks needed to print:
    private List<Integer> whiteList = new ArrayList<>();


    // Initialising counters and sizes:
    private int btnSize = 65;
    private int arrayLength = guessArray.length;
    private int lineCounter = 0;
    private int guessCounter = 0;
    private int counter = 0;
    private int whiteCounter = 0;
    private int checkCounter = 0;
    private int blackCounter = 0;
    private int buffer = 0;

    /**
     * GUI Constructor - creates a blank template of the game and generates a random code to break.
     * @param mainPanel
     * @param window The main frame of the program.
     * @param colourMenu The menu with all the colours to chose from to break the code at the bottom of the screen.
     * @param block The panel where all the rows or "guesses" and colour menu is added to. The "block" of rows and menu.
     * @param wholePanel The main panel of the program -- all the panels join onto here. Content pane of the frame window.
     * @param r Red.
     * @param o Orange.
     * @param y Yellow.
     * @param g Green.
     * @param b Blue.
     * @param i Indigo.
     * @param v Violet.
     */
    public Gui()
    {
        // Creating instances of all the JPanels and JFrame needed:
        window = new JFrame("Code Breaker!");
        mainPanel = new JPanel();
        colourMenu = new JPanel();
        block = new JPanel();
        wholePanel = new JPanel();


        // Setting GUI Layout for mainPanel and block:
        mainPanel.setLayout(new BorderLayout());
        block.setLayout(new BoxLayout(block, BoxLayout.Y_AXIS)); // Box layout Y_AXIS -- vertical list of guesses.


        // Setting main panel to display on window frame:
        window.setContentPane(wholePanel);


        mainPanel.setBackground(Color.GRAY);
        colourMenu.setBackground(Color.GRAY);
        block.setBackground(Color.GRAY);
        wholePanel.setBackground(Color.GRAY);


        // Adding the colour buttons to the colour menu:
        colourMenu.add(r);
        colourMenu.add(o);
        colourMenu.add(y);
        colourMenu.add(g);
        colourMenu.add(b);
        colourMenu.add(i);
        colourMenu.add(v);


        // Setting size of colour menu buttons.
        r.setPreferredSize(new Dimension(btnSize, btnSize));
        o.setPreferredSize(new Dimension(btnSize, btnSize));
        y.setPreferredSize(new Dimension(btnSize, btnSize));
        g.setPreferredSize(new Dimension(btnSize, btnSize));
        b.setPreferredSize(new Dimension(btnSize, btnSize));
        i.setPreferredSize(new Dimension(btnSize, btnSize));
        v.setPreferredSize(new Dimension(btnSize, btnSize));


        // Adding action listeners to the menu buttons.
        r.addActionListener(this);
        o.addActionListener(this);
        y.addActionListener(this);
        g.addActionListener(this);
        b.addActionListener(this);
        i.addActionListener(this);
        v.addActionListener(this);
        
        
        // Positioning the colour menu on the south of the screen:
        mainPanel.add("South", colourMenu);


        // Adding the instances of the rows to the block panel:
        block.add(row.getLink());
        block.add(row1.getLink());
        block.add(row2.getLink());
        block.add(row3.getLink());
        block.add(row4.getLink());
        block.add(row5.getLink());


        // Setting out the order of where the rows start in the row array (index 0 is the starting row -- bottom row):
        rowArray[0] = row5;
        rowArray[1] = row4;
        rowArray[2] = row3;
        rowArray[3] = row2;
        rowArray[4] = row1;
        rowArray[5] = row;


        // Setting out the order of colours in the array according to their file name:
        colourArr[0] = red;
        colourArr[1] = orange;
        colourArr[2] = yellow;
        colourArr[3] = green;
        colourArr[4] = blue;
        colourArr[5] = indigo;
        colourArr[6] = violet;


        // Adding mainPanel to block:
        block.add(mainPanel);


        // Adding block to the wholePanel:
        wholePanel.add(block);


        // Close program when cross is pressed (closed).
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Set window to be visible.
        window.setVisible(true);


        // Set starting location of program to roughly the center of screen.
        window.setLocation(450, 30);


        // Makes the window the perfect size to fit everything on the screen.
        window.pack();


        // Generate random code to start the game.
        codeGen();
    }

    /**
     * Action Performed method to implement ActionListener.
     * Gives the buttons a job.
     * @param guessCounter The counter for each guess (each click on the colour menu -- guessCounter++ moves to the next guess).
     * @param counter Duplicate counter of guessCounter to avoid errors.
     * @param lineCounter Counter to keep track of which row the user is on. (lineCounter++ moves to next line).
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == r)
        {
            // Set the colour to red.
            guessArray[guessCounter] = 0;
            rowArray[lineCounter].getRowButton()[guessCounter].setIcon(colourArr[0]);
            guessCounter++;
            counter++;
        }


        if(e.getSource() == o)
        {
            // Set the colour to orange.
            guessArray[guessCounter] = 1;
            rowArray[lineCounter].getRowButton()[guessCounter].setIcon(colourArr[1]);
            guessCounter++;
            counter++;
        }


        if(e.getSource() == y)
        {
            // Set the colour to yellow.
            guessArray[guessCounter] = 2;
            rowArray[lineCounter].getRowButton()[guessCounter].setIcon(colourArr[2]);
            guessCounter++;
            counter++;
        }


        if(e.getSource() == g)
        {
            // Set the colour to green.
            guessArray[guessCounter] = 3;
            rowArray[lineCounter].getRowButton()[guessCounter].setIcon(colourArr[3]);
            guessCounter++;
            counter++;
        }


        if(e.getSource() == b)
        {
            // Set the colour to blue.
            guessArray[guessCounter] = 4;
            rowArray[lineCounter].getRowButton()[guessCounter].setIcon(colourArr[4]);
            guessCounter++;
            counter++;
        }


        if(e.getSource() == i)
        {
            // Set the colour to indigo.
            guessArray[guessCounter] = 5;
            rowArray[lineCounter].getRowButton()[guessCounter].setIcon(colourArr[5]);
            guessCounter++;
            counter++;
        }


        if(e.getSource() == v)
        {
            // Set the colour to violet.
            guessArray[guessCounter] = 6;
            rowArray[lineCounter].getRowButton()[guessCounter].setIcon(colourArr[6]);
            guessCounter++;
            counter++;
        }


        // Every time the counter (number of times the colour is entered) is greater than 3 (completed 1 guess) check if user has won. (winChecker method).
        if(counter > 3)
        {
            winChecker();
        }

        
        // Once end of guess is reached, reset all the counters and increment lineCounter to go to the next line.
        if(guessCounter == 4)
        {
            guessCounter = 0;
            counter = 0;
            lineCounter++;
        }


        // If the line counter is greater than 5, there are no more lines -- game has finished -- check if user has won (winChecker method).
        if(lineCounter > 5)
        {
            winChecker();
        }
    }

    /**
     * Win checker method -- Checks if user has won and if not, goes to checker class to give feedback.
     * @param w Instance of the End class which ends the game and displays winning message to the user.
     * @param l Instance of the End class which ends the game and displays losing message to the user.
     */
    public void winChecker()
    {
        // If the guess entered is the same as the combination -- end the game and display winning message.
        if(Arrays.equals(guessArray, combination))
        {
            for(int end = 0; end < arrayLength; end++)
            {
                rowArray[5].getGridButton()[end].setIcon(blackTickImage);
            }

            End w = new End();

            w.win();
        }

        // If the guess entered is not the right combination and the line counter has reached the end -- end game and display losing message.
        else if(lineCounter > 5 && Arrays.equals(guessArray, combination) != true)
        {
            End l = new End();
            window.dispose();
            l.lose();
        }

        // If the guess entered is not the right combination but the line counter has not reached to the end, go to checker class to get feedback.
        else if(Arrays.equals(guessArray, combination) == false)
        {
            checker();
        }
    }

    /**
     * Checker class to give the user feedback on their guesses.
     * @param guessList A list to display the guess.
     * @param guessSet A set to display the guess.
     * @param whiteList A list to keep count how many colours are right but not in correct position.
     * @param arrayLength Length of the guess array -- 4.
     * @param blackCounter Counter to keep track of how many black double ticks are achieved.
     * @param whiteCountSet A set to display whiteList as a set.
     * @param buffer A counter to take away from the correct colour if the colour is already counted as a black tick.
     * @param whiteCounter Counter to keep track of how many white single ticks are achieved.
     */
    public void checker()
    {
        // Declaring a list and a set to display the guesses:
        List<Integer> guessList = new ArrayList<>(Arrays.asList(guessArray));
        Set<Integer> guessSet = new HashSet<>(Arrays.asList(guessArray));

        // Loop - If the guess contains any number from the combination -- if position is correct, remove the number from the guess array and increment counters.
        for(int i = 0; i < arrayLength; i++)
        {
            if(guessList.contains(combination[i]))
            {
                if(guessArray[i] == combination[i])
                {
                    guessArray[i] = 7;
                    blackCounter++;
                    buffer++;
                }
                // If not in correct position then check if guess is in combination -- add the number to the white tick list.
                else if(guessArray[i] != combination[i] && guessSet.contains(combination[i]))
                {
                    whiteList.add(guessList.get(i));    // Gets the number stored at index i.
                }
            }
        }

        // Create set of the whiteList to remove duplicates.
        Set<Integer> whiteCountSet = new HashSet<>(whiteList);

        // White counter is the size of the white tick set - the numbers that are already black ticks.
        whiteCounter = whiteCountSet.size() - buffer;

        // Using the counters, display the feedback on the grid buttons.
        for(int b = 0; b < blackCounter; b++)
        {
            rowArray[lineCounter].getGridButton()[checkCounter].setIcon(blackTickImage);
            checkCounter++; // Increment so that next icon is on the button next to it.
        }

        for(int w = 0; w < whiteCounter; w++)
        {
            rowArray[lineCounter].getGridButton()[checkCounter].setIcon(whiteTickImage);
            checkCounter++; // Increment so that next icon is on the button next to it.
        }

        // If you reach the end of the guess -- reset all the counters and clear the white tick list ready for the next guess.
        if(guessCounter > 3)
        {
            checkCounter = 0;
            whiteCounter = 0;
            blackCounter = 0;
            buffer = 0;
            whiteList.clear();
        }
    }

    /**
     * codeGen method to generate a new random code for each game.
     * @param r Random number instance.
     * @param combination Integer array where the random code is stored.
     */
    public void codeGen()
    {
        Random r = new Random();

        for(int i = 0; i < 4; i++)
        {
            combination[i] = r.nextInt(7);  // Setting the boundary to 7 -- generate random numbers with the range of 0 - 6.
        }
    }

    /**
     * Getter for the JFrame window.
     * Encapsulation.
     * @param window Returns a JFrame window that can be used in other classes.
     */
    public JFrame getWindow()
    {
        return window;
    }

}