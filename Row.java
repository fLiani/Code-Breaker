import java.awt.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.event.*;

public class Row implements ActionListener
{
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel container = new JPanel();
    private JPanel link = new JPanel();

    private Picture empty = new Picture("Empty.png");

    JButton[] rowButton = new JButton[5];

    private JButton[] gridButton = new JButton[4];

    public Row()
    {
        for(int j = 0; j < gridButton.length; j++)
        {
            gridButton[j] = new JButton(empty);
            panel2.add(gridButton[j]);
            gridButton[j].setPreferredSize(new Dimension(90, 50));
        }

        for(int i = 0; i < rowButton.length - 1; i++)
        {
            rowButton[i] = new JButton(empty);
            panel.add(rowButton[i]);
            rowButton[i].setPreferredSize(new Dimension(62, 62));
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

    public JPanel getLink()
    {
        return link;
    }

    public void actionPerformed(ActionEvent event)
    {

    }
}