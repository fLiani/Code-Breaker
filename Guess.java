import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Random.*;

public class Guess
{
    JButton correctPosition;
    JButton correctColour;

    Gui gui = new Gui();

    Picture colour = new Picture("Score_0.png");
    Picture position = new Picture("Score_1.png");

    private Random code = new Random();

    public void codeGen()
    {
        for(int i = 0; i < 4; i++)
        {
            gui.combination[i] = code.nextInt(7);
        }

        System.out.println("Comb Elem 0: " + gui.combination[0]);
        System.out.println("Comb Elem 1: " + gui.combination[1]);
        System.out.println("Comb Elem 2: " + gui.combination[2]);
        System.out.println("Comb Elem 3: " + gui.combination[3] + "\n");
    }
}
