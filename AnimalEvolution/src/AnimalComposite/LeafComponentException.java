package AnimalComposite;
/**
 * LeafComponentException extends Exception
     leaf components can not have child components
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class LeafComponentException extends Exception{
    public LeafComponentException(String s){
        super(s);
    }
}