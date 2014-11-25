package AnimalWorld;

/**
 * CompLeafComponent implements BodyComponent
 *     LeafComponent is a part of the composite Animal
 *     LeafComponents have no other Components attached to them
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class CompLeafComponent implements BodyComponent {
    
    private CompLeafComponentException except = new CompLeafComponentException("This leaf has no children");
    
    /**
     * how large the BodyComponent is
     */
    private int size;
    
    
    public CompLeafComponent(int tempSize){
        size = tempSize;
    }
    
    @Override
    public int getSize(){
        return size;
    }
    
    /**
     * adds a child component to the body part
     * 
     * @param component the parent body part
     */
    @Override
    public void add(BodyComponent component) throws CompLeafComponentException{
        throw except;
    }
    
    /**
     * removes a child component to the body part
     * 
     * @param component the parent body part
     */
    @Override
    public void remove(BodyComponent component) throws CompLeafComponentException{
        throw except;
    }
    
    @Override
    public BodyComponent getChild(int i) throws CompLeafComponentException{
        throw except;
    }
    
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {		
            e.getMessage();
            throw new RuntimeException();
        }
    }
}