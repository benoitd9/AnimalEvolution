package AnimalComposite;

import java.awt.Graphics;
/**
 * Arm extends CompositeLeafComponent
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Arm extends LeafComponent{
    public Arm(){
        super();
    }
    
    @Override
    public int getNumLimbs(){
        return 1;
    }
    
    @Override
    public Object clone() {
        return new Arm();
    }
    
    public void paintComponent(Graphics g, int size){
        g.drawLine(0, 0, 0, -size);
    }
}
