package Lifeforms;

import Lifeforms.Animal;

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
    
    /**
     * the animal has not eaten in a while and will have 
     *     decreased movement speed
     * 
     * @param decoAni the debuffed animal
     */
    private void setStarving(Animal decoAni)
    {
        System.out.println("Starving");
        //decrease strength and movement speed
    }
    
    @Override
    public Object clone(){
        return new DecoratorAnimalStatusStarving((Animal)decoAni.clone());
    }

    @Override
    public int getSpeed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setX(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setY(int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getIsCannibal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
