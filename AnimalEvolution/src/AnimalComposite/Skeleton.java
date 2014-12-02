package AnimalComposite;

import AnimalComposite.CompositeComponent;

/**
 * Skeleton extends CompositeComponent
 *     it is made up of bones
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Skeleton extends CompositeComponent{
    public Skeleton(){
        super();
    }
    
    public Skeleton(Skeleton orig){
        this.children = orig.children;
    }
    
    @Override
    public int getSize(){
        int temp = 0;
        for(BodyComponent bc : children){
            temp += 1;
        }
        return temp;
    }
    
    @Override
    public int getNumLimbs(){
        return 0;
    }
    
    @Override
    public Object clone() {
            return new Skeleton(this);
    }
}
