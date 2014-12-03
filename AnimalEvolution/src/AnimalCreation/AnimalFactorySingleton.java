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
        if(animalList.containsKey(name[0])){
            return new ConcreteAnimal((ConcreteAnimal) animalList.get(name[0]));
        }
        int[] attributes = new int[7];
        if(name.length > 1){
           attributes = parse(name[1], true); 
        } else {
           String placeholder = ""; // must pass a string
           attributes = parse(placeholder, false);
        }
        
        Body body = makeBody(attributes[6]);
        
        return ConcreteAnimal.create(name[0], attributes, body);
        
    }
    
    private Body makeBody(int size){
        Body body = new Body();
        Skeleton skele = new Skeleton();
        Torso torso = new Torso();
            
        try{
           for(int i = 0; i < size; i++){
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
                if(i == 0 || i == 1 || i == 4 || i == 6)
                    returned[i] = Integer.parseInt(temp[i]);
                else if(i == 2){
                    if(temp[i].equalsIgnoreCase("Herbivore")){
                        returned[i] = 2;
                    }
                    else if(temp[i].equalsIgnoreCase("Carnivore")){
                        returned[i] = 1;
                    }
                    else{
                        returned[i] = 0;
                    }
                }
                else if(i == 3){
                    if(temp[i].equalsIgnoreCase("True")){
                        returned[i] = 1;
                    }
                    else
                        returned[i] = 0;
                }
                else if(i == 5){
                    if(temp[i].equalsIgnoreCase("Male"))
                        returned[i] = 1;
                    else
                        returned[i] = 0;
                }
            } else {
                if(i == 0)
                    returned[0] = generator.nextInt(50); //xposition
                else if(i == 1)
                    returned[i] = generator.nextInt(50); //yposition
                else if(i == 2)
                    returned[i] = generator.nextInt(3); //Eat Strat
                else if(i == 3)
                    returned[i] = generator.nextInt(1); //isCannibal
                else if(i == 4)
                    returned[i] = generator.nextInt(5)+1; //MoveSpeed
                else if(i == 5)
                    returned[i] = generator.nextInt(1); //Gender
                else if(i == 6)
                    returned[i] = generator.nextInt(16) + 1; //size
            }
        }
        return returned;
    }
}
