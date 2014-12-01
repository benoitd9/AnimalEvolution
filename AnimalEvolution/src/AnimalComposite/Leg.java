package AnimalComposite;
/**
 * Leg extends CompositeLeafComponent
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Leg extends LeafComponent{
    public Leg(){
        super();
    }
    
    @Override
    public int getNumLimbs(){
        return 1;
    }
}
