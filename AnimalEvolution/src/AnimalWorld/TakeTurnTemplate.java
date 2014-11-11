package AnimalWorld;
/**
 * TakeTurnTemplate is the template for all of the TakeTurns
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class TakeTurnTemplate 
{
    abstract void move();
    abstract void fight();
    abstract void eat();
    abstract void endTurn();
    
    //template method
    public final void act()
    {
        move();
        fight();
        eat();
        endTurn();
    }
}
