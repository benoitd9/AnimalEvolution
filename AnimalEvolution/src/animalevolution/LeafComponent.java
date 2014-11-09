/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AnimalWorld;

/**
 *
 * @author davidbenoit
 */
public abstract class LeafComponent implements BodyComponent {
    
    private LeafComponentException except = new LeafComponentException("This leaf has no children");
    private int size;
    
    
    public LeafComponent(int tempSize){
        size = tempSize;
    }
    
    @Override
    public int getSize(){
        return size;
    }
    
    @Override
    public void add(BodyComponent component) throws LeafComponentException{
        throw except;
    }
    
    @Override
    public void remove(BodyComponent component) throws LeafComponentException{
        throw except;
    }
    
    @Override
    public BodyComponent getChild(int i) throws LeafComponentException{
        throw except;
    }      
}