package Lifeforms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

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
     * a meat of size 0 can not be eaten
     * 
     * @return  the amount that was eaten
     */
    public int eatMeat()
    {
        int temp = size;
        size = 0;
        return temp;
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

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(xPosition*16+(28-size),yPosition*16+(28-size/4),size*2,size/2);
        g2d.fillOval(xPosition*16+(28-size+size/4),yPosition*16+(28-size/2),size/2,size/2);
        g2d.fillOval(xPosition*16+(28-size+size/4),yPosition*16+(28+size/2),size/2,size/2);
        g2d.fillOval(xPosition*16+(28+size+size/4),yPosition*16+(28-size/2),size/2,size/2);
        g2d.fillOval(xPosition*16+(28+size+size/4),yPosition*16+(28+size/2),size/2,size/2);
        g2d.setColor(new Color(102,0,0));
        g2d.fillOval(xPosition*16+(28-size/2),yPosition*16+(28-size/4),size,size/2);
    }
}
