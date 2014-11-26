package AnimalWorld;

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
        
        Board.BoardBuilder<Organism> builder = new Board.BoardBuilder<Organism>();
        Board<Organism> b = builder.build();System.out.println("\nAnimal World Game");
        System.out.println("-----------------");
        
        ZAnimal bear = (ZAnimal) AnimalFactorySingleton.getInstance().createAnimal("BEAR: , , , , , , ");
        AnimalFactorySingleton.getInstance().addAnimal("Bear",bear);
        //ZAnimal bear = ani1.create();
        
        ZAnimal rabbit = (ZAnimal) AnimalFactorySingleton.getInstance().createAnimal("RABBIT: , , , , , , ");
        AnimalFactorySingleton.getInstance().addAnimal("Rabbit",rabbit);
        //ZAnimal rabbit = ani2.create();
        
        ZAnimal kangaroo = (ZAnimal) AnimalFactorySingleton.getInstance().createAnimal("Kangaroo: , , , , , , ");
        AnimalFactorySingleton.getInstance().addAnimal("Kangaroo",kangaroo);
        //ZAnimal rabbit = ani2.create();
        
        
        Map<String, ZAnimal> animalList = AnimalFactorySingleton.getInstance().animalList;
        
        
        ZAnimal bearCopy = animalList.get("Bear");
        AnimalFactorySingleton.getInstance().addAnimal("Bear2",(ZAnimal)bear.clone());

        
        System.out.println(animalList.toString());
        
        
        System.out.println("A "+bear.getName()+" has been created");
        System.out.println("A "+rabbit.getName()+" has been created");
        System.out.println("A "+kangaroo.getName()+" has been created");
        b.addOrganism(bear);
        b.addOrganism(rabbit);
        b.addOrganism(kangaroo);
        GUIBoard gBoard = new GUIBoard(b);
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(gBoard);
        app.setSize(gBoard.getWidth()+15,gBoard.getHeight()+35);
        app.setVisible(true);
        
        b.printTerrainComposition();

        
        
        
    }
}
