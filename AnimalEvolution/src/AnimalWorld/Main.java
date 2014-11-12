package AnimalWorld;

import javax.swing.JFrame;

/**
 * Main
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Main
{
    public static void main(String[] args){
        
        Board<Organism> b = new Board<Organism>();
        GUIBoard gBoard = new GUIBoard(b);
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(gBoard);
        app.setSize(gBoard.getWidth(),gBoard.getHeight());
        app.setVisible(true);
        
        b.printTerrainComposition();

        System.out.println("\nAnimal World Game");
        System.out.println("-----------------");
        
        ZAnimal bear = (ZAnimal) AnimalFactorySingleton.getInstance().createAnimal("BEAR");
        //ZAnimal bear = ani1.create();
        
        ZAnimal rabbit = (ZAnimal) AnimalFactorySingleton.getInstance().createAnimal("RABBIT");
        //ZAnimal rabbit = ani2.create();
        
        ZAnimal bear2 = (ZAnimal) AnimalFactorySingleton.getInstance().createAnimal("BEAR");
        //ZAnimal bear2 = ani3.create();
        
        System.out.println("A "+bear.getName()+" has been created");
        System.out.println("A "+rabbit.getName()+" has been created");
        System.out.println("A "+bear2.getName()+" has been created");
    }
}
