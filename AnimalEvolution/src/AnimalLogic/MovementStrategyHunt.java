package AnimalLogic;

import AnimalBoard.Board;
import Lifeforms.Animal;
import static java.lang.Math.abs;
import java.util.LinkedList;
import java.util.List;

/**
 * MovementStrategyHunt implements MovementStrategy
      The animal will look for other Animals to kill and eat
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class MovementStrategyHunt implements MovementStrategy
{
    /**
     * the animal will Hunt for other animals
     */
    @Override
    public void doMovement(Board board, Lifeforms.Animal a)
    {
        System.out.println("The "+a.getName()+" is hunting.");
        
        int[][] seen = board.getVision(a);
        List<Lifeforms.Animal> aniList = board.getAnimalList();
        LinkedList<Lifeforms.Animal> seenAnimals = new LinkedList<>();
        Lifeforms.Animal target = null;
        int found = 0;
        
        //turning testing
        /*
        for(int k = 0;aniList.get(k)!= null; k++)
        {
            Animal x = aniList.get(k);
            System.out.println(x.getName()+","+x.getX()+","+x.getY());
        }
        */
        /*
        System.out.println("Seen is "+seen.length);
        for(int j = 0; j<seen.length;j++)
            System.out.println(seen[j][0]+", "+seen[j][1]);
        
        a.turnClockwise();
        
        System.out.println("Seen is "+seen.length);
        for(int j = 0; j<seen.length;j++)
            System.out.println(seen[j][0]+", "+seen[j][1]);
        */
        
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

        if(found > 0)
            target = seenAnimals.get(1);
        
        int k = 0;
        while(seenAnimals.get(k) != null && target == null)
        {
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
        }
        else
        {
            a.turnClockwise();
        }
    }
}
