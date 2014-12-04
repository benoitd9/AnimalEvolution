package AnimalLogic;

import Lifeforms.Animal;
import Lifeforms.Meat;
import AnimalBoard.Board;

/**
 * fight is conducted between two animals until one is killed
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Fight {
    public static void fight(Animal aniA, Animal aniB, Board b){
        int i = 0;
        System.out.println("Fight " + aniA.getName() + " vs " + aniB.getName());
        
        while(!aniA.isDead() || !aniB.isDead()){
            if(i % 2 == 0)
                aniB.damage(aniA.getDamage());
            else
                aniA.damage(aniB.getDamage());
            i++;
        }
        
        if(aniA.isDead()){
            b.addMeat(new Meat(aniA.getOrganismSize(), aniA.getX(), aniA.getY()));
            System.out.println("Animal " + aniA.getName() + "is dead");
        }
        if(aniB.isDead()){
            b.addMeat(new Meat(aniB.getOrganismSize(), aniB.getX(), aniB.getY()));
            System.out.println("Animal " + aniB.getName() + "is dead");
        }
        
    }
}
