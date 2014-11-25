package AnimalWorld;
/**
 * CompBadLocationException extends Exception
 *    occurs when an object is out of bounds of the board
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class CompBadLocationException extends Exception{
    public CompBadLocationException(String s){
        super(s);
    }
}
