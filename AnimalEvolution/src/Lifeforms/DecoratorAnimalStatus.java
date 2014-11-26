package Lifeforms;
/**
 * DecoratorAnimalStatus implements Animal
 *      This decorator that is used to apply status effects to an Animal
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

import Lifeforms.Animal;
import java.awt.Shape;

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
    public int getSpriteX() {
        return decoAni.getSpriteX();
    }

    @Override
    public int getSpriteY() {
        return decoAni.getSpriteY();
    }
    
    @Override
    abstract public Object clone();

}
