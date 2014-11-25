package AnimalWorld;

import java.awt.Color;

/**
 * LandType is what each tile of the board is made of
 *
 * @author Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class LandType {
    
    /**
     * basic LandType where plants can grow
     */
    public static final LandType DIRT = new LandType(1);
    
    /**
     * the water is shallow enough for medium sized Animals to cross
     */
    public static final LandType SHALLOW_WATER = new LandType(2);
    
    /**
     * the water is so deep that only larger Animals can cross without swimming
     */
    public static final LandType MEDIUM_WATER = new LandType(3);
    
    /**
     * all animals must swim to cross
     */
    public static final LandType DEEP_WATER = new LandType(4);
    
    /**
     * plants can not grow here
     */
    public static final LandType ROCK = new LandType(5);
    
    /**
     * rough terrain, slows movement
     */
    public static final LandType BOULDER = new LandType(6);
    
    /**
     * dangerous terrain, will instantly cook any Animal that falls in
     */
    public static final LandType LAVA = new LandType(7);
    
    /**
     * stores the colors of the tiles as they are placed on the board
     */
    private Color color;
    
    private LandType(int c){
        
        if(c == 1){
            color = new Color(0xdeb887);
        }
        
        else if(c == 2){
            color = Color.BLUE;
        }
        
        else if(c == 3){
            color = new Color(0x0000B0);
        }
        
        else if(c == 4){
            color = new Color(0x000080);
        }
        
        else if(c == 5){
            color = new Color(0xa9a9a9);
        }
        
        else if(c == 6){
            color = Color.GRAY;
        }
        
        else if(c == 7){
            color = Color.RED;
        }
    }
    
    public Color getColor(){
        return color;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(!(o instanceof LandType)) return false;
        LandType otherLandType = (LandType) o;
        if(this.getColor().equals(otherLandType.getColor()))
            return true;
        else return false;
    }
    
}
