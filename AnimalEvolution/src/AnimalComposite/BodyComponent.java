package AnimalComposite;

import java.lang.CloneNotSupportedException;

/**
 * BodyComponent is the interface that the Animal's body parts are based on
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public interface BodyComponent extends Cloneable {
    
    public int getSize() throws LeafComponentException;
    
    /**
     * adds a child component to the body part
     * 
     * @param component the parent body part
     */
    public void add(BodyComponent component) throws LeafComponentException;
    
    /**
     * removes a child component to the body part
     * 
     * @param component the parent body part
     */
    public void remove(BodyComponent component) throws LeafComponentException;
    
    /**
     * returns the specified child component from its parent body part
     * 
     * @param i the child component
     * @return the child component
     */
    public BodyComponent getChild(int i) throws LeafComponentException;
    
    public Object clone() throws CloneNotSupportedException;
}
