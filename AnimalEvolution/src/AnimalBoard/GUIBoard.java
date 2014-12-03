package AnimalBoard;


import Lifeforms.Organism;
import Lifeforms.Animal;
import Lifeforms.Plant;
import Lifeforms.Meat;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    
    public void update(int x1, int y1, int x2, int y2){
        repaint(x1,y1,x2,y2);
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
        for(int i = 0; i < 5000; i++)
            System.out.print("");
        
        List<Plant> pList = board.getPlantList();
        for(Plant p: pList){
            add(p);
            p.repaint();
            p.setVisible(true);
        }
        
        for(int i = 0; i < 5000; i++)
            System.out.print("");
        
        List<Meat> mList = board.getMeatList();
        for(Meat m: mList){
            add(m);
            m.repaint();
            m.setVisible(true);
        }
        
        for(int i = 0; i < 5000; i++)
            System.out.print("");
        
        List<Animal> alist = board.getAnimalList();
        for(Animal ani : alist){
            add(ani);
            ani.repaint();
            ani.setVisible(true);
        }
        
        
    }
}
