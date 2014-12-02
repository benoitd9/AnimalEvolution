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
    public int getSize(){
        return 1;
    }
    
    @Override
    public int getNumLimbs(){
        return 0;
    }
    
    @Override
    public Object clone() {
            return new Bone();
    }
}
