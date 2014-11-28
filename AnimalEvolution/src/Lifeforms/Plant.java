package Lifeforms;
/**
 * Plant implements Organism
 *      Plants are food for Animals with EatingStrategyHerbivore
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

import java.awt.Shape;

public abstract class Plant implements Organism{
    
    /**
     * the x coordinate of the plant
     */
    protected int xPosition;
    
    /**
     * the y coordinate of the plant
     */
    protected int yPosition;
    
    @Override
    public int getX(){
        return xPosition;
    }
    
    @Override
    public int getY(){
        return yPosition;
    }
    
}
