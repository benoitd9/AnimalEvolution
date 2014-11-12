package AnimalWorld;
/**
 * AnimalFactorySingleton creates Animals
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

import java.util.Random;

public class AnimalFactorySingleton 
{
    //create an object of SingleObject
    private static AnimalFactorySingleton instance = new AnimalFactorySingleton();
    private Random generator;

    //make the constructor private so that this class cannot be instantiated
    private AnimalFactorySingleton(){
        generator = new Random();
    }

    //Get the only object available
    public static AnimalFactorySingleton getInstance()
    {
        return instance;
    }
   
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
        
        return ZAnimal.create(name[0], attributes, body);
    }
    
    private int[] parse(String s){
        String[] splitTemp = s.split("[,]");
        String[] temp = new String[6];
        
        for(int i = 0; i < splitTemp.length; i++){
            temp[i] = splitTemp[i];
        }
        int[] returned = new int[7];
        
        for(int i = 0; i < returned.length; i++){
            if(!temp[i].equals(""))
                returned[i] = Integer.parseInt(temp[i]);
            else{
                if(i == 0)
                    returned[i] = generator.nextInt(100);
                else if(i == 1)
                    returned[i] = generator.nextInt(100);
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
