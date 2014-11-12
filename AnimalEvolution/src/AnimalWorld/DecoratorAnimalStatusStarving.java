package AnimalWorld;
/**
 * DecoratorAnimalStatusStarving extends DecoratorAnimalStatus
 *      Sets an animal to starving if it has not eaten in a while
 *      Starving Animals have reduced strength and movementSpeed
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class DecoratorAnimalStatusStarving extends DecoratorAnimalStatus
{
    public DecoratorAnimalStatusStarving(Animal decoAni)
    {
        super(decoAni);
    }
    
    /*@Override
    public ZAnimal create(String name, int[] parameters, BodyComponent body)
    {
        decoAni.create(String name, int[] parameters, BodyComponent body);
        setStarving(decoAni);
        return decoAni.create(String name, int[] parameters, BodyComponent body);
    }
    */
    private void setStarving(Animal decoAni)
    {
        System.out.println("Starving");
        //decrease strength and movement speed
    }
}
