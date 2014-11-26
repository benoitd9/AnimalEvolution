package AnimalLogic;
/**
 * TakeTurnNormal extends TakeTurnTemplate
 *      it does not do anything special compared to the other TakeTurns
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class TakeTurnNormal extends TakeTurnTemplate
{
    /**
     * moves the Animal towards its current objective
     */
    @Override
    void move()
    {
        System.out.println("move");
    }
    
    /**
     * the animal will try to fight
     */
    @Override
    void fight()
    {
        System.out.println("fight");
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
     * end the animals turn
     */
    @Override
    void endTurn()
    {
    }
}
