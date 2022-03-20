import javax.swing.*;

public class End 
{
    private JFrame endFrame;
    private JPanel endPanel;
    private JLabel label;

    private Gui gui = new Gui();

    public JFrame win()
    {
        gui.getWindow().dispose();

        endFrame = new JFrame("Congratulations!");

        endPanel = new JPanel();

        endFrame.setContentPane(endPanel);

        endFrame.setSize(500, 100);

        endFrame.setLocation(500, 100);

        endFrame.setVisible(true);

        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label = new JLabel("Well done! You Broke The Code!");

        label.setSize(300, 300);

        endPanel.add(label);

        return endFrame;
    }

    public JFrame lose()
    {
        gui.getWindow().dispose();

        endFrame = new JFrame("Better luck next time!");

        endPanel = new JPanel();

        endFrame.setContentPane(endPanel);

        endFrame.setSize(500, 100);

        endFrame.setLocation(500, 100);

        endFrame.setVisible(true);

        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label = new JLabel("You ran out of guesses :(");

        label.setSize(300, 300);

        endPanel.add(label);

        return endFrame;
    }
}
