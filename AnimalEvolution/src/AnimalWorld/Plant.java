package AnimalWorld;
/**
 * Plant implements Organism
 *      Plants are food for Animals with EatingStrategyHerbivore
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

import java.awt.Shape;

public abstract class Plant implements Organism{
    protected int xPosition;
    protected int yPosition;
    protected int spriteX;
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
