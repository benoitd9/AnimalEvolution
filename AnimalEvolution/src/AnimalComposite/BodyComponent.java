package AnimalComposite;

import java.lang.CloneNotSupportedException;

/**
 * BodyComponent is the interface that the Animal's body parts are based on
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class BodyComponent implements Cloneable {
    
    public abstract int getSize();
    
    /*
     * adds a child component to the body part
     * 
     * @param component the parent body part
     */
    public abstract void add(BodyComponent component) throws LeafComponentException;
    
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
}
