package AnimalComposite;

import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Body extends CompositeComponent
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Body extends CompositeComponent{
    public Body(){
        super();
    }
    
    public Body(Body orig){
        this.children = orig.children;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Body bod = new Body();
        try{
            
            List<BodyComponent> childs = this.children;

            for(BodyComponent comps : childs){
                if( comps instanceof Torso){
                    bod.addChild( (BodyComponent) comps.clone() );
                } else if( comps instanceof Skeleton){
                    bod.addChild( (BodyComponent) comps.clone() );
                }
            }

        return bod;
            
        } catch (CloneNotSupportedException e){
            throw new CloneNotSupportedException("Clone Unsupported: Body");
        }
       
        
    }
    
}
