package AnimalLogic;

import AnimalBoard.Board;
import Lifeforms.Animal;

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
    protected void move(Board b, Animal a)
    {
        int x = a.getX();
        int y = a.getY();
        a.getMovement().doMovement(b, a);
        System.out.println("Animal: " + a.getName() + " moved from: " + x + "," + y + " to " + a.getX() + "," + a.getY());
        
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
     * end the animals turn
     */
    @Override
    protected void endTurn(Animal a)
    {
        //System.exit(0);
    }
}
