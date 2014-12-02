package Lifeforms;

import java.awt.Graphics;

/**
 * Meat is dropped when an Animal is killed
 * Food for Carnivores
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Meat extends Organism
{
    
     /**
     * x coordinate of the Meat
     */
    protected int xPosition;
    
    /**
     * y coordinate of the Meat
     */
    protected int yPosition;
    
    /**
     * how big the pile of Meat is
     */
    protected int size;
    
    public Meat(int s, int x, int y){
        size = s;
        xPosition = x;
        yPosition = y;
    }    
    /**
     * the meat is reduced in size when it is eaten
     * a meat of size less than 0 can not be eaten
     * 
     * @param s how much of the meat has been eaten
     * @return  the amount that was eaten
     */
    public int eatMeat()
    {
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
    public void paintComponent(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
