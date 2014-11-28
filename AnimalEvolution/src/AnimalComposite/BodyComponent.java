package AnimalComposite;

import java.lang.CloneNotSupportedException;

/**
 * BodyComponent is the interface that the Animal's body parts are based on
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public interface BodyComponent extends Cloneable {
    
    public int getSize();
    
    /**
     * adds a child component to the body part
     * 
     * @param component the parent body part
     */
    public void add(BodyComponent component) throws CompLeafComponentException;
    
    /**
     * removes a child component to the body part
     * 
     * @param component the parent body part
     */
    public void remove(BodyComponent component) throws CompLeafComponentException;
    
    /**
     * returns the specified child component from its parent body part
     * 
     * @param i the child component
     * @return the child component
     */
    public BodyComponent getChild(int i) throws CompLeafComponentException;
    
    public Object clone() throws CloneNotSupportedException;
}