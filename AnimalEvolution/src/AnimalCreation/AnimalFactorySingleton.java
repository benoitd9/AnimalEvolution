package AnimalCreation;

import Lifeforms.ConcreteAnimal;
import Lifeforms.Animal;
import AnimalComposite.Skeleton;
import AnimalComposite.Torso;
import AnimalComposite.Head;
import AnimalComposite.Leg;
import AnimalComposite.Arm;
import AnimalComposite.Body;
import AnimalComposite.Bone;
import AnimalComposite.BodyComponent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * AnimalFactorySingleton creates Animals
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

public class AnimalFactorySingleton{
    

    public Map<String, ConcreteAnimal> animalList = new HashMap<String, ConcreteAnimal>();


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
        int[] attributes = parse(name[1]);
        
        BodyComponent body = new Body();
        BodyComponent skele = new Skeleton();
        try{
            for(int i = 0; i < 5; i++){
                skele.add(new Bone());
            }
            
            body.add(skele);
            body.add(new Head());
            body.add(new Arm());
            body.add(new Arm());
            body.add(new Leg());
            body.add(new Leg());
            
        }
        catch(Exception e){}
        
        return ConcreteAnimal.create(name[0], attributes, body);
    }
        
    public void addAnimal(String name, ConcreteAnimal a){
        this.animalList.put(name, a);
    }
    
    private int[] parse(String s){
        String[] splitTemp = s.split("[,]");
        String[] temp = new String[7];
        
        for(int i = 0; i < splitTemp.length; i++){
            temp[i] = splitTemp[i];
        }
        int[] returned = new int[7];
        
        for(int i = 0; i < returned.length; i++){
            if(!(temp[i].equals(" ") || temp[i].equals("")))
                returned[i] = Integer.parseInt(temp[i]);
            else{
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
