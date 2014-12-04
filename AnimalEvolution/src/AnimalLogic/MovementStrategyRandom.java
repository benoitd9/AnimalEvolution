package AnimalLogic;

import Lifeforms.Animal;
import static java.lang.Math.abs;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * MovementStrategyRandom implements MovementStrategy
 *      The Animal will either Hunt or Forage
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class MovementStrategyRandom implements MovementStrategy
{
    /**
     * the animal will randomly either Hunt or Forage
     */
    @Override
    public void doMovement(AnimalBoard.Board board, Lifeforms.Animal a)
    {
        //System.out.println("RANDOM");
        Random rand = new Random();
        int z = rand.nextInt(10);
        if(z < 4)//hunt
        {
            System.out.println("The "+a.getName()+" is hunting.");

            int[][] seen = board.getVision(a);
            List<Lifeforms.Animal> aniList = board.getAnimalList();
            LinkedList<Lifeforms.Animal> seenAnimals = new LinkedList<>();
            Lifeforms.Animal target = null;
            int found = 0;

            for(Animal b: aniList)
            {
                for(int i = 0; i<seen.length; i++)
                {
                    if(b.getX() == seen[i][0] && b.getY() == seen[i][1])
                    {
                        //System.out.println("An Animal has been added "+b.getName()+" at " + seen[i][0] + ", " + seen[i][1]);
                        seenAnimals.add(b);
                        found++;
                    }
                }
            }

            if(found > 1)
            {
                if(seenAnimals.get(1) != null)
                    target = seenAnimals.get(1);

                int k = 1;

                /* while(seenAnimals.get(k) != null && target != null)
                {

                    System.out.println("cannible chekc");

                    Lifeforms.Animal temp = seenAnimals.get(k);
                    //check to see if the organism is an animal
                    if(a.getName().equals(target.getName()) && a.getIsCannibal())
                    {
                        target = temp;
                    }
                    else if(a.getName().equals(target.getName()))
                    {
                        target = temp;
                    }
                    k++;
                }
                        */

                if(target != null)
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

                    //Intiate a Fight in Possible

                    if(a.getX() == target.getX() && a.getY() == target.getY()){
                        Fight.fight(a,target,board);
                    }
                }
                else
                {
                    a.turnClockwise();
                }
            }
        }
        else if(z<11)//forage
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
        else//outcross
        {

        }
    }
}
