package AnimalWorld;
/**
 * CompBodyComponent is the interface that the Animal's body parts are based on
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public interface CompBodyComponent {
    public int getSize();
    public void add(CompBodyComponent component) throws CompLeafComponentException;
    public void remove(CompBodyComponent component) throws CompLeafComponentException;
    public CompBodyComponent getChild(int i) throws CompLeafComponentException;
}
