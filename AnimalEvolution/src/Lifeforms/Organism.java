package Lifeforms;
/**
 * Organism is used as the interface for storing Animals and Plants
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

import java.awt.Graphics;
import javax.swing.JComponent;

public abstract class Organism extends JComponent{
    
    abstract public int getX();
    abstract public int getY();
    public abstract void setX(int x);
    public abstract void setY(int y);
    public abstract int getOrganismSize();
    abstract public void paintComponent(Graphics g);
    
}
