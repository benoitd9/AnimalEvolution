package AnimalLogic;
/**
 * EatinstStrategyOmnivore implements EatingStrategy
 *      The Animal will eat Plants and Animals
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class EatingStrategyOmnivore implements EatingStrategy
{
    /**
     * the animal will try to eat either plants or animals
     */
    @Override
    public void eat()
    {
        System.out.println("An omnivore has been created.");
    }
}
