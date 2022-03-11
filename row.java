import java.awt.*;
import javax.swing.*;

public class row
{
    private JPanel panel = new JPanel();

    private Picture empty = new Picture("Empty.png");

    private JButton[] button = new JButton[4];

    private int bSize = 65;

    public row()
    {
        for(int i = 0; i < 4; i++)
        {
            button[i] = new JButton(empty);
            panel.add(button[i]);
            button[i].setPreferredSize(new Dimension(bSize, bSize));
        }
    }
}
