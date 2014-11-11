package AnimalWorld;
/**
 * MovementStrategyFlight implements MovementStrategy
 *      The animal can fly over rough terrain
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class MovementStrategyFlight implements MovementStrategy
{
    @Override
    public void doMovement()
    {
        System.out.println("Run away");
    }
}
