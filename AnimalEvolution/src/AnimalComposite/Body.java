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
            
        }

        return bod;
    }
}
