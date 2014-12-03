package AnimalComposite;

import AnimalComposite.CompositeComponent;
import java.util.List;
import java.awt.Graphics;

/**
 * Skeleton extends CompositeComponent
 *     it is made up of bones
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Skeleton extends CompositeComponent{
    public Skeleton(){
        super();
    }
    
    public Skeleton(Skeleton orig){
        this.children = orig.children;
    }
    
    @Override
    public int getBodySize(){
        int temp = 0;
        for(BodyComponent bc : children){
            temp += 1;
        }
        return temp;
    }
    
    @Override
    public int getNumLimbs(){
        return 0;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Skeleton skele = new Skeleton();
        
        try{
            List<BodyComponent> bones = this.children;

            for(BodyComponent bone : bones){
                if( bone instanceof Bone){
                      skele.addChild( new Bone() );
                }
            }

            return skele; 
            
        } catch (Exception e){
            throw new CloneNotSupportedException("Clone Unsupported: Skeleton");
        }
         
 
    }
    
    @Override
    public void paintComponent(Graphics g, int size){
        
    }
 
       
}
