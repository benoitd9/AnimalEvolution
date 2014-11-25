package AnimalWorld;
/**
 * EatinstStrategyHerbivore implements EatingStrategy
 *      The Animal will only eat plants
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class EatingStrategyHerbivore implements EatingStrategy
{
    /**
     * the animal try to eat plants
     */
    @Override
    public void eat()
    {
        System.out.println("An herbivore has been created.");
    }
}
