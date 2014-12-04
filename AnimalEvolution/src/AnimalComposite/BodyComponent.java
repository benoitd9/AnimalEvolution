package AnimalComposite;

import java.lang.CloneNotSupportedException;
import javax.swing.JComponent;
import java.awt.Graphics;

/**
 * BodyComponent is the interface that the Animal's body parts are based on
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class BodyComponent extends JComponent implements Cloneable {
    
    public BodyComponent(){}
    
    public abstract int getBodySize();
    
    /*
     * adds a child component to the body part
     * 
     * @param component the parent body part
     */
    public abstract void addChild(BodyComponent component) throws LeafComponentException;
    
    /**
     * removes a child component to the body part
     * 
     * @param component the parent body part
     */
    public abstract void remove(BodyComponent component) throws LeafComponentException;
    
    /**
     * returns the specified child component from its parent body part
     * 
     * @param i the child component
     * @return the child component
     */
    public abstract BodyComponent getChild(int i) throws LeafComponentException;
    
    /**
     * gets the number of limbs the animal has
     * 
     * @return the number of limbs the animal has
     */
    public abstract int getNumLimbs();
    
    /**
     * clones the animal
     * 
     * @return clone of the animal
     * @throws CloneNotSupportedException 
     */
    public abstract Object clone() throws CloneNotSupportedException;
    
    /**
     * draws the graphics
     * 
     * @param g graphics
     * @param size size of the graphics to be drawn
     */
    public abstract void paintComponent(Graphics g, int size);
}
