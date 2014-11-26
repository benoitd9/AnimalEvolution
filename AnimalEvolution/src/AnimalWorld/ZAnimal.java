package AnimalWorld;
/**
 * ZAnimal contains all of the attributes for the animals along with
 * the methods to retrieve them
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

public class ZAnimal implements Animal
{
    /**
     * what the animal eats: Herbivore, Carnivore, Omnivore
     */
    protected EatingStrategy eatStrat;
    
    /**
     * how the animal moves: Fight, Flight, Burrow, Random
     */
    protected MovementStrategy moveStrat;
    
    /**
     * how the animal takes its turn
     */
    protected TakeTurnTemplate turnStrat;
    
    //protected OutCrossing outCrossingStrat; temporarily disabled
    
    /**
     * the higher the number the bigger the animal
     */
    protected int size;  //the higher the number the bigger the animal
    
    /**
     * number is how many squared that the animal can move
     */
    protected int movementSpeed;
    
    /**
     * x coordinate of the animal
     */
    protected int xPosition;
    
    /**
     * y coordinate of the animal
     */
    protected int yPosition;
    
    /**
     * 0 is not a cannibal, 1 is a cannibal
     */
    protected boolean isCannibal;  //0 is not a cannibal, 1 is a cannibal
    
    /**
     * 0 can not eat larger creatures, 1 can eat larger
     */
    protected boolean canEatLarger; //0 can not eat larger creatures, 1 can eat larger
    
    /**
     * the name of this Animal
     */
    protected String name;    //the name of this Animal
    
    /**
     * 0 is a female, 1 is male
     */
    protected int gender; //0 is a female, 1 is male
    
    /**
     * the body parts that make up the Animal
     */
    protected BodyComponent body;
    
    /**
     * how much damage the Animal can deal
     */
    protected int damageConstant;
    
    /**
     * how much damage the Animal can take
     */
    protected int damageCapacity;
    
    /**
     * how much damage the Animal has taken
     */
    protected int markedDamage;
    
    /**
     * x coordinate of the sprite of the animal
     */
    protected int spriteX;
    
    /**
     * y coordinate of the sprite of the animal
     */
    protected int spriteY;

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

    /**
     * Checks to see if the animal ate this turn
     * 
     * @return returns 0 if it failed to eat this turn and 1 if it did eat this turn
     */
    int ate() //returns 0 if it did not eat and 1 if it did eat
    {
        return 0;
    }
    
    @Override
    public int getX() {
        return xPosition;
    }

    @Override
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
    
    @Override
    public int getSpriteX(){
        return 0;
    }
    
    @Override
    public int getSpriteY(){
        return 5;
    }
    
    /**
     * creates a clone of the animal
     * 
     * @return the clone of the animal
     */
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.getMessage();
            throw new RuntimeException();
        }
    }
}