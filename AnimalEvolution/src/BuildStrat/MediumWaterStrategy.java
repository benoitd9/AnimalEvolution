package BuildStrat;

import BuildStrat.BuildStrategy;

/**
 * Build strategy for medium water terrain type
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */
public class MediumWaterStrategy implements BuildStrategy{
    
    private final int[] probability; //field with 7 slots Dirt, Shallow Water
                                     //Medium Water, Deep Water, Rock, Boulder
                                     //Lava
    
    public MediumWaterStrategy(){
        probability = new int[]{0, 45, 50, 5, 0, 0, 0}; //represents the percent chances of getting each of the various LandTypes
    }
    
    @Override
    public int[] getProbabilities(){
        return probability;
    }
}
