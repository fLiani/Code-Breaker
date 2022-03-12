import java.awt.*;
import javax.swing.*;

public class Row
{
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel container = new JPanel();
    JPanel link = new JPanel();

    private Picture empty = new Picture("Empty.png");

    private JButton[] button = new JButton[4];

    private int bSize = 65;

    public Row()
    {
        for(int i = 0; i < 4; i++)
        {
            button[i] = new JButton(empty);
            panel.add(button[i]);
            button[i].setPreferredSize(new Dimension(bSize, bSize));
        }

        for(int j = 0; j < 4; j++)
        {
            button[j] = new JButton(empty);
            panel2.add(button[j]);
            button[j].setPreferredSize(new Dimension(bSize, 50));
        }

        panel2.setLayout(new GridLayout(2, 2));
        container.setLayout(new BorderLayout());

        link.add("West", panel);
        link.add("East", panel2);

        container.add("Center", link);

        panel.setBackground(Color.GRAY);
        panel2.setBackground(Color.GRAY);
        container.setBackground(Color.GRAY);
        link.setBackground(Color.GRAY);
    }
}