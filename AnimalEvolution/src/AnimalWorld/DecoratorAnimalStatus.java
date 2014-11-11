package AnimalWorld;
/**
 * DecoratorAnimalStatus implements Animal
 *      This decorator that is used to apply status effects to an Animal
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class DecoratorAnimalStatus implements Animal
{
    protected Animal decoAni;
    
    public DecoratorAnimalStatus(Animal decoAni)
    {
        this.decoAni = decoAni;
    }
    
    @Override
    public ZAnimal create()
    { 
        return decoAni.create();
    }
}
