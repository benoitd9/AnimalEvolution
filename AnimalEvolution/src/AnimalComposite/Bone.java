package AnimalComposite;
/**
 * Bone extends CompositeLeafComponent
 *     bones make up the skeleton
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Bone extends LeafComponent{
    public Bone(){
        super();
    }
    
    @Override
    public int getNumLimbs(){
        return 0;
    }
}
