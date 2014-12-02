package AnimalLogic;

import AnimalBoard.Board;
import Lifeforms.Animal;

/**
 * EatinstStrategy is the interface for all of the EatingStrategies
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public interface EatingStrategy 
{
    /**
     * the animal will try to eat
     */
    public void eat(Board b, Animal a);
}
