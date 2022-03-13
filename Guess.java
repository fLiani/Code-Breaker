import javax.swing.*;
import java.awt.*;


public class Guess
{
    private Picture empty = new Picture("Empty.png");

    private JButton[] button = new JButton[4];

    private JPanel panel = new JPanel();

    public Guess()
    {
        for(int i = 0; i < 4; i++)
        {
            button[i] = new JButton(empty);
            panel.add(button[i]);
            button[i].setPreferredSize(new Dimension(62, 62));
        }
    }

    public JPanel getPanel()
    {
        return panel;
    }
 
}
