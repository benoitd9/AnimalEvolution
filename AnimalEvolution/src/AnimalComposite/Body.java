package AnimalComposite;
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
            return new Body(this);
    }
}
