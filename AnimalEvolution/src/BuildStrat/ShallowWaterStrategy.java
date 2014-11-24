/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuildStrat;

import BuildStrat.BuildStrategy;

/**
 *
 * @author Nate
 */
public class ShallowWaterStrategy implements BuildStrategy{
    
    private final int[] probability; //field with 7 slots Dirt, Shallow Water
                                     //Medium Water, Deep Water, Rock, Boulder
                                     //Lava
    
    public ShallowWaterStrategy(){
        probability = new int[]{55, 39, 5, 1, 0, 0, 0}; //represents the percent chances of getting each of the various LandTypes
    }
    
    @Override
    public int[] getProbabilities(){
        return probability;
    }
}
