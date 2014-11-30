package AnimalComposite;

/**
 * LeafComponent implements BodyComponent
     LeafComponent is a part of the composite Animal
     LeafComponents have no other Components attached to them
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class LeafComponent implements BodyComponent {
    
    private LeafComponentException except = new LeafComponentException("This leaf has no children");
    
    
    public LeafComponent(){
    }
    
    @Override
    public int getSize() throws LeafComponentException{
        throw except;
    }
    
    /**
     * adds a child component to the body part
     * 
     * @param component the parent body part
     */
    @Override
    public void add(BodyComponent component) throws LeafComponentException{
        throw except;
    }
    
    /**
     * removes a child component to the body part
     * 
     * @param component the parent body part
     */
    @Override
    public void remove(BodyComponent component) throws LeafComponentException{
        throw except;
    }
    
    @Override
    public BodyComponent getChild(int i) throws LeafComponentException{
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