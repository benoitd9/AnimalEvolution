package AnimalComposite;

import AnimalComposite.CompositeComponent;

/**
 * Torso extends CompositeComponent
 *     Torso is a body part of a composite Animal
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Torso extends CompositeComponent{
    public Torso(){
        super();
    }
    
    public Torso(Torso orig){
        this.children = orig.children;
    }
    
    @Override
    public Object clone() {
            return new Torso(this);
    }
}
