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
public class SurfaceFactory implements AnimalFactory{
    
    public SurfaceFactory(){
    }
    
    
    /**
     * Takes a string in format name:xPos,yPos,initialMoveStrat,FeedingStrat,size,movespeed
     * Returns an animal with those characteristics
     * 
     * @param s
     * @return an Animal
     */
    @Override
    public Animal createAnimal(String s){
        
        String[] name = s.split("[:]");
        int[] attributes = parse(name[1]);
        
        return new SurfaceDweller(name[0], attributes);
    }
    
    private int[] parse(String s){
        String[] temp = s.split("[,]");
        
        int[] returned = new int[temp.length];
        
        for(int i = 0; i < temp.length; i++){
            returned[i] = Integer.parseInt(temp[i]);
        }
        return returned;
    }
}
