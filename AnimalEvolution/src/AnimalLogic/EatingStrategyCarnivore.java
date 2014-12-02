package AnimalLogic;

import java.util.List;
import AnimalBoard.Board;
import Lifeforms.Meat;
import Lifeforms.Animal;

/**
 * EatinstStrategyCarnivore implements EatingStrategy
 *      The Animal will only eat Meat
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class EatingStrategyCarnivore implements EatingStrategy
{
    /**
     * the animal will try to eat Meat at its coordinate
     */
    @Override
    public void eat(Board b, Animal a)
    {
        List<Meat> mList = b.getMeatList();
        Meat target = null;
        int found = 0;
        for(Meat m: mList)
        {
            for(int i = 0; i<mList.size() && found == 0; i++)
            {
                if(m.getX() == a.getX() && m.getY() == a.getY())
                {
                    System.out.println("A Meat has been found at "+m.getY()+","+m.getX());
                    target = m;
                    found = 1;
                }
            }
        }
        
        if(found == 1)
        {
            a.giveXP(target.eatMeat());
            a.ate(1);
        }
        
    }
}