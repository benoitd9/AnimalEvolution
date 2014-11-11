package AnimalWorld;
/**
 * TakeTurnBurrower extends TakeTurnTemplate
 *      Allows the animal to burrow/hide at the end of each turn
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class TakeTurnBurrower extends TakeTurnTemplate
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
        //burrowing results in hiding
        System.out.println("burrow");
    }
}
