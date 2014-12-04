package AnimalComposite;

/**
 * BodyComponentDecorator
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class BodyComponentDecorator extends BodyComponent{
    
    private BodyComponent decoComp;
    
    public BodyComponentDecorator(BodyComponent decoComp){
        
    }
    
    public Object clone(){
        try{
            return decoComp.clone();
        }
        catch(Exception e){
            return null;
        }
    }
    
}
