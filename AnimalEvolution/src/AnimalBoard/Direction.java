package AnimalBoard;

/**
 * The direction that the animal is facing
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class Direction {
    private int xDir;
    private int yDir;
    private double rotation;
    
    
    public static final Direction NORTH = new Direction(0,-1);
    public static final Direction NORTHEAST = new Direction(1,-1);
    public static final Direction EAST = new Direction(1,0);
    public static final Direction SOUTHEAST = new Direction(1,1);
    public static final Direction SOUTH = new Direction(0,1);
    public static final Direction SOUTHWEST = new Direction(-1,1);
    public static final Direction WEST = new Direction(-1,0);
    public static final Direction NORTHWEST = new Direction(-1, -1);
    
    private Direction(int x, int y){
        xDir = x;
        yDir = y;
        if(x == 0){
            if(y == -1){
                rotation = 0.0;
            }
            if(y == 1){
                rotation = 180.0;
            }
        }
        else if(x == 1){
            if(y == -1){
                rotation = 45.0;
            }
            else if(y == 0){
                rotation = 90.0;
            }
            else if(y == -1){
                rotation = 135.0;
            }
        }
        else if(x == -1){
            if(y == -1){
                rotation = 315.0;
            }
            if(y == 0){
                rotation = 270.0;
            }
            if(y == 1){
                rotation = 225.0;
            }
        }
    }
    
    public int[] getDirection(){
        return new int[] {xDir,yDir};
    }
    
    public double getRotation(){
        return rotation;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(!(o instanceof Direction)) return false;
        Direction otherDirection = (Direction) o;
        if(this.getDirection()[0] == otherDirection.getDirection()[0] &&
           this.getDirection()[1] == otherDirection.getDirection()[1])
            return true;
        else return false;
    }
    
}
