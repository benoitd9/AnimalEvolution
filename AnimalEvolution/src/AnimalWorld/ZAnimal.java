package AnimalWorld;
/**
 * ZAnimal contains all of the attributes for the animals along with
 * the methods to retrieve them
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class ZAnimal implements Animal, Decoratable
{
    protected EatingStrategy eatStrat;
    protected MovementStrategy moveStrat;
    protected TakeTurnTemplate turnStrat;
    
    //protected OutCrossing outCrossingStrat; temporarily disabled
    
    protected int size;  //the higher the number the bigger the animal
    protected int movementSpeed;   //number is how many squared that the animal can move
    protected int xPosition;    
    protected int yPosition;
    protected boolean isCannibal;  //0 is not a cannibal, 1 is a cannibal
    protected boolean canEatLarger; //0 can not eat larger creatures, 1 can eat larger
    protected String name;    //the name of this Animal
    protected int gender; //0 is a female, 1 is male
    protected BodyComponent body;
    protected int damageConstant;
    protected int damageCapacity;
    protected int markedDamage;

    private ZAnimal(String aniName, int x, int y, int eatStrategy, int moveStrategy, int cannibal, int moveSpeed, int initGender, BodyComponent initialBody) 
    {
        name = aniName;
        xPosition = x;
        yPosition = y;

        if (eatStrategy == 1) {
            eatStrat = new EatingStrategyCarnivore();
        } 
        else if (eatStrategy == 2){
            eatStrat = new EatingStrategyHerbivore();
        } 
        else {
            eatStrat = new EatingStrategyOmnivore();
        }
        
        if (moveStrategy == 1) {
            moveStrat = new MovementStrategyFight();
        } 
        else if (moveStrategy == 2) {
            moveStrat = new MovementStrategyFlight();
        } 
        else {
            moveStrat = new MovementStrategyRandom();
        }

        if (cannibal == 1) 
            isCannibal = true;
        else 
            isCannibal = false;
        
        body = initialBody;
        size = body.getSize();
        damageCapacity = size/10;
        damageConstant = size/30;
        markedDamage = 0;

        movementSpeed = moveSpeed;
        
        gender = initGender;

    }


    int ate() //returns 0 if it did not eat and 1 if it did eat
    {
        return 0;
    }

    public int getX() {
        return xPosition;
    }

    public int getY() {
        return yPosition;
    }
    
    public String getName(){
        return name;
    }
    
    public static ZAnimal create(String name, int[] parameters, BodyComponent body){
        return new ZAnimal(name,parameters[0],parameters[1],parameters[2],parameters[3],parameters[4],parameters[5],parameters[6],body);
    }
    
    public boolean equals(ZAnimal o){
        if(o == null) return false;
        if(o == this) return true;
        if(!(o instanceof ZAnimal)) return false;
        ZAnimal otherAnimal = (ZAnimal) o;
        if(this.getName().equals(o.getName()))
            return true;
        else return false;
    }
}