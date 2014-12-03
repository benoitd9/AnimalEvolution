package AnimalComposite;

import java.util.List;
import java.util.LinkedList;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * CompositeComponent implements BodyComponent
      CompositeComponent is a body part that contains other body parts
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public abstract class CompositeComponent extends BodyComponent{
    protected List<BodyComponent> children;
    
    public CompositeComponent(){
        children = new LinkedList<BodyComponent>();
    }
    
    public CompositeComponent(CompositeComponent orig){
        children = orig.getChildren();
    }
    
    private List<BodyComponent> getChildren(){
        return children;
    }
    
    @Override
    public int getBodySize(){
            
        int temp = 0;
            
        for(BodyComponent bc : children){
            temp += bc.getBodySize();
        }
        
        return temp;
    }
    
    @Override
    public int getNumLimbs(){
        int temp = 0;
        for(BodyComponent bc : children){
            temp += bc.getNumLimbs();
        }
        return temp;
    }
    
    /**
     * adds a child component to the body part
     * 
     * @param component the parent body part
     */
    @Override
    public void addChild(BodyComponent component){
        children.add(component);
    }
    
    /**
     * removes a child component to the body part
     * 
     * @param component the parent body part
     */
    @Override
    public void remove(BodyComponent component){
        children.remove(component);
    }
    
    /**
     * returns the specified child component from its parent body part
     * 
     * @param i the child component
     * @return the child component
     */
    @Override
    public BodyComponent getChild(int i){
        return children.get(i);
    }
    
    @Override
    public abstract Object clone() throws CloneNotSupportedException;
    
    
    public void paintComponent(Graphics g, int size){
        for(BodyComponent b: children){
            add((JComponent) b);
            b.paintComponent(g, size);
            b.setVisible(true);
        }
    }
}
