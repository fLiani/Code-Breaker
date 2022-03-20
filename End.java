import javax.swing.*;

/**
 * Class to end the game if player wins or runs out of guesses.
 */
public class End 
{
    // Initialising JFrame, JPanel and JLabel to be used in the constructor.
    private JFrame endFrame;
    private JPanel endPanel;
    private JLabel label;

    // Create an instance of the GUI class to access its window frame.
    private Gui gui = new Gui();

    /**
     * Method to create a winning window -- if the user wins.
     * @param endFrame Frame for the winning window -- Returns the whole window.
     * @param endPanel Panel for the winning window.
     * @param label Label to display the winning message.
     */
    public JFrame win()
    {
        gui.getWindow().dispose();  // Gets rid of the window created by the gui instance.

        endFrame = new JFrame("Congratulations!");

        endPanel = new JPanel();

        endFrame.setContentPane(endPanel);

        endFrame.setSize(500, 100);     // Set size of winning window.

        endFrame.setLocation(500, 100); // Set location to appear on the screen.

        endFrame.setVisible(true);      // Set to be visible.

        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Exit the program when the cross is pressd (close).
        
        label = new JLabel("Well done! You Broke The Code!");

        label.setSize(300, 300);    // Set size of label.

        endPanel.add(label);        // Add label to panel.

        return endFrame;
    }

    /**
     * Method to create a losing window -- if the user runs out of guesses -- Returns the whole window.
     * @param endFrame Frame for the winning window.
     * @param endPanel Panel for the winning window.
     * @param label Label to display the winning message.
     */
    public JFrame lose()
    {
        gui.getWindow().dispose();  // Gets rid of the window created by the gui instance.

        endFrame = new JFrame("Better luck next time!");

        endPanel = new JPanel();

        endFrame.setContentPane(endPanel);

        endFrame.setSize(500, 100);         // Set size of losing window.

        endFrame.setLocation(500, 100);     // Set location to appear on the screen.

        endFrame.setVisible(true);          // Set to be visible.

        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Exit the program when the cross is pressd (close).
        
        label = new JLabel("You ran out of guesses :(");

        label.setSize(300, 300);            // Set size of label.

        endPanel.add(label);                // Add label to panel.

        return endFrame;
    }
}
