import javax.swing.*;

public class End 
{
    JFrame endFrame;
    JPanel endPanel;
    JLabel endLabel;

    public End()
    {
        endFrame = new JFrame("You ran out of guesses :(");
        endPanel = new JPanel();
        endLabel = new JLabel("You ran out of guesses :(");

        endFrame.setContentPane(endPanel);

        endPanel.add(endLabel);

        endFrame.setSize(500, 100);

        endFrame.setLocation(500, 100);

        endFrame.setVisible(true);

        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
