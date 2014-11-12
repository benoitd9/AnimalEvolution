package AnimalWorld;

import java.util.List;
import java.util.LinkedList;

/**
 * CompositeComponent implements BodyComponent
      CompositeComponent is a body part that contains other body parts
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class CompositeComponent implements BodyComponent{
    protected List<BodyComponent> children;
    protected int size;
    
    public CompositeComponent(int tempSize){
        children = new LinkedList<BodyComponent>();
        size = tempSize;
    }
    
    @Override
    public int getSize(){
        int tempSize = 0;
        for(int i = 0; i < children.size(); i++){
            tempSize += children.get(i).getSize();
        }
        if(tempSize <= size)
            tempSize = size;
        return tempSize;
    }
    
    @Override
    public void add(BodyComponent component){
        children.add(component);
    }
    
    @Override
    public void remove(BodyComponent component){
        children.remove(component);
    }
    
    @Override
    public BodyComponent getChild(int i){
        return children.get(i);
    }
}
