package Lifeforms;

import AnimalLogic.EatingStrategy;
import AnimalLogic.MovementStrategy;
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
    
    /* @Override
    public Object clone(){
        try{
            return new DecoratorAnimalStatusWellFed((Animal)decoAni.clone());
        }
        catch(CloneNotSupportedException e){
            return null;
        }
    } */

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

    @Override
    public void giveXP(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ate(int yum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reduceFullness() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MovementStrategy getMovement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EatingStrategy getEatStrat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}