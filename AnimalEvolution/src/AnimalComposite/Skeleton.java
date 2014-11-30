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
    
    public int getSize(){
        int temp = 0;
        for(BodyComponent bc : children){
            temp += 1;
        }
        return temp;
    }
}
