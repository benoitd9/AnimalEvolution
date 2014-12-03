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
    
    public TakeTurnTemplate(){
        
    }
     /**
     * moves the Animal towards its current objective
     */
    abstract protected void move(Board b, Animal a);
    
    /**
     * implements the Animals eating strategy
     */
    abstract protected void eat(Board b, Animal a);
    
    /**
     * ends the animal turn
     */
    abstract protected void endTurn(Animal a);
    
    /**
     * template method
     *   runs the animal through the turn order
     */
    public final void act(Animal aniA, Board b)
    {
        move(b, aniA);
        eat(b, aniA);
        endTurn(aniA);
    }
}
