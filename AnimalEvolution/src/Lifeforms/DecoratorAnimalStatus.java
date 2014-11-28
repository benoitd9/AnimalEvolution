package Lifeforms;
/**
 * DecoratorAnimalStatus implements Animal
 *      This decorator that is used to apply status effects to an Animal
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

import Lifeforms.Animal;
import AnimalBoard.Direction;

public abstract class DecoratorAnimalStatus implements Animal {
    protected Animal decoAni;
    
    public DecoratorAnimalStatus(Animal decoAni)
    {
        this.decoAni = decoAni;
    }
    
    @Override
    public int getX() {
        return decoAni.getX();
    }

    @Override
    public int getY() {
        return decoAni.getY();
    }
    
    @Override
    abstract public Object clone();
    
    @Override
    public Direction getDirection(){
        return decoAni.getDirection();
    }
    
    @Override
    public void turnClockwise(){
        decoAni.turnClockwise();
    }
    
    @Override
    public void turnCounterClockwise(){
        decoAni.turnCounterClockwise();
    }
    
    @Override
    public void turnToFace(Direction d){
        decoAni.turnToFace(d);
    }

}
