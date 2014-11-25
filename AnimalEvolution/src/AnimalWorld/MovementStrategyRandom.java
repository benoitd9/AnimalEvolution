package AnimalWorld;

import java.util.Random;

/**
 * MovementStrategyRandom implements MovementStrategy
 *      The Animal will either Fight or Flight
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class MovementStrategyRandom implements MovementStrategy
{
    /**
     * the animal will randomly either head towards or away from a fight
     */
    @Override
    public void doMovement()
    {
        Random rand = new Random();
        int x = rand.nextInt(10);
        if(x < 5)
        {
            System.out.println("Move in to fight");
        }
        else
        {
            System.out.println("Run away");
        }
    }
}
