/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalWorld;

import java.awt.Color;

/**
 *
 * @author Nate
 */
public class LandType {
    
    public static final LandType DIRT = new LandType(1);
    public static final LandType SHALLOW_WATER = new LandType(2);
    public static final LandType MEDIUM_WATER = new LandType(3);
    public static final LandType DEEP_WATER = new LandType(4);
    public static final LandType ROCK = new LandType(5);
    public static final LandType BOULDER = new LandType(6);
    public static final LandType LAVA = new LandType(7);
    
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
