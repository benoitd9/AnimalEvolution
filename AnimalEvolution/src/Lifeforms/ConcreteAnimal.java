package Lifeforms;

import AnimalLogic.EatingStrategyHerbivore;
import AnimalLogic.TakeTurnTemplate;
import AnimalLogic.MovementStrategyRandom;
import AnimalLogic.EatingStrategy;
import AnimalLogic.MovementStrategyForage;
import AnimalLogic.EatingStrategyOmnivore;
import AnimalLogic.EatingStrategyCarnivore;
import AnimalLogic.MovementStrategyHunt;
import AnimalLogic.MovementStrategy;
import AnimalBoard.Direction;
import AnimalComposite.BodyComponent;

/**
 * ConcreteAnimal contains all of the attributes for the animals along with
 the methods to retrieve them
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

public class ConcreteAnimal implements Animal
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
    
    protected Direction dir;


    private ConcreteAnimal(String aniName, int x, int y, int eatStrategy, int moveStrategy, int cannibal, int moveSpeed, int initGender, BodyComponent initialBody) 
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
            moveStrat = new MovementStrategyHunt();
        } 
        else if (moveStrategy == 2) {
            moveStrat = new MovementStrategyForage();
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
        
        dir = Direction.NORTH;

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

    public void turnToFace(Direction d){
        dir = d;
    }
    
    public void turnClockwise(){
        if(dir == Direction.NORTH){
            dir = Direction.NORTHEAST;
        }
        else if(dir == Direction.NORTHEAST){
            dir = Direction.EAST;
        }
        else if(dir == Direction.EAST){
            dir = Direction.SOUTHEAST;
        }
        else if(dir == Direction.SOUTHEAST){
            dir = Direction.SOUTH;
        }
        else if(dir == Direction.SOUTH){
            dir = Direction.SOUTHWEST;
        }
        else if(dir == Direction.SOUTHWEST){
            dir = Direction.WEST;
        }
        else if(dir == Direction.WEST){
            dir = Direction.NORTHWEST;
        }
        else if(dir == Direction.NORTHWEST){
            dir = Direction.NORTH;
        }
    }
    
    public void turnCounterClockwise(){
        if(dir == Direction.NORTH){
            dir = Direction.NORTHWEST;
        }
        else if(dir == Direction.NORTHWEST){
            dir = Direction.WEST;
        }
        else if(dir == Direction.WEST){
            dir = Direction.SOUTHWEST;
        }
        else if(dir == Direction.SOUTHWEST){
            dir = Direction.SOUTH;
        }
        else if(dir == Direction.SOUTH){
            dir = Direction.SOUTHEAST;
        }
        else if(dir == Direction.SOUTHEAST){
            dir = Direction.EAST;
        }
        else if(dir == Direction.EAST){
            dir = Direction.NORTHEAST;
        }
        else if(dir == Direction.NORTHEAST){
            dir = Direction.NORTH;
        }
    }
    
    public Direction getDirection(){
        return dir;
    }
    
    public static ConcreteAnimal create(String name, int[] parameters, BodyComponent body){
        return new ConcreteAnimal(name,parameters[0],parameters[1],parameters[2],parameters[3],parameters[4],parameters[5],parameters[6],body);
    }
    
    public boolean equals(ConcreteAnimal o){
        if(o == null) return false;
        if(o == this) return true;
        if(!(o instanceof ConcreteAnimal)) return false;
        ConcreteAnimal otherAnimal = (ConcreteAnimal) o;
        if(this.getName().equals(o.getName()))
            return true;
        else return false;
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

    @Override
    public void setX(int x) {
        xPosition = x;
    }

    @Override
    public void setY(int y) {
        yPosition = y;
    }

    @Override
    public int getSpeed() {
        return movementSpeed;
    }

    @Override
    public boolean getIsCannibal() {
        return isCannibal;
    }
    
}