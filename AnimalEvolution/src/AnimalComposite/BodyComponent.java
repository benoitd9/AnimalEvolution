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
    
    public abstract int getNumLimbs();
    
    public abstract Object clone() throws CloneNotSupportedException;
    
    public abstract void paintComponent(Graphics g, int size);
}
