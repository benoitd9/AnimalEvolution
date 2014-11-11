package AnimalWorld;
/**
 * AnimalFactorySingleton creates Animals
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class AnimalFactorySingleton 
{
    //create an object of SingleObject
    private static AnimalFactorySingleton instance = new AnimalFactorySingleton();

    //make the constructor private so that this class cannot be instantiated
    private AnimalFactorySingleton(){}

    //Get the only object available
    public static AnimalFactorySingleton getInstance()
    {
        return instance;
    }
   
    public static Animal getAnimal(String aniType)
    {
        if(aniType == null)
        {
            return null;
        }
        if(aniType.equalsIgnoreCase("BEAR"))
        {
            return new ZBear();
        }else if(aniType.equalsIgnoreCase("RABBIT"))
        {
            return new ZRabbit();
        }else if(aniType.equalsIgnoreCase("EAGLE"))
        {
            return new ZRabbit();
        }
        return null;
    }
}
