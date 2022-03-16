import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Random.*;

public class Guess
{
    JButton correctPosition;
    JButton correctColour;

    int guessArray[] = new int[5];
    int combination[] = new int[5];

    Picture colour = new Picture("Score_0.png");
    Picture position = new Picture("Score_1.png");

    private Random code = new Random();

    public void codeGen()
    {
        for(int i = 0; i < 4; i++)
        {
            combination[i] = code.nextInt(7);
        }
        System.out.println("Comb Elem 0: " + combination[0]);
        System.out.println("Comb Elem 1: " + combination[1]);
        System.out.println("Comb Elem 2: " + combination[2]);
        System.out.println("Comb Elem 3: " + combination[3] + "\n");
    }
}
