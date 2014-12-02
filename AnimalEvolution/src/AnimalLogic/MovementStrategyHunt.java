package AnimalLogic;

import AnimalBoard.Board;
import Lifeforms.Animal;
import static java.lang.Math.abs;
import java.util.Iterator;
import java.util.List;
import javax.swing.text.BadLocationException;

/**
 * MovementStrategyHunt implements MovementStrategy
      The animal will look for other Animals to kill and eat
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class MovementStrategyHunt implements MovementStrategy
{
    /**
     * the animal will move in to fight
     */
    @Override
    public void doMovement(Board board, Lifeforms.Animal a)
    {
        int[][] seen = board.getVision(a);
        List<Lifeforms.Animal> aniList = board.getAnimalList();
        List<Lifeforms.Animal> seenAnimals = null;
        Lifeforms.Animal target = null;
        /*
        for(int k = 0;aniList.get(k)!= null; k++)
        {
            Animal x = aniList.get(k);
            System.out.println(x.getName()+","+x.getX()+","+x.getY());
        }
        */
        
        System.out.println("Seen is "+seen.length);
        for(int j = 0; j<seen.length;j++)
            System.out.println(seen[j][0]+", "+seen[j][1]);
        
        
        for(Animal b: aniList)
        {
            for(int i = 0; i<seen.length; i++)
            {
                System.out.println("Currently trying to add "+b.getName());
                if(b.getX() == seen[i][0] && b.getY() == seen[i][1])
                {
                    System.out.println("An Animal has been added "+b.getName()+" at " + seen[i][0] + ", " + seen[i][1]);
                    seenAnimals.add(b);
                }
            }
        }
        /*
        for (Iterator<Animal> it = aniList.iterator(); it.hasNext();) 
        {
            Animal b = it.next();
            for(int i = 0; i<seen.length; i++)
            {
                if(b.getX() == seen[i][0] && b.getY() == seen[i][1])
                {
                    seenAnimals.add(b);
                }
            }
        }
        */
        /*
        for(int j = 0; j < aniList.size(); j++)
        {
            if(aniList.get(j) != null)
            {
                Lifeforms.Animal z = aniList.get(j);
                for(int i = 0; i < 41; i++)
                {
                    if(z.getX()==seen[j][0] && z.getY()==seen[j][1])
                    seenAnimals.add(aniList.get(j));
                }
            }
        }
        */
        //I want to specify a specific type of organism as the target here
        //animal or plant for example
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
