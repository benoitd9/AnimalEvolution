package AnimalWorld;
/**
 * ZBear implements Animal and creates a new ZAnimal Bear when create is invoked
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
import java.util.Random;

public class ZBear implements Animal
{
    Random rand = new Random();
    int x = rand.nextInt(1);

    @Override
    public ZAnimal create() 
    {
        return new ZAnimal("Bear", 0, 0, 1, 1, 2, 0, x/*, CompBodyComponent body*/);
    }
    
}