package AnimalWorld;
/**
 * ZRabbit implements Animal and creates a new ZAnimal Rabbit when create is invoked
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
import java.util.Random;

public class ZRabbit implements Animal
{
    Random rand = new Random();
    int x = rand.nextInt(1);

    @Override
    public ZAnimal create() 
    {
        return new ZAnimal("Rabbit", 0, 0, 2, 2, 3, 0, x/*, CompBodyComponent body*/);
    }
}
