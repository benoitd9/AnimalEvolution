package AnimalLogic;
/**
 * MovementStrategy is the interface for all of the MovementStrategies
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public interface MovementStrategy 
{
    /**
     * base strategy method for moving the animal
     */
    public void doMovement(AnimalBoard.Board board, Lifeforms.Animal a);
}
