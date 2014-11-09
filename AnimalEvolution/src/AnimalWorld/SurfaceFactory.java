/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalWorld;

import java.util.Random;

/**
 *
 * @author Nate
 */
public class SurfaceFactory implements AnimalFactory{
    
    private Random generator;
    
    public SurfaceFactory(){
        generator = new Random();
    }
    
    
    /**
     * Takes a string in format name:xPos,yPos,initialMoveStrat,FeedingStrat,movespeed,gender
     * Returns an animal with those characteristics
     * 
     * @param s
     * @return an Animal
     */
    @Override
    public Animal createAnimal(String s){
        
        String[] name = s.split("[:]");
        int[] attributes = parse(name[1]);
        
        BodyComponent body = new Body(generator.nextInt(50)+10);
        try{
            body.add(new Head(body.getSize()/8));
            body.add(new Torso((body.getSize()/8)*7));
            body.add(new Skeleton(0));
            body.getChild(1).add(new Arm(body.getChild(1).getSize()/6));
            body.getChild(1).add(new Arm(body.getChild(1).getSize()/6));
            body.getChild(1).add(new Leg(body.getChild(1).getSize()/3));
            body.getChild(1).add(new Leg(body.getChild(1).getSize()/3));
        }
        catch(Exception e){}
        
        return new SurfaceDweller(name[0], attributes, body);
    }
    
    private int[] parse(String s){
        String[] splitTemp = s.split("[,]");
        String[] temp = new String[6];
        
        for(int i = 0; i < splitTemp.length; i++){
            temp[i] = splitTemp[i];
        }
        int[] returned = new int[6];
        
        for(int i = 0; i < returned.length; i++){
            if(!temp[i].equals(""))
                returned[i] = Integer.parseInt(temp[i]);
            else{
                if(i == 0)
                    returned[i] = generator.nextInt(500);
                else if(i == 1)
                    returned[i] = generator.nextInt(500);
                else if(i == 2)
                    returned[i] = generator.nextInt(3);
                else if(i == 3)
                    returned[3] = generator.nextInt(3);
                else if(i == 4)
                    returned[4] = generator.nextInt(5)+1;
                else if(i == 5)
                    returned[5] = generator.nextInt(1);
            }
        }
        return returned;
    }
}
