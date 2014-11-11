package AnimalWorld;
/**
 * Plant implements Organism
 *      Plants are food for Animals with EatingStrategyHerbivore
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class Plant implements Organism{
    protected int[] position;
    
    @Override
    public int[] getPosition(){
        return position;
    }
    
    @Override
    public int getX(){
        return position[0];
    }
    
    @Override
    public int getY(){
        return position[1];
    }
}
