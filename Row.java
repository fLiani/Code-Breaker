import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Row implements ActionListener
{
    private JPanel panel2 = new JPanel();
    private JPanel container = new JPanel();
    private JPanel link = new JPanel();

    private Picture empty = new Picture("Empty.png");

    private JButton[] button = new JButton[4];

    private Guess newGuess = new Guess();

    public Row()
    {
        for(int j = 0; j < 4; j++)
        {
            button[j] = new JButton(empty);
            panel2.add(button[j]);
            button[j].setPreferredSize(new Dimension(90, 50));
        }

        panel2.setLayout(new GridLayout(2, 2));
        container.setLayout(new BorderLayout());

        link.add("West", newGuess.getPanel());
        link.add("East", panel2);

        container.add("Center", link);

        panel2.setBackground(Color.GRAY);
        container.setBackground(Color.GRAY);
        link.setBackground(Color.GRAY);
    }

    public JPanel getLink()
    {
        return link;
    }

    public void actionPerformed(ActionEvent event)
    {

    }
}