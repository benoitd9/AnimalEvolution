package Lifeforms;
/**
 * Organism is used as the interface for storing Animals and Plants
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

import java.awt.Graphics;
import javax.swing.JComponent;

public abstract class Organism extends JComponent implements Cloneable{
    
    abstract public int getX();
    
    abstract public int getY();
    
    abstract public void paintComponent(Graphics g);
    
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
}
