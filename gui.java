import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui
{
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel colourMenu;
    private JPanel score;

    private JButton empty;
    private JButton whiteTick;
    private JButton blackTick;
    private JButton r;
    private JButton o;
    private JButton y;
    private JButton g;
    private JButton b;
    private JButton i;
    private JButton v;


    public gui()
    {
        frame = new JFrame("Code Breaker! - By Fabrizio Liani");
        mainPanel = new JPanel();
        
        colourMenu = new JPanel();

        frame.setContentPane(mainPanel);

        frame.setSize(240,800);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}