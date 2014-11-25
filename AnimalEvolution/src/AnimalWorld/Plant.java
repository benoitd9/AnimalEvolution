package AnimalWorld;
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
    
    /**
     * the x coordinate of the sprite of the plant
     */
    protected int spriteX;
    
    /**
     * the y coordinate of the sprite of the plant
     */
    protected int spriteY;
    
    @Override
    public int getX(){
        return xPosition;
    }
    
    @Override
    public int getY(){
        return yPosition;
    }
    
    @Override
    public int getSpriteX(){
        return spriteX;
    }
    
    @Override
    public int getSpriteY(){
        return spriteY;
    }
}
