package AnimalLogic;

import AnimalBoard.Board;
import Lifeforms.Animal;
import Lifeforms.Meat;
import Lifeforms.Plant;
import java.util.List;
import java.util.Random;

/**
 * EatinstStrategyOmnivore implements EatingStrategy
 *      The Animal will eat Plants and Animal meat
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class EatingStrategyOmnivore implements EatingStrategy
{
    /**
     * the animal will try to eat either plants or animal meat
     */
    @Override
    public void eat(Board b, Animal a) 
    {
        Random rand = new Random();
        int x = rand.nextInt(10);
        if(x < 5)
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
                a.ate(target.getOrganismSize());
                b.remove(target);
            }

        }
        else
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
}
