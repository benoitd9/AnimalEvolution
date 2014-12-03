package AnimalComposite;

import AnimalComposite.CompositeComponent;
import java.util.List;

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
    public int getSize(){
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
    public Object clone() {
        Skeleton skel = new Skeleton(this);
        List<BodyComponent> childs = skel.children;

        for(BodyComponent comps : childs){
            
            if (comps instanceof Arm) {
                skel.add(new Arm());
            } else if(comps instanceof Head){
                skel.add(new Head());
            } else if(comps instanceof Leg){
                skel.add(new Leg());
            } else if(comps instanceof Torso){
                skel.add(new Torso());
            }
             
        }

        return skel;
    }
}
