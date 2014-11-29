/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalBoard;

/**
 *
 * @author Nate
 */
public class Direction {
    private int xDir;
    private int yDir;
    
    
    public static final Direction NORTH = new Direction(0,1);
    public static final Direction NORTHEAST = new Direction(1,1);
    public static final Direction EAST = new Direction(1,0);
    public static final Direction SOUTHEAST = new Direction(1,-1);
    public static final Direction SOUTH = new Direction(0,-1);
    public static final Direction SOUTHWEST = new Direction(-1,-1);
    public static final Direction WEST = new Direction(-1,0);
    public static final Direction NORTHWEST = new Direction(-1, 1);
    
    
    private Direction(int x, int y){
        xDir = x;
        yDir = y;
    }
    
    public int[] getDirection(){
        return new int[] {xDir,yDir};
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
