package AnimalWorld;

/**
 * A Burrower is an animal that hide at the end of its movement by burrowing
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Burrower extends Animal
{

    public Burrower(String name, int[] stuff, BodyComponent body){
        super(name, stuff, body);
    }
    
    public void burrow()
    {
        
    }

    @Override
    int hide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}