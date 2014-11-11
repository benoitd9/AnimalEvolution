package AnimalWorld;
/**
 * ZAnimal contains all of the attributes for the animals along with
 * the methods to retrieve them
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class ZAnimal
{
    protected EatingStrategy eatStrat;
    protected MovementStrategy moveStrat;
    protected TakeTurnTemplate turnStrat;
    
    //protected OutCrossing outCrossingStrat; temporarily disabled
    
    protected int size;  //the higher the number the bigger the animal
    protected int movementSpeed;   //number is how many squared that the animal can move
    protected int[] position;    //array of size 2, with 0 being the x coord and 1 being the y
    protected boolean isCannibal;  //0 is not a cannibal, 1 is a cannibal
    protected boolean canEatLarger; //0 can not eat larger creatures, 1 can eat larger
    protected String name;    //the name of this Animal
    protected int gender; //0 is a female, 1 is male
    protected CompBodyComponent body;
    protected int damageConstant;
    protected int damageCapacity;
    protected int markedDamage;

    public ZAnimal(String aniName, int xPosition, int yPosition, int eatStrategy, int moveStrategy, int moveSpeed, int cannibal, int gender/*, CompBodyComponent initialBody*/) 
    {
        name = aniName;
        position = new int[2];
        position[0] = xPosition;
        position[1] = yPosition;

        if (eatStrategy == 1) 
        {
             eatStrat = new EatingStrategyCarnivore();
        } else if (eatStrategy == 2) 
        {
             eatStrat = new EatingStrategyHerbivore();
        } else 
        {
             eatStrat = new EatingStrategyOmnivore();
        }
        
        if (moveStrategy == 1) 
        {
            moveStrat = new MovementStrategyFight();
        } else if (moveStrategy == 2) 
        {
            moveStrat = new MovementStrategyFlight();
        } else 
        {
            moveStrat = new MovementStrategyRandom();
        }

        if (cannibal == 1) 
        {
            isCannibal = true;
        } else 
        {
            isCannibal = false;
        }
        
        //body = initialBody; temporarily disabled
        //size = body.getSize();
        damageCapacity = size/10;
        damageConstant = size/30;
        markedDamage = 0;

        movementSpeed = moveSpeed;
        
        gender = gender;

    }


    int ate() //returns 0 if it did not eat and 1 if it did eat
    {
        return 0;
    }

    public int[] getPosition() {
        return position;
    }

    public int getX() {
        return position[0];
    }

    public int getY() {
        return position[1];
    }
    
    public String getName(){
        return name;
    }
    
    public boolean equals(ZAnimal o){
        if(o == null) return false;
        if(o == this) return true;
        if(!(o instanceof Animal)) return false;
        Animal otherAnimal = (Animal) o;
        if(this.getName().equals(o.getName()))
            return true;
        else return false;
    }
}