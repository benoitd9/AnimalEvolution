package AnimalComposite;

import java.awt.Graphics;
/**
 * Head extends CompositeComponent
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Head extends CompositeComponent {
    public Head(){
        super();
    }
    
    public Head(Head orig){
        this.children = orig.children;
    }
    
    @Override
    public int getNumLimbs(){
        return 1;
    }
    
    @Override
    public Object clone() {
            return new Head(this);
    }
    
    @Override
    public void paintComponent(Graphics g, int size){
        g.fillRect(-size/4, -size*3/4, size/2, size/2);
    }
}
