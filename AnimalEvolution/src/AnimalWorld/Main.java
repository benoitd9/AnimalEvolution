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

    }
}
