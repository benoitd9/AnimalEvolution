package AnimalWorld;
/**
 * Plant implements Organism
 *      Plants are food for Animals with EatingStrategyHerbivore
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class Plant implements Organism{
    protected int xPosition;
    protected int yPosition;
    
    @Override
    public int getX(){
        return xPosition;
    }
    
    @Override
    public int getY(){
        return yPosition;
    }
}
