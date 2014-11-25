package AnimalWorld;
/**
 * CompLeafComponentException extends Exception
 *     leaf components can not have child components
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class CompLeafComponentException extends Exception{
    public CompLeafComponentException(String s){
        super(s);
    }
}