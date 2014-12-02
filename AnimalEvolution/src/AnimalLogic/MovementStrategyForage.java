package AnimalLogic;

import AnimalBoard.Board;
import Lifeforms.Animal;
import static java.lang.Math.abs;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * MovementStrategyForage implements MovementStrategy
      The animal will forage for plants to eat or run from predators
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class MovementStrategyForage implements MovementStrategy
{
    /**
     * the animal will forage for plants to eat or run from predators
     */
    @Override
    public void doMovement(Board board, Lifeforms.Animal a)
    {
        System.out.println("The "+a.getName()+" is foraging.");
        
        int[][] seen = board.getVision(a);
        List<Lifeforms.Animal> aniList = board.getAnimalList();
        List<Lifeforms.Plant> plantList = board.getPlantList();
        List<Lifeforms.Plant> seenPlants = new LinkedList<>();
        Lifeforms.Plant target = null;
        int found = 0;
        
        for(Lifeforms.Plant b: plantList)
        {
            for(int i = 0; i<seen.length; i++)
            {
                if(b.getX() == seen[i][0] && b.getY() == seen[i][1])
                {
                    //System.out.println("A plant has been added "+b.getName()+" at " + seen[i][0] + ", " + seen[i][1]);
                    seenPlants.add(b);
                    found = 1;
                }
            }
        }
        
        if(found == 1)
            target = seenPlants.get(0);

        int run = 0;
        //check if any enemies are in the same location
        for(Animal b: aniList)
        {
            if(!(b.getName().equals(a.getName())))
            {
                if(b.getX() == a.getX() && b.getY() == a.getY())
                {
                    run = 1;
                }
            }
        }

        //run away from danger
        //need to add a restriction to stop animals from leaving the board
        if(run == 1)
        {
            Random rand = new Random();
            int x = rand.nextInt(8);
            if(x <= 2)
            {
                if(a.getY()+a.getSpeed() < board.getHeight())
                    a.setY(a.getY()+a.getSpeed());
                else
                    a.setY(a.getY()-a.getSpeed());
            }
            else if(x <= 4)
            {
                if(a.getX()+a.getSpeed() < board.getHeight())
                    a.setY(a.getX()+a.getSpeed());
            }
            else if(x <= 6)
            {
                if(a.getY()-a.getSpeed() > board.getHeight())
                    a.setY(a.getY()-a.getSpeed());
            }
            else if(x <= 8)
            {
                if(a.getY()-a.getSpeed() > board.getHeight())
                    a.setY(a.getY()+a.getSpeed());
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
