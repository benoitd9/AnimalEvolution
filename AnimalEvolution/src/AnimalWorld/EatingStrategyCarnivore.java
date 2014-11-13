package AnimalWorld;
/**
 * EatinstStrategyCarnivore implements EatingStrategy
 *      The Animal will only eat other Animals
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class EatingStrategyCarnivore implements EatingStrategy
{
    @Override
    public void eat()
    {
        System.out.println("A carnivore has been created.");
    }
}