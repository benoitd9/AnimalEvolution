package AnimalWorld;

/**
 * A SurfaceDweller is an Animal that primarily lives on the surface: ground
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class SurfaceDweller extends Animal
{

    public SurfaceDweller(String name, int[] stuff){
        super(name, stuff);

    }

    @Override
    int hide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}