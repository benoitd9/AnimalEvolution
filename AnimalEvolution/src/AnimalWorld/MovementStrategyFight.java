package AnimalWorld;
/**
 * MovementStrategyFight implements MovementStrategy
 *      The animal will look for other Animals to kill and eat
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class MovementStrategyFight implements MovementStrategy
{
    @Override
    public void doMovement()
    {
        System.out.println("Move in to fight");
    }
}
