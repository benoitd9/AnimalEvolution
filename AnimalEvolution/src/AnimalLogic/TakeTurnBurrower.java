package AnimalLogic;
/**
 * TakeTurnBurrower extends TakeTurnTemplate
 *      Allows the animal to burrow/hide at the end of each turn
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class TakeTurnBurrower extends TakeTurnTemplate
{
    /**
     * the animal will move towards its current objective
     */
    @Override
    void move()
    {
        System.out.println("move");
    }
    
    /**
     * the animal will try to run away
     */
    @Override
    void fight()
    {
        System.out.println("flight");
    }
    
    /**
     * the animal will try to eat
     */
    @Override
    void eat()
    {
        System.out.println("eat");
    }
    
    /**
     * the animal will burrow at the end of the turn to hide from predators
     *     this will lower the range of detection for predators
     */
    @Override
    void endTurn()
    {
        //burrowing results in hiding
        System.out.println("burrow");
    }
}
