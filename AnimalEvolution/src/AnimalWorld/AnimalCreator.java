package AnimalWorld;

/**
 * AnimalCreator creates Animals
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class AnimalCreator
{
    
    private static AnimalCreator instance;
    private AnimalFactory factory;
    
    private AnimalCreator(){
        factory = new SurfaceFactory();
    }
    
    
    public Animal createAnimal(String s){
        return factory.createAnimal(s);
    }
}
