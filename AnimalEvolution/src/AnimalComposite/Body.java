package AnimalComposite;

import java.util.List;

/**
 * Body extends CompositeComponent
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Body extends CompositeComponent{
    public Body(){
        super();
    }
    
    public Body(Body orig){
        this.children = orig.children;
    }
    
    @Override
    public Object clone() {
        Body bod = new Body(this);
        List<BodyComponent> childs = bod.children;

        for(BodyComponent comps : childs){
            
            if (comps instanceof Arm) {
                bod.add(new Arm());
            } else if(comps instanceof Head){
                bod.add(new Head());
            } else if(comps instanceof Leg){
                bod.add(new Leg());
            } else if(comps instanceof Torso){
                bod.add(new Torso());
            }
             
        }

        return bod;
    }
}
