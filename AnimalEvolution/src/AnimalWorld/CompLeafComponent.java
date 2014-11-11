package AnimalWorld;
/**
 * CompLeafComponent implements CompBodyComponent
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class CompLeafComponent implements CompBodyComponent {
    
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
    public void add(CompBodyComponent component) throws CompLeafComponentException{
        throw except;
    }
    
    @Override
    public void remove(CompBodyComponent component) throws CompLeafComponentException{
        throw except;
    }
    
    @Override
    public CompBodyComponent getChild(int i) throws CompLeafComponentException{
        throw except;
    }      
}