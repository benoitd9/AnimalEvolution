/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalComposite;

/**
 *
 * @author Nate
 */
public abstract class BodyComponentDecorator extends BodyComponent{
    
    private BodyComponent decoComp;
    
    public BodyComponentDecorator(BodyComponent decoComp){
        
    }
    
    public Object clone(){
        try{
            return decoComp.clone();
        }
        catch(Exception e){
            return null;
        }
    }
    
}
