package AnimalLogic;

import AnimalBoard.Board;
import static java.lang.Math.abs;
import java.util.List;
import java.util.Random;

/**
 * MovementStrategyForage implements MovementStrategy
      The animal can fly over rough terrain
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class MovementStrategyForage implements MovementStrategy
{
    /**
     * the animal will try to run away from a fight
     */
    @Override
    public void doMovement(Board board, Lifeforms.Animal a)
    {
        int[][] seen = board.getVision(a);
        List<Lifeforms.Animal> aniList = board.getAnimalList();
        List<Lifeforms.Plant> plantList = board.getPlantList();
        List<Lifeforms.Plant> seenPlants = null;
        Lifeforms.Plant target = null;
        
        for(int j = 0; j < plantList.size(); j++)
        {
            if(plantList.get(j) != null)
            {
                Lifeforms.Plant z = plantList.get(j);
                for(int i = 0; i < 41; i++)
                {
                    if(z.getX()==seen[j][0] && z.getY()==seen[j][1])
                    seenPlants.add(plantList.get(j));
                }
            }
        }
        if(seenPlants.get(0) != null)
            target = seenPlants.get(0);

        int run = 0;
        for(int i = 0; i<aniList.size();i++)
        {
            Lifeforms.Animal q = aniList.get(i);
            if(q.getX()==a.getX() && q.getY()==a.getY())
            {
                run = 1;
            }
        }

        //need to add a restriction to stop animals from leaving the board
        if(run == 1)
        {
            Random rand = new Random();
            int x = rand.nextInt(8);
            if(x <= 2)
            {
                a.setY(a.getY()+a.getSpeed());
            }
            else if(x <= 4)
            {
                a.setX(a.getX()+a.getSpeed());
            }
            else if(x <= 6)
            {
                a.setY(a.getY()-a.getSpeed());
            }
            else if(x <= 8)
            {
                a.setX(a.getX()-a.getSpeed());
            }
        }
        
        if(target != null && run == 0)
        {
            //starting with a simplified movement and will improve if time is available
            //move x
            if(abs(a.getX()-target.getX()) < a.getSpeed())
            {
                a.setX(target.getX());
            }
            else
            {
                if(a.getX()<target.getX())
                {
                    a.setX(a.getX()+a.getSpeed());
                }
                else
                {
                    a.setX(a.getX()-a.getSpeed());
                }
            }
            //move y
            if(abs(a.getY()-target.getY())<a.getSpeed())
            {
                a.setY(target.getY());
            }else{
                if(a.getY()<target.getY())
                {
                    a.setY(a.getY()+a.getSpeed());
                }
                else
                {
                    a.setY(a.getY()-a.getSpeed());
                }
            }
        }
        else if (run == 0)
        {
            a.turnClockwise();
        }
    }
}
