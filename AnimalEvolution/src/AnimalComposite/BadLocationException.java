package AnimalComposite;
/**
 * BadLocationException extends Exception
    occurs when an object is out of bounds of the board
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class BadLocationException extends Exception{
    public BadLocationException(String s){
        super(s);
    }
}
