package Lifeforms;

import java.lang.CloneNotSupportedException;
import AnimalBoard.Direction;
import java.awt.Color;


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
    public int getSpeed();
    public void setX(int x);
    public void setY(int y);
    public String getName();
    public boolean getIsCannibal();
    public Color getColor();
}
