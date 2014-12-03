package AnimalLogic;

import AnimalBoard.Board;
import Lifeforms.Animal;

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
    abstract void move(Board b, Animal a);
    
    /**
     * Animal will fight
     */
    abstract void fight(Animal a, Animal b);
    
    /**
     * implements the Animals eating strategy
     */
    abstract void eat(Board b, Animal a);
    
    /**
     * ends the animal turn
     */
    abstract void endTurn(Animal a);
    
    /**
     * template method
     *   runs the animal through the turn order
     */
    public final void act()
    {
        Animal a = null,c = null;    
        Board b = null;
        move(b, a);
        fight(a, c);
        eat(b, a);
        endTurn(a);
    }
}
