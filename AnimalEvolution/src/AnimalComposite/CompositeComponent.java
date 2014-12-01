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
    
    public CompositeComponent(){
        children = new LinkedList<BodyComponent>();
    }
    
    @Override
    public int getSize(){
            
        int temp = 0;
            
        for(BodyComponent bc : children){
            try{
                temp = bc.getSize();
            }
            catch(Exception e){}
        }
            
        return temp;
    }
    
    @Override
    public int getNumLimbs(){
        int temp = 0;
        for(BodyComponent bc : children){
            temp += bc.getNumLimbs();
        }
        return temp;
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
