package AnimalWorld;
/**
 * TakeTurnFlyer extends TakeTurnTemplate
 *      It allows the animal to fly over rough terrain
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class TakeTurnFlyer extends TakeTurnTemplate
{
    @Override
    void move()
    {
        //flying can bypass rough terrain
        System.out.println("fly");
    }
    
    @Override
    void fight()
    {
        System.out.println("fight");
    }
    
    @Override
    void eat()
    {
        System.out.println("eat");
    }
    
    @Override
    void endTurn()
    {
        System.out.println("land");
    }
}
