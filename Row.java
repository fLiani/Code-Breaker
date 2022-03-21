import java.awt.*;
import javax.swing.*;

/**
 * Row class to create instances of the guess rows.
 */
public class Row
{
    // Initialising all the panels needed for this class.
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel container = new JPanel();
    private JPanel link = new JPanel();


    // Initialising empty guess picture.
    private Picture empty = new Picture("Empty.png");


    // Initialising two button arrays for the class.
    private JButton[] rowButton = new JButton[4];
    private JButton[] gridButton = new JButton[4];

    /**
     * Row Constructor - Creates empty rows.
     * @param gridButton Feedback button array.
     * @param rowButton Guess botton array.
     * @param panel Panel for the row buttons
     * @param panel2 Panel for the feeback buttons
     * @param link Panel to link the two button panels together.
     * @param container Greater panel for the the link panel to avoid errors.
     */
    public Row()
    {
        // Creates 4 feedback buttons for the right hand side of the window.
        for(int j = 0; j < gridButton.length; j++)
        {
            gridButton[j] = new JButton(empty);
            panel2.add(gridButton[j]);
            gridButton[j].setPreferredSize(new Dimension(90, 50));  // Sets the size of the buttons.
        }

        // Creates 4 empty guess buttons.
        for(int i = 0; i < rowButton.length; i++)
        {
            rowButton[i] = new JButton(empty);
            panel.add(rowButton[i]);
            rowButton[i].setPreferredSize(new Dimension(61, 61));   // Sets the size of the buttons.
        }

        // Setting layouts of the panels.
        panel2.setLayout(new GridLayout(2, 2));
        container.setLayout(new BorderLayout());

        // Positioning the feeback button panel and the row button panel inside the link panel.
        link.add("West", panel);
        link.add("East", panel2);

        // Adding the link panel to the center of the container panel.
        container.add("Center", link);

        // Setting backgrounds to gray.
        panel.setBackground(Color.GRAY);
        panel2.setBackground(Color.GRAY);
        container.setBackground(Color.GRAY);
        link.setBackground(Color.GRAY);
    }

    /**
     * Getter for the link panel.
     * Encapsulation.
     * @param link Returns the link panel to be used in other classes.
     * @return Link
     */
    public JPanel getLink()
    {
        return link;
    }

    /**
     * Getter for the row button array.
     * Encapsulation.
     * @param rowButton[] Returns the button array to be accessed in other classes.
     * @return rowButton Array
     */
    public JButton[] getRowButton()
    {
        return rowButton;
    }

/**
 * Getter for the feedback button array.
 * Encapsulation.
 * @param gridButton[] Returns the button array to be accessed in other classes.
 */
    public JButton[] getGridButton()
    {
        return gridButton;
    }
}