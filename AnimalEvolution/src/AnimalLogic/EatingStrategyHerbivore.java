package AnimalLogic;

import AnimalBoard.Board;
import Lifeforms.Animal;
import Lifeforms.Plant;
import java.util.List;

/**
 * EatinstStrategyHerbivore implements EatingStrategy
 *      The Animal will only eat plants
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class EatingStrategyHerbivore implements EatingStrategy
{
    /**
     * the animal try to eat plants at its coordinates
    */
    @Override
    public void eat(Board b, Animal a) 
    {
        List<Plant> mList = b.getPlantList();
        Plant target = null;
        int found = 0;
        for(Plant m: mList)
        {
            for(int i = 0; i<mList.size() && found == 0; i++)
            {
                if(m.getX() == a.getX() && m.getY() == a.getY())
                {
                    System.out.println("A Plant has been found at "+m.getY()+","+m.getX());
                    target = m;
                    found = 1;
                }
            }
        }
        
        if(found == 1)
        {
            a.giveXP(target.eatPlant());
            a.ate(target.getOrganismSize());
            b.remove(target);
        }
    }
}
