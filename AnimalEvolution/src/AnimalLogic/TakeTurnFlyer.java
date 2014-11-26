package AnimalLogic;
/**
 * TakeTurnFlyer extends TakeTurnTemplate
 *      It allows the animal to fly over rough terrain
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class TakeTurnFlyer extends TakeTurnTemplate
{
    /**
     * fly allows the animal to pass over terrain without impairment
     */
    @Override
    void move()
    {
        
        System.out.println("fly");
    }
    
    /**
     * the animal will implement its fight strategy
     */
    @Override
    void fight()
    {
        System.out.println("fight");
    }
    
    /**
     * the animal will try to eat
     */
    @Override
    void eat()
    {
        System.out.println("eat");
    }
    
    /**
     * the animal will land at the end of its turn
     */
    @Override
    void endTurn()
    {
        System.out.println("land");
    }
}
