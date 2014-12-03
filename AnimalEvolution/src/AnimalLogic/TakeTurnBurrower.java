package AnimalLogic;

import AnimalBoard.Board;
import Lifeforms.Animal;

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
    protected void move(Board b, Animal a)
    {
        a.getMovement().doMovement(b, a);
    }
    
    /**
     * the animal will try to eat
     */
    @Override
    protected void eat(Board b, Animal a)
    {
        a.getEatStrat().eat(b, a);
    }
    
    /**
     * the animal will burrow at the end of the turn to hide from predators
     *     this will lower the range of detection for predators
     */
    @Override
    protected void endTurn(Animal a)
    {
        a.hide();
    }
}
