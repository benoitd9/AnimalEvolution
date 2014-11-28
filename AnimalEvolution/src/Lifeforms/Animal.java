package Lifeforms;

import java.lang.CloneNotSupportedException;
import AnimalBoard.Direction;


/**
 * Animal is the interface for all of the Animals
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public interface Animal extends Organism{
    public abstract Object clone ( );
    public Direction getDirection();
    public void turnClockwise();
    public void turnCounterClockwise();
    public void turnToFace(Direction d);
}
