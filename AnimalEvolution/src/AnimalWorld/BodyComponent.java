package AnimalWorld;
/**
 * BodyComponent is the interface that the Animal's body parts are based on
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public interface BodyComponent extends Cloneable {
    public int getSize();
    public void add(BodyComponent component) throws CompLeafComponentException;
    public void remove(BodyComponent component) throws CompLeafComponentException;
    public BodyComponent getChild(int i) throws CompLeafComponentException;
    public BodyComponent clone() throws CloneNotSupportedException;
}
