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
    void move(Board b, Animal a)
    {
        a.getMovement().doMovement(b, a);
    }
    
    /**
     * the animal will try to fight
     */
    @Override
    void fight(Animal a, Animal b)
    {
        System.out.println("fight");
    }
    
    /**
     * the animal will try to eat
     */
    @Override
    void eat(Board b, Animal a)
    {
        a.getEatStrat().eat(b, a);
    }
    
    /**
     * end the animals turn
     */
    @Override
    void endTurn(Animal a)
    {
    }
}
