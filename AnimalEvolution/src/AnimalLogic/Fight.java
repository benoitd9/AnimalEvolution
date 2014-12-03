/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalLogic;

import Lifeforms.Animal;
import Lifeforms.Meat;
import AnimalBoard.Board;

/**
 *
 * @author Holly
 */
public class Fight {
    public static void fight(Animal aniA, Animal aniB, Board b){
        int i = 0;
        while(!aniA.isDead() || !aniB.isDead()){
            if(i % 2 == 0)
                aniB.damage(aniA.getDamage());
            else
                aniA.damage(aniB.getDamage());
            i++;
        }
        
        if(aniA.isDead()){
            b.addMeat(new Meat(aniA.getOrganismSize(), aniA.getX(), aniA.getY()));
        }
        if(aniB.isDead()){
            b.addMeat(new Meat(aniB.getOrganismSize(), aniB.getX(), aniB.getY()));
        }
        
    }
}
