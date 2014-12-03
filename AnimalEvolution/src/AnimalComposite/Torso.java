package AnimalComposite;

import AnimalComposite.CompositeComponent;
import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Torso extends CompositeComponent
 *     Torso is a body part of a composite Animal
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Torso extends CompositeComponent{
    public Torso(){
        super();
    }
    
    public Torso(Torso orig){
        this.children = orig.children;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Torso torso = new Torso();
        List<BodyComponent> parts = this.children;
        
        try{
            
            for(BodyComponent part : parts){
                if( part instanceof Arm ){
                    torso.addChild( new Arm() );
                } else if( part instanceof Leg){
                    torso.addChild( new Leg() );
                } else if( part instanceof Head){
                    torso.addChild( new Head() );
                }
            }
            
            return torso;
                   
        } catch (Exception e) {
            throw new CloneNotSupportedException("Clone Unsupported: Torso");
        }
    }
    
    @Override
    public void paintComponent(Graphics g, int size){
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(-size/2, -size/2, size, size);
        //g2d.rotate(Math.toRadians((double) (360.0/((double) (children.size()-1.0)/2.0))));
        for(BodyComponent b : children){
            if(!(b instanceof Head)){
                g2d.rotate(Math.toRadians((double) (360.0/(double) (children.size()))));
                add(b);
                b.paintComponent(g2d, size);
                b.setVisible(true);
            }
            else if(b instanceof Head){
                add(b);
                b.paintComponent(g2d, size);
                b.setVisible(true);
            }
        }
        g2d.rotate(Math.toRadians((double) (360.0/(double) (children.size()))));
        //g2d.rotate(-Math.toRadians((double) (360.0/((double) (children.size()-1.0)/2.0))));
    }
}
