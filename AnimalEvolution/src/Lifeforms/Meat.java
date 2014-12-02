package Lifeforms;

import AnimalBoard.Direction;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Meat is dropped when an Animal is killed
 * Food for Carnivores
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Meat extends Organism{
    
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
