package AnimalWorld;

import AnimalCreation.AnimalFactorySingleton;
import Lifeforms.ConcreteAnimal;
import Lifeforms.Organism;
import AnimalBoard.Board;
import AnimalBoard.GUIBoard;
import javax.swing.JFrame;
import java.util.HashMap;
import java.util.Map;

/**
 * Main
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Main
{
    public static void main(String[] args){
        
        int numTurns = 10;
        Board.BoardBuilder<Organism> builder = new Board.BoardBuilder<Organism>();
        Board<Organism> b = builder.build();System.out.println("\nAnimal World Game");
        System.out.println("-----------------");
        
        ConcreteAnimal bear = (ConcreteAnimal) AnimalFactorySingleton.getInstance().createAnimal("BEAR: , , , , , , ");
        AnimalFactorySingleton.getInstance().addAnimal("Bear",bear);
        
        ConcreteAnimal rabbit = (ConcreteAnimal) AnimalFactorySingleton.getInstance().createAnimal("RABBIT: , , , , , , ");
        AnimalFactorySingleton.getInstance().addAnimal("Rabbit",rabbit);
        
        ConcreteAnimal kangaroo = (ConcreteAnimal) AnimalFactorySingleton.getInstance().createAnimal("Kangaroo: , , , , , , ");
        AnimalFactorySingleton.getInstance().addAnimal("Kangaroo",kangaroo);
        
        //test create animal with only name
        ConcreteAnimal walrus = (ConcreteAnimal) AnimalFactorySingleton.getInstance().createAnimal("Walrus");
        AnimalFactorySingleton.getInstance().addAnimal("Walrus",walrus);
        
        
        Map<String, ConcreteAnimal> animalList = AnimalFactorySingleton.getInstance().animalList;
        
        
        ConcreteAnimal bearCopy = animalList.get("Bear");
        AnimalFactorySingleton.getInstance().addAnimal("Bear2", bearCopy);

        
        System.out.println(animalList.toString());
        
        
        System.out.println("A "+bear.getName()+" has been created");
        System.out.println("A "+rabbit.getName()+" has been created");
        System.out.println("A "+kangaroo.getName()+" has been created");
        b.addAnimal(bear);
        b.addAnimal(rabbit);
        b.addAnimal(kangaroo);
        GUIBoard gBoard = new GUIBoard(b);
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(gBoard);
        app.setSize(gBoard.getWidth()+15,gBoard.getHeight()+35);
        app.setVisible(true);
        app.repaint();
        
        while(numTurns > 0){
            
            for(int i = 0; i < b.getAnimalList().size(); i++){
                
            }
            numTurns--;
        }
        
        b.printTerrainComposition();

        
    }
}
