package AnimalLogic;
/**
 * TakeTurnTemplate is the template for all of the TakeTurns
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class TakeTurnTemplate 
{
     /**
     * moves the Animal towards its current objective
     */
    abstract void move();
    
    /**
     * implements the fight strategy of the animal
     *     fight, flight, random
     */
    abstract void fight();
    
    /**
     * implements the Animals eating strategy
     */
    abstract void eat();
    
    /**
     * implements the end turn strategy
     *     hide for example
     */
    abstract void endTurn();
    
    /**
     * template method
     *   runs the animal through the turn order
     */
    public final void act()
    {
        move();
        fight();
        eat();
        endTurn();
    }
}
