package AnimalComposite;

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
    
    /**
     * adds a child component to the body part
     * 
     * @param component the parent body part
     */
    @Override
    public void add(BodyComponent component){
        children.add(component);
    }
    
    /**
     * removes a child component to the body part
     * 
     * @param component the parent body part
     */
    @Override
    public void remove(BodyComponent component){
        children.remove(component);
    }
    
    /**
     * returns the specified child component from its parent body part
     * 
     * @param i the child component
     * @return the child component
     */
    @Override
    public BodyComponent getChild(int i){
        return children.get(i);
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
