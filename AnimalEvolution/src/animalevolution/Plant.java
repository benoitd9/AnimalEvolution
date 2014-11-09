/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalWorld;

/**
 *
 * @author Nate
 */
public abstract class Plant implements Organism{
    protected int[] position;
    
    @Override
    public int[] getPosition(){
        return position;
    }
    
    @Override
    public int getX(){
        return position[0];
    }
    
    @Override
    public int getY(){
        return position[1];
    }
}
