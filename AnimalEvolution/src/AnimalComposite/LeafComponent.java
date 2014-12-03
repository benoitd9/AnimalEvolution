package AnimalComposite;

/**
 * LeafComponent implements BodyComponent
     LeafComponent is a part of the composite Animal
     LeafComponents have no other Components attached to them
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class LeafComponent extends BodyComponent {
    
    private LeafComponentException except = new LeafComponentException("This leaf has no children");
    
    
    public LeafComponent(){
    }
    
    @Override
    public int getBodySize(){
        return 0;
    }
    
    /**
     * adds a child component to the body part
     * 
     * @param component the parent body part
     */
    @Override
    public void addChild(BodyComponent component) throws LeafComponentException{
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
    public abstract Object clone();
    
    @Override
    public int getNumLimbs(){
        return 0;
    }
}