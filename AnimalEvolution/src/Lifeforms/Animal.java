package Lifeforms;

import java.lang.CloneNotSupportedException;
import AnimalBoard.Direction;
import java.awt.Color;


/**
 * Animal is the interface for all of the Animals
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class Animal extends Organism{
    public abstract Direction getDirection();
    public abstract void turnClockwise();
    public abstract void turnCounterClockwise();
    public abstract void turnToFace(Direction d);
    public abstract int getSpeed();
    public abstract void setX(int x);
    public abstract void setY(int y);
    public abstract String getName();
    public abstract boolean getIsCannibal();
    public abstract Color getColor();
}
