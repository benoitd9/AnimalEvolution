package AnimalWorld;
/**
 * TakeTurnNormal extends TakeTurnTemplate
 *      it does not do anything special compared to the other TakeTurns
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class TakeTurnNormal extends TakeTurnTemplate
{
    @Override
    void move()
    {
        System.out.println("move");
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
    }
}
