package AnimalComposite;

import AnimalComposite.CompositeComponent;
import java.util.List;

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
    public Object clone() throws CloneNotSupportedException {
        Torso torso = new Torso();
        List<BodyComponent> parts = this.children;
        
        try{
            
            for(BodyComponent part : parts){
                if( part instanceof Arm ){
                    torso.add( new Arm() );
                } else if( part instanceof Leg){
                    torso.add( new Leg() );
                } else if( part instanceof Head){
                    torso.add( new Head() );
                }
            }
            
            return torso;
                   
        } catch (Exception e) {
            throw new CloneNotSupportedException("Clone Unsupported: Torso");
        }
    }
}
