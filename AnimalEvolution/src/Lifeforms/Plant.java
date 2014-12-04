package Lifeforms;
/**
 * Plant implements Organism
 *      Plants are food for Animals with EatingStrategyHerbivore
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

import java.awt.Shape;

public abstract class Plant extends Organism{
    
    /**
     * the x coordinate of the plant
     */
    protected int xPosition;
    
    /**
     * the y coordinate of the plant
     */
    protected int yPosition;
    
    /**
     * how big the plant is
     */
    protected int size;
    
    public Plant(int s, int x, int y){
        size = s;
        xPosition = x;
        yPosition = y;
    }
    
    @Override
    public int getOrganismSize(){
        return size;
    }
    
    public abstract int[] grow();
    protected abstract int[] spread();
    
    public int getPlantSize(){
        return size;
    }
    
    @Override
    public int getX(){
        return xPosition;
    }
    
    @Override
    public int getY(){
        return yPosition;
    }
    
    @Override
    public void setX(int x) {
        xPosition = x;
    }

    @Override
    public void setY(int y) {
        yPosition = y;
    }
    
     /**
     * the Plant is reduced in size when it is eaten
     * a Plant of size 0 can not be eaten
     * 
     * @return  the amount that was eaten
     */
    public int eatPlant()
    {
        int temp = size;
        size = 0;
        return temp;
    }
        
}
