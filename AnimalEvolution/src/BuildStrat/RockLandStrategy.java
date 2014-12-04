package BuildStrat;

import BuildStrat.BuildStrategy;

/**
 * Build strategy for rock terrain type
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class RockLandStrategy implements BuildStrategy{
    
    private final int[] probability; //field with 7 slots Dirt, Shallow Water
                                     //Medium Water, Deep Water, Rock, Boulder
                                     //Lava
    
    public RockLandStrategy(){
        probability = new int[]{46, 0, 0, 0, 45, 4, 5}; //represents the percent chances of getting each of the various LandTypes
    }
    
    @Override
    public int[] getProbabilities(){
        return probability;
    }
}
