package AnimalBoard;


import Lifeforms.Organism;
import Lifeforms.Animal;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;

/**
 * GUIBoard is the container for the board
 *
 * @author Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class GUIBoard extends JPanel{
    
    private Board board;
    
    public GUIBoard(Board b){
        super();
        setBackground(Color.WHITE);
        super.setSize(b.getWidth()*16+40,b.getHeight()*16+40);
        super.setVisible(true);
        board = b;
    }
    
    public void paintComponent(Graphics g){
        int width = getWidth();
        int height = getHeight();
        
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        
        for(int i = 0; i < board.getWidth(); i++){
            for(int j = 0; j < board.getHeight(); j++){
                g.setColor(board.getTile(i,j).getColor());
                g.fillRect(i*16+20, j*16+20, 16, 16);
            }
        }
        
        List<Animal> list = board.getAnimalList();
        for(Animal ani : list){
            ani.paintComponent(g);
            add(ani);
            ani.setVisible(true);
        }
    }
}
