package Lifeforms;

import Lifeforms.Animal;

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
    
    /**
     * the animal will have increased strength and movement speed
     *    after it just finished eating
     * 
     * @param decoAni the buffed up animal
     */
    private void setWellFed(Animal decoAni)
    {
        System.out.println("Just ate and is well fed");
        //increase Strength and movement speed
    }
    
    @Override
    public Object clone(){
        return new DecoratorAnimalStatusWellFed((Animal)decoAni.clone());
    }
}