package AnimalComposite;

import java.awt.Graphics;
/**
 * Leg extends CompositeLeafComponent
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Leg extends LeafComponent{
    public Leg(){
        super();
    }
    
    @Override
    public int getNumLimbs(){
        return 1;
    }
    
    @Override
    public Object clone() {
            return new Leg();
    }
    
    @Override
    public void paintComponent(Graphics g, int size){
        g.drawLine(0, 0, 0, -size);
    }
}