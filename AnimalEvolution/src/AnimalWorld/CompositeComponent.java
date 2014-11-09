/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalWorld;

import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Holly
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
