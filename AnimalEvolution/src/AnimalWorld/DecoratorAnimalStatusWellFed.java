package AnimalWorld;
/**
 * DecoratorAnimalStatusWellFed extends DecoratorAnimalStatus
 *      Sets an animal to WellFed if it has eaten recently
 *      Starving Animals have increased strength and movementSpeed
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class DecoratorAnimalStatusWellFed extends DecoratorAnimalStatus
{
    public DecoratorAnimalStatusWellFed(Animal decoAni)
    {
        super(decoAni);
    }
    /*
    @Override
    public ZAnimal create()
    {
        decoAni.create();
        setWellFed(decoAni);
        return decoAni.create();
    }
    */
    
    private void setWellFed(Animal decoAni)
    {
        System.out.println("Just ate and is well fed");
        //increase Strength and movement speed
    }
}