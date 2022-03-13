import java.util.Random;

public class Guess
{

    public Guess()
    {
        for(int i = 0; i < 4; i++)
        {
            Random g = new Random();

            int randCode = g.nextInt(7);

            System.out.println(randCode);
        }
    }

}
