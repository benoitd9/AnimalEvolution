package AnimalWorld;

import AnimalCreation.AnimalFactorySingleton;
import Lifeforms.ConcreteAnimal;
import Lifeforms.Animal;
import Lifeforms.Organism;
import AnimalBoard.Board;
import AnimalBoard.GUIBoard;
import Lifeforms.Meat;
import javax.swing.JFrame;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import FileReader.TextFileReader;
import AnimalLogic.TakeTurnNormal;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

/**
 * Main
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Main
{
    public static void main(String[] args){
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true"); // WHAT.. ??? WTF.
        //TextFileReader txt = new TextFileReader();
        //txt.read();
       // if(txt.strings() != null){
        //    for(String s: txt.strings()){
         //       ConcreteAnimal ani = (ConcreteAnimal) AnimalFactorySingleton.getInstance().createAnimal(s);
         //       AnimalFactorySingleton.getInstance().addAnimal(ani.getName(), ani);
         //   }
       // }
        int numTurns = 10;
        Board.BoardBuilder<Organism> builder = new Board.BoardBuilder<Organism>();
        Board<Organism> b = builder.build();System.out.println("\nAnimal World Game");
        System.out.println("-----------------");
        
        ConcreteAnimal bear = (ConcreteAnimal) AnimalFactorySingleton.getInstance().createAnimal("BEAR: , , , , , , ");
        AnimalFactorySingleton.getInstance().addAnimal("Bear",bear);
        
        ConcreteAnimal rabbit = (ConcreteAnimal) AnimalFactorySingleton.getInstance().createAnimal("RABBIT: , , , , , , ");
        AnimalFactorySingleton.getInstance().addAnimal("Rabbit",rabbit);
        
        ConcreteAnimal squirrel = (ConcreteAnimal) AnimalFactorySingleton.getInstance().createAnimal("SQUIRREL: , , , , , , ");
        AnimalFactorySingleton.getInstance().addAnimal("Squirel",squirrel);
        
        ConcreteAnimal kangaroo = (ConcreteAnimal) AnimalFactorySingleton.getInstance().createAnimal("KANGAROO: , , , , , , ");
        AnimalFactorySingleton.getInstance().addAnimal("Kangaroo",kangaroo);
        
        ConcreteAnimal wolf = (ConcreteAnimal) AnimalFactorySingleton.getInstance().createAnimal("WOLF: , , , , , , ");
        AnimalFactorySingleton.getInstance().addAnimal("Wolf",wolf);
        
        //test create animal with only name
        ConcreteAnimal walrus = (ConcreteAnimal) AnimalFactorySingleton.getInstance().createAnimal("Walrus");
        AnimalFactorySingleton.getInstance().addAnimal("Walrus",walrus);
        
        
        Map<String, Animal> animalList = AnimalFactorySingleton.getInstance().animalList;
        
        try {
            ConcreteAnimal bear2 = (ConcreteAnimal) bear.clone();
            AnimalFactorySingleton.getInstance().addAnimal("Bear2", bear2 );
            
            //Testin that Clone makes a new Bear object
            System.out.println();

            System.out.println("bear 1 xPosition: " + bear.getX() );
            System.out.println("bear 2 xPosition: " + bear.getX() );
            System.out.println("bear 1 is moving...");
            bear.setX(20);
            System.out.println("Bear 1 is now at xPosition: " + bear.getX() );
            System.out.println("Bear 2 is still back at xPosition: " + bear2.getX() );
            
            //b.addAnimal(bear2);
            
            System.out.println();
                    
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
        
        //System.out.println("A "+bear.getName()+" has been created");
        //System.out.println("A "+rabbit.getName()+" has been created");
        //System.out.println("A "+kangaroo.getName()+" has been created");
        b.addAnimal(bear);
        b.addAnimal(rabbit);
        b.addAnimal(kangaroo);
        b.addAnimal(wolf);
        b.addAnimal(squirrel);
        
        //JFrame app = new JFrame();
        //app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //app.add(b.getGUI());
        //app.setSize(b.getGUI().getWidth(),b.getGUI().getHeight()+20);
        //app.setVisible(true);
        //app.repaint();
        
        TakeTurnNormal turnTaker = new TakeTurnNormal();
        boolean cont = true;
        Scanner s = new Scanner(System.in);
        while(cont){
            
            //app.repaint();
            
            while(animalList.size() > 0){
               
                System.out.println("Sequence over press enter...");
                String slowDown =  s.nextLine();
                
                if(slowDown.equalsIgnoreCase("q")){
                    System.exit(0);
                } else {
                    LinkedList<Animal> deadAnimalList = new LinkedList<Animal>();
                    List<Animal> ani_list = b.getAnimalList();

                    Animal current;
                    
                    
                    for( int i = 0; i < ani_list.size(); i++ ){
                        current = ani_list.get(i);
                        
                        System.out.println(current.getName());
                        
                        if(!current.isDead()){
                            turnTaker.act(current, b);
                        }
                    }
                    for(Animal a: b.getAnimalList()){
                        if(a.isDead()){
                            deadAnimalList.add(a);

                        }
                    }
                    if(!deadAnimalList.isEmpty()){
                        for(Animal a: deadAnimalList){
                            b.remove(a);
                       }
                    }
                }
                
                
                
            }
            
            String str = s.next();
            if(str.equalsIgnoreCase("n")){
                cont = false;
            }
            
            numTurns--;
            
        }
        
        b.printTerrainComposition();
        
        
        b.addMeat(new Meat(2,2,2));
        //wolf.getEatStrat().eat(b, wolf);
        //bear.getEatStrat().eat(b, bear);
        
        
        System.out.println(rabbit.getCurrentHealth());
        System.out.println(bear.getCurrentHealth());

    }
}
