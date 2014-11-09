package AnimalWorld;

/**
 * AnimalFactory is used by the AnimalCreator to create Animals
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public interface AnimalFactory
{
   public Animal createAnimal(String s);
}
