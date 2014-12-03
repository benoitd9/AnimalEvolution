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
import AnimalComposite.Body;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ConcreteAnimal contains all of the attributes for the animals along with
 the methods to retrieve them
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

public class ConcreteAnimal extends Animal{
    /**
     * experience points for leveling
     * animals gain xp every time they eat
     */
    protected int xp = 0;
    
    /**
     * how much food the animal has in its belly
     * decreases by 1 each turn
     */
    protected int fullness = 1;
   
    
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
    protected int size;
    
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
    protected Body body;
    
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
     * The direction this animal is currently facing
     */
    protected Direction dir;
    
    /**
     * The color this animal is
     */
    protected Color color;
    
    public ConcreteAnimal clone() throws CloneNotSupportedException{
        return new ConcreteAnimal(this);
    }
    
    public ConcreteAnimal(ConcreteAnimal orig){
        AnimalComposite.Body orig_body = orig.body;
        Body new_body = new AnimalComposite.Body();
        
        try {
            new_body = (Body) orig_body.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ConcreteAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //name = strName;
        body = new_body;
        xPosition = orig.xPosition;
        yPosition = orig.yPosition;
        eatStrat = orig.eatStrat;
        moveStrat = orig.moveStrat;
        isCannibal = orig.isCannibal;
        movementSpeed = orig.movementSpeed;
        gender = orig.gender;
        
        
    }

    private ConcreteAnimal(String aniName, int[] attr, Body initialBody) 
    {   
        name = aniName;
        
        //attributes
        int x = 0, y = 0, eatStrategy = 0, moveStrategy = 0, cannibal = 0, moveSpeed = 0, initGender = 0;
        
        for( int i = 0; i < attr.length; i++ ){
            switch(i){
                case 0:
                    x = attr[i];
                    xPosition = x;
                    break;
                case 1:
                    y = attr[i];
                    yPosition = y;
                    break;
                case 2:
                    eatStrategy = attr[i];
                    break;
                case 3:
                    moveStrategy = attr[i];
                    break;
                case 4:
                    cannibal = attr[i];
                    break;
                case 5:
                    moveSpeed = attr[i];
                    break;
                case 6:
                    initGender = attr[i];
                    break;
                default:
                    //attribute is undefined.
                    
            }
        }
        
        System.out.println("Animal Properties: ");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("eatingStrategy = " + eatStrategy);
        System.out.println("movementStrategy = " + moveStrategy);
        System.out.println("cannibal = " + cannibal);
        System.out.println("moveSpeed = " + moveSpeed);
        System.out.println("gender = " + initGender);
        System.out.println("-----------------------");
        
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
        
        size = body.getBodySize();
        
        damageCapacity = size/10;
        damageConstant = size/30;
        markedDamage = 0;

        movementSpeed = moveSpeed;
        
        gender = initGender;
        
        dir = Direction.NORTH;
        
        color = Color.GREEN;

    }

    /**
     * Checks to see if the animal ate this turn
     * 
     * @return returns 0 if it failed to eat this turn and 1 if it did eat this turn
     */
    @Override
    public void ate(int yum)
    {
        fullness = fullness + yum;
    }
    
    
    /**
     * reduced fullness by 1
     */
    @Override
    public void reduceFullness()
    {
        fullness--;
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
    
    public void giveXP(int x){
        xp = xp + x;
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
    
    public Color getColor(){
        return color;
    }
    
    public static ConcreteAnimal create(String name, int[] parameters, Body body){
        return new ConcreteAnimal(name,parameters,body);
    }
    
    public boolean equals(ConcreteAnimal o){
        if(o == null) return false;
        if(o == this) return true;
        if(!(o instanceof ConcreteAnimal)) return false;
        ConcreteAnimal otherAnimal = (ConcreteAnimal) o;
        if(this.getName().equals(otherAnimal.getName())){
            if(this.getX() == otherAnimal.getX() &&
               this.getY() == otherAnimal.getY()){
                if(this.getColor().equals(otherAnimal.getColor()))
                    return true;
                else return false;
            }
            else return false;
        }
        else return false;
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
    
    public MovementStrategy getMovement()
    {
        return moveStrat;
    }
    
    public EatingStrategy getEatStrat()
    {
        return eatStrat;
    }
    
    public void paintComponent(Graphics g){
        int limbs = body.getNumLimbs();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        g2d.translate(xPosition*16+28, yPosition*16+28);
        g2d.rotate(Math.toRadians(dir.getRotation()));
        
        add(body);
        body.paintComponent(g2d, size);
        body.setVisible(true);
        
        g2d.rotate(Math.toRadians(360.0 - dir.getRotation()));
        g2d.translate(-(xPosition*16+28), -(yPosition*16+28));
    }
    
}