package AnimalWorld;

/**
 * CompLeafComponent implements BodyComponent
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class CompLeafComponent implements BodyComponent {
    
    private CompLeafComponentException except = new CompLeafComponentException("This leaf has no children");
    private int size;
    
    
    public CompLeafComponent(int tempSize){
        size = tempSize;
    }
    
    @Override
    public int getSize(){
        return size;
    }
    
    @Override
    public void add(BodyComponent component) throws CompLeafComponentException{
        throw except;
    }
    
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