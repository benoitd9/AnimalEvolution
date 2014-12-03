package AnimalCreation;

import Lifeforms.ConcreteAnimal;
import Lifeforms.Animal;
import AnimalComposite.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * AnimalFactorySingleton creates Animals
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

public class AnimalFactorySingleton{
    

    public Map<String, Animal> animalList = new HashMap<String, Animal>();


    /**
     * create an object of SingleObject
     */
    private static AnimalFactorySingleton instance;
    
    /**
     * random number generator
     */
    private Random generator;

    /**
     * make the constructor private so that this class cannot be instantiated
     */
    private AnimalFactorySingleton(){
        generator = new Random();
    }

    /**
     * singleton animal factory
     * 
     * @return Get the only object available
     */
    public static AnimalFactorySingleton getInstance()
    {
        if(instance == null){
            instance = new AnimalFactorySingleton();
        }
        return instance;
    }
   
    /**
     * creates an animal
     * 
     * @param s string to decide which animal to make
     * @return the animal tied to the string s
     */
    public Animal createAnimal(String s){
        
        String[] name = s.split("[:]");
        
        int[] attributes = new int[7];
        if(name.length > 1){
           attributes = parse(name[1], true); 
        } else {
           String placeholder = ""; // must pass a string
           attributes = parse(placeholder, false);
        }
        
        Body body = makeBody();
        
        return ConcreteAnimal.create(name[0], attributes, body);
        
    }
    
    private Body makeBody(){
        Body body = new Body();
        Skeleton skele = new Skeleton();
        Torso torso = new Torso();
            
        try{
           for(int i = 0; i < 8; i++){
            skele.addChild(new Bone());
           }

            body.addChild(skele);
            body.addChild(torso);
            torso.addChild(new Head());
            torso.addChild(new Arm());
            torso.addChild(new Arm());
            torso.addChild(new Leg());
            torso.addChild(new Leg());
           
        } catch(Exception e){}
            
        return body;
    }
        
    public void addAnimal(String name, Animal a){
        this.animalList.put(name, a);
    }
    
    private int[] parse(String s, boolean knowLength){
        
        int numAttributes;
        String[] temp = new String[7];
        
        if( knowLength ){
            String[] splitTemp = s.split("[,]");
            
            numAttributes = splitTemp.length;
            
            for(int i = 0; i < numAttributes; i++){
                temp[i] = splitTemp[i];
            }
        } else{
            numAttributes = 7;
            
            for(int i = 0; i < numAttributes; i++){
                temp[i] = "";
            }
        }
            
        
        int[] returned = new int[7];
        
        for(int i = 0; i < returned.length; i++){  
            if(!(temp[i].equals(" ") || temp[i].equals(""))){
                returned[i] = Integer.parseInt(temp[i]);
            } else {
                if(i == 0)
                    returned[i] = generator.nextInt(50);
                else if(i == 1)
                    returned[i] = generator.nextInt(50);
                else if(i == 2)
                    returned[i] = generator.nextInt(3);
                else if(i == 3)
                    returned[3] = generator.nextInt(3);
                else if(i == 4)
                    returned[4] = generator.nextInt(1);
                else if(i == 5)
                    returned[5] = generator.nextInt(5)+1;
                else if(i == 6)
                    returned[6] = generator.nextInt(1);
            }
        }
        return returned;
    }
}
