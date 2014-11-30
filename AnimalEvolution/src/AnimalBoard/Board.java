package AnimalBoard;

import Lifeforms.Organism;
import Lifeforms.Animal;
import Lifeforms.Plant;
import BuildStrat.BasicLandStrategy;
import BuildStrat.ShallowWaterStrategy;
import BuildStrat.MediumWaterStrategy;
import BuildStrat.RockLandStrategy;
import BuildStrat.DeepWaterStrategy;
import BuildStrat.BuildStrategy;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import javax.swing.text.BadLocationException;

/**
 * Board is where the game take place
 * 
 * @author  Thomas Ashborn, David Benoit, Kevin Patraw, Nathan Plante
 */

public class Board<T extends Organism>{
    
    private List<T> organismList; //List of all current organisms on the board
    private List<T>[][] organisms; //2d array of lists of all organisms on each tile on the board
    private List<Animal> animalList; //list of all animals on the board
    private List<Plant> plantList; //list of all plants of the board
    private LandType[][] landscape;  //2d array of all the tiles on the board
    private Random generator;  //random seed
    
    private Board(BoardBuilder builder){
        organismList = builder.buildOrganismList();
        organisms = builder.buildOrganismsBoard();
        landscape = builder.buildLandscape();
    }
    
    /**
     * safely adds an organism to the board. if no empty location can be found,
     * prints the exception message and does nothing.
     * 
     * @param org 
     */
    
    public void addOrganism(T org){
        try{
            int[] tempLoc = findClosestEmpty(org.getX(), org.getY());
            
            if( organisms[tempLoc[0]][tempLoc[1]] != null ){
                organisms[tempLoc[0]][tempLoc[1]].add(org);
                organismList.add(org);
            }
            
        }
        catch(BadLocationException e){
            System.out.println("Bad Location Exception:" + e.getMessage());
        }
    }
    
    /**
     * takes a x,y coordinate and returns the x,y coordinates of the location
     * that contains the desired organism. if null is entered for org it returns
     * the nearest location that has an empty list. If no such location can be 
     * found, it throws BadLocationException
     * 
     * @param org
     * @param x
     * @param y
     * @return {x, y}
     * @throws BadLocationException 
     */
    
    public int[] findClosest(T org, int x, int y) throws BadLocationException{
        if(organisms[x][y].contains(org))
            return new int[]{x,y};
        
        for(int i = 1; i <= organisms.length; i++){
            if(x <= i){
                if(y <= i){            
                    if(organisms[x + i][y].contains(org))
                        return new int[]{x + i,y};
                    
                    else if(organisms[x + i][y + i].contains(org))
                        return new int[]{x + i,y + i};
                    
                    else if(organisms[x][y + i].contains(org))
                        return new int[]{x,y+i};
                }
                
                else if(y >= (organisms[0].length-i)){
                    if(organisms[x][y - i].contains(org))
                        return new int[]{x,y-i};
        
                    else if(organisms[x + i][y].contains(org))
                        return new int[]{x + i,y};
                    
                    else if(organisms[x + i][y - i].contains(org))
                        return new int[]{x + i, y - i};
                    
                }
                
                else{
                    if(organisms[x][y-i].contains(org))
                        return new int[]{x,y-i};
                    
                    if(organisms[x+i][y-i].contains(org))
                        return new int[]{x+i,y-i};
                    
                    if(organisms[x+i][y].contains(org))
                        return new int[]{x+i,y};
                    
                    if(organisms[x][y+i].contains(org))
                        return new int[]{x,y+i};
                    
                    if(organisms[x+i][y+i].contains(org))
                        return new int[]{x+i,y+i};
                }
            }
            
            else if(y <= i){
                if(x >= (organisms.length-i)){
                    if(organisms[x-i][y].contains(org))
                        return new int[]{x-i,y};
        
                    else if(organisms[x][y+i].contains(org))
                        return new int[]{x,y+i};
                    
                    else if(organisms[x - i][y + i].contains(org))
                        return new int[]{x - i, y + i};
                }
                
                else{
                    if(organisms[x - i][y].contains(org))
                        return new int[]{x - i,y};
                    
                    if(organisms[x-i][y+i].contains(org))
                        return new int[]{x-i,y+i};
                    
                    if(organisms[x+i][y].contains(org))
                        return new int[]{x+i,y};
                    
                    if(organisms[x][y+i].contains(org))
                        return new int[]{x,y+i};
                    
                    if(organisms[x+i][y+i].contains(org))
                        return new int[]{x+i,y+i};
                }
            }
            
            else if(x >= (organisms.length - i)){
                if(y >= (organisms[0].length - i)){
                    if(organisms[x-i][y].contains(org))
                        return new int[]{x-i,y};
                    
                    else if(organisms[x-i][y-i].contains(org))
                        return new int[]{x-i,y-i};
                    
                    else if(organisms[x][y-i].contains(org))
                        return new int[]{x,y-i};
                    
                }
                
                else{
                    if(organisms[x][y+i].contains(org))
                        return new int[]{x,y+i};
                    else if(organisms[x-i][y+i].contains(org))
                        return new int[]{x-i,y+i};
                    else if(organisms[x-i][y].contains(org))
                        return new int[]{x-i,y};
                    else if(organisms[x-i][y-i].contains(org))
                        return new int[]{x-i,y-i};
                    else if(organisms[x][y-i].contains(org))
                        return new int[]{x,y-i};
                }
            }
            
            else if(y >= (organisms[0].length - i)){
                if(organisms[x+i][y].contains(org))
                    return new int[]{x+i,y};
                else if(organisms[x+i][y-i].contains(org))
                    return new int[]{x+i,y-i};
                else if(organisms[x][y-i].contains(org))
                    return new int[]{x,y-i};
                else if(organisms[x-i][y-i].contains(org))
                    return new int[]{x-i,y-i};
                else if(organisms[x-i][y].contains(org))
                    return new int[]{x-i,y};
            }
            else{
                if(organisms[x][y+i].contains(org))
                    return new int[]{x,y+i};
                else if(organisms[x-i][y+i].contains(org))
                    return new int[]{x-i,y+i};
                else if(organisms[x-i][y].contains(org))
                    return new int[]{x-i,y};
                else if(organisms[x-i][y-i].contains(org))
                    return new int[]{x-i,y};
                else if(organisms[x][y-i].contains(org))
                    return new int[]{x,y-i};
                else if(organisms[x+i][y-i].contains(org))
                    return new int[]{x+i,y-i};
                else if(organisms[x+i][y].contains(org))
                    return new int[]{x+i,y};
                else if(organisms[x+i][y+i].contains(org))
                    return new int[]{x+i,y+i};
            }
        }
        throw new BadLocationException("Your animal is bad and should feel bad", 0);
    }
    
    public int[] findClosestEmpty(int x, int y) throws BadLocationException{
        if(organisms[x][y] != null){
            
            if(organisms[x][y].isEmpty())
                return new int[]{x,y};
        
        
            for(int i = 1; i <= organisms.length; i++){
                if(x <= i){
                    if(y <= i){            
                        if(organisms[x + i][y].isEmpty())
                            return new int[]{x + i,y};

                        else if(organisms[x + i][y + i].isEmpty())
                            return new int[]{x + i,y + i};

                        else if(organisms[x][y + i].isEmpty())
                            return new int[]{x,y+i};
                    }

                    else if(y >= (organisms[0].length-i)){
                        if(organisms[x][y - i].isEmpty())
                            return new int[]{x,y-i};

                        else if(organisms[x + i][y].isEmpty())
                            return new int[]{x + i,y};

                        else if(organisms[x + i][y - i].isEmpty())
                            return new int[]{x + i, y - i};

                    }

                    else{
                        if(organisms[x][y-i].isEmpty())
                            return new int[]{x,y-i};

                        if(organisms[x+i][y-i].isEmpty())
                            return new int[]{x+i,y-i};

                        if(organisms[x+i][y].isEmpty())
                            return new int[]{x+i,y};

                        if(organisms[x][y+i].isEmpty())
                            return new int[]{x,y+i};

                        if(organisms[x+i][y+i].isEmpty())
                            return new int[]{x+i,y+i};
                    }
                }

                else if(y <= i){
                    if(x >= (organisms.length-i)){
                        if(organisms[x-i][y].isEmpty())
                            return new int[]{x-i,y};

                        else if(organisms[x][y+i].isEmpty())
                            return new int[]{x,y+i};

                        else if(organisms[x - i][y + i].isEmpty())
                            return new int[]{x - i, y + i};
                    }

                    else{
                        if(organisms[x - i][y].isEmpty())
                            return new int[]{x - i,y};

                        if(organisms[x-i][y+i].isEmpty())
                            return new int[]{x-i,y+i};

                        if(organisms[x+i][y].isEmpty())
                            return new int[]{x+i,y};

                        if(organisms[x][y+i].isEmpty())
                            return new int[]{x,y+i};

                        if(organisms[x+i][y+i].isEmpty())
                            return new int[]{x+i,y+i};
                    }
                }

                else if(x >= (organisms.length - i)){
                    if(y >= (organisms[0].length - i)){
                        if(organisms[x-i][y].isEmpty())
                            return new int[]{x-i,y};

                        else if(organisms[x-i][y-i].isEmpty())
                            return new int[]{x-i,y-i};

                        else if(organisms[x][y-i].isEmpty())
                            return new int[]{x,y-i};

                    }

                    else{
                        if(organisms[x][y+i].isEmpty())
                            return new int[]{x,y+i};
                        else if(organisms[x-i][y+i].isEmpty())
                            return new int[]{x-i,y+i};
                        else if(organisms[x-i][y].isEmpty())
                            return new int[]{x-i,y};
                        else if(organisms[x-i][y-i].isEmpty())
                            return new int[]{x-i,y-i};
                        else if(organisms[x][y-i].isEmpty())
                            return new int[]{x,y-i};
                    }
                }

                else if(y >= (organisms[0].length - i)){
                    if(organisms[x+i][y].isEmpty())
                        return new int[]{x+i,y};
                    else if(organisms[x+i][y-i].isEmpty())
                        return new int[]{x+i,y-i};
                    else if(organisms[x][y-i].isEmpty())
                        return new int[]{x,y-i};
                    else if(organisms[x-i][y-i].isEmpty())
                        return new int[]{x-i,y-i};
                    else if(organisms[x-i][y].isEmpty())
                        return new int[]{x-i,y};
                }
                else{
                    if(organisms[x][y+i].isEmpty())
                        return new int[]{x,y+i};
                    else if(organisms[x-i][y+i].isEmpty())
                        return new int[]{x-i,y+i};
                    else if(organisms[x-i][y].isEmpty())
                        return new int[]{x-i,y};
                    else if(organisms[x-i][y-i].isEmpty())
                        return new int[]{x-i,y};
                    else if(organisms[x][y-i].isEmpty())
                        return new int[]{x,y-i};
                    else if(organisms[x+i][y-i].isEmpty())
                        return new int[]{x+i,y-i};
                    else if(organisms[x+i][y].isEmpty())
                        return new int[]{x+i,y};
                    else if(organisms[x+i][y+i].isEmpty())
                        return new int[]{x+i,y+i};
                }
            }
            throw new BadLocationException("Your animal is bad and should feel bad", 0);
        } else {
            return new int[]{x,y};
        }
   
    }
    
    public List[][] getOrganisms(){
        return organisms;
    }

    public List getOrganismList(){
        return organismList;
    }
    
    public List getAnimalList(){
        return animalList;
    }
    
    public List getPlantList(){
        return plantList;
    }
    /**
     * Takes in an animal and based on the direction the animal is currently facing,
     * returns a 2-dimensional array of positions [*][0] will give you the X-coordinate
     * of the position, [*][1] will give you the Y-coordinate. the array contains all the tiles
     * the animal can currently see
     * 
     * @param ani
     * @return int[][]
     */
    public int[][] getVision(Animal ani){
        int[][] tempReturned = new int[41][2];
        int returnedSize = 0;
        if(ani.getDirection().equals(Direction.NORTH)){
            for(int i = 0; i < 5; i++){
                for(int x = ani.getX() + i; x >= ani.getX()-i; x--){
                    for(int y = ani.getY() + i; y >= ani.getY()-i; y--){
                        if(x >= 0 && x <= landscape.length-1
                           && y >= 0 && y <= landscape[0].length-1){
                            if(i > 2){
                                if(y == ani.getY() + i){
                                    tempReturned[returnedSize][0] = x;
                                    tempReturned[returnedSize][1] = y;
                                    returnedSize += 1;
                                }
                            }
                            else if(y == ani.getY() + i ||
                                    y == ani.getY() - i ||
                                    x == ani.getX() + i ||
                                    x == ani.getX() - i){
                                tempReturned[returnedSize][0] = x;
                                tempReturned[returnedSize][1] = y;
                                returnedSize += 1;
                            }
                        }
                    }
                }
            }
        }
        else if(ani.getDirection().equals(Direction.NORTHEAST)){
            for(int i = 0; i < 5; i++){
                for(int x = ani.getX() + i; x >= ani.getX()-i; x--){
                    for(int y = ani.getY() + i; y >= ani.getY()-i; y--){
                        if(x >= 0 && x <= landscape.length-1
                           && y >= 0 && y <= landscape[0].length-1){
                            if(i > 2){
                                if((y == ani.getY() + i && x >= ani.getX()) || (x == ani.getX() + i && y >= ani.getY())){
                                    tempReturned[returnedSize][0] = x;
                                    tempReturned[returnedSize][1] = y;
                                    returnedSize += 1;
                                }
                            }
                            else if(y == ani.getY() + i ||
                                    y == ani.getY() - i ||
                                    x == ani.getX() + i ||
                                    x == ani.getX() - i){
                                tempReturned[returnedSize][0] = x;
                                tempReturned[returnedSize][1] = y;
                                returnedSize += 1;
                            }
                        }
                    }
                }
            }
        }
        else if(ani.getDirection().equals(Direction.EAST)){
            for(int i = 0; i < 5; i++){
                for(int x = ani.getX() + i; x >= ani.getX()-i; x--){
                    for(int y = ani.getY() + i; y >= ani.getY()-i; y--){
                        if(x >= 0 && x <= landscape.length-1
                           && y >= 0 && y <= landscape[0].length-1){
                            if(i > 2){
                                if(x == ani.getX() + i){
                                    tempReturned[returnedSize][0] = x;
                                    tempReturned[returnedSize][1] = y;
                                    returnedSize += 1;
                                }
                            }
                            else if(y == ani.getY() + i ||
                                    y == ani.getY() - i ||
                                    x == ani.getX() + i ||
                                    x == ani.getX() - i){
                                tempReturned[returnedSize][0] = x;
                                tempReturned[returnedSize][1] = y;
                                returnedSize += 1;
                            }
                        }
                    }
                }
            }
        }
        
        else if(ani.getDirection().equals(Direction.SOUTHEAST)){
            for(int i = 0; i < 5; i++){
                for(int x = ani.getX() + i; x >= ani.getX()-i; x--){
                    for(int y = ani.getY() + i; y >= ani.getY()-i; y--){
                        if(x >= 0 && x <= landscape.length-1
                           && y >= 0 && y <= landscape[0].length-1){
                            if(i > 2){
                                if((x == ani.getY() + i && y <= ani.getY()) || (y == ani.getY() - i && x >= ani.getX())){
                                    tempReturned[returnedSize][0] = x;
                                    tempReturned[returnedSize][1] = y;
                                    returnedSize += 1;
                                }
                            }
                            else if(y == ani.getY() + i ||
                                    y == ani.getY() - i ||
                                    x == ani.getX() + i ||
                                    x == ani.getX() - i){
                                tempReturned[returnedSize][0] = x;
                                tempReturned[returnedSize][1] = y;
                                returnedSize += 1;
                            }
                        }
                    }
                }
            }
        }
        else if(ani.getDirection().equals(Direction.SOUTH)){
            for(int i = 0; i < 5; i++){
                for(int x = ani.getX() + i; x >= ani.getX()-i; x--){
                    for(int y = ani.getY() + i; y >= ani.getY()-i; y--){
                        if(x >= 0 && x <= landscape.length-1
                           && y >= 0 && y <= landscape[0].length-1){
                            if(i > 2){
                                if(y == ani.getY() - i){
                                    tempReturned[returnedSize][0] = x;
                                    tempReturned[returnedSize][1] = y;
                                    returnedSize += 1;
                                }
                            }
                            else if(y == ani.getY() + i ||
                                    y == ani.getY() - i ||
                                    x == ani.getX() + i ||
                                    x == ani.getX() - i){
                                tempReturned[returnedSize][0] = x;
                                tempReturned[returnedSize][1] = y;
                                returnedSize += 1;
                            }
                        }
                    }
                }
            }
        }
        
        else if(ani.getDirection().equals(Direction.SOUTHWEST)){
            for(int i = 0; i < 5; i++){
                for(int x = ani.getX() + i; x >= ani.getX()-i; x--){
                    for(int y = ani.getY() + i; y >= ani.getY()-i; y--){
                        if(x >= 0 && x <= landscape.length-1
                           && y >= 0 && y <= landscape[0].length-1){
                            if(i > 2){
                                if((x == ani.getY() - i && y <= ani.getY()) || (y == ani.getY() - i && x <= ani.getX())){
                                    tempReturned[returnedSize][0] = x;
                                    tempReturned[returnedSize][1] = y;
                                    returnedSize += 1;
                                }
                            }
                            else if(y == ani.getY() + i ||
                                    y == ani.getY() - i ||
                                    x == ani.getX() + i ||
                                    x == ani.getX() - i){
                                tempReturned[returnedSize][0] = x;
                                tempReturned[returnedSize][1] = y;
                                returnedSize += 1;
                            }
                        }
                    }
                }
            }
        }
        
        else if(ani.getDirection().equals(Direction.WEST)){
            for(int i = 0; i < 5; i++){
                for(int x = ani.getX() + i; x >= ani.getX()-i; x--){
                    for(int y = ani.getY() + i; y >= ani.getY()-i; y--){
                        if(x >= 0 && x <= landscape.length-1
                           && y >= 0 && y <= landscape[0].length-1){
                            if(i > 2){
                                if(x == ani.getX() - i){
                                    tempReturned[returnedSize][0] = x;
                                    tempReturned[returnedSize][1] = y;
                                    returnedSize += 1;
                                }
                            }
                            else if(y == ani.getY() + i ||
                                    y == ani.getY() - i ||
                                    x == ani.getX() + i ||
                                    x == ani.getX() - i){
                                tempReturned[returnedSize][0] = x;
                                tempReturned[returnedSize][1] = y;
                                returnedSize += 1;
                            }
                        }
                    }
                }
            }
        }
        
        else if(ani.getDirection().equals(Direction.NORTHWEST)){
            for(int i = 0; i < 5; i++){
                for(int x = ani.getX() + i; x >= ani.getX()-i; x--){
                    for(int y = ani.getY() + i; y >= ani.getY()-i; y--){
                        if(x >= 0 && x <= landscape.length-1
                           && y >= 0 && y <= landscape[0].length-1){
                            if(i > 2){
                                if((x == ani.getY() - i && y >= ani.getY()) || (y == ani.getY() + i && x <= ani.getX())){
                                    tempReturned[returnedSize][0] = x;
                                    tempReturned[returnedSize][1] = y;
                                    returnedSize += 1;
                                }
                            }
                            else if(y == ani.getY() + i ||
                                    y == ani.getY() - i ||
                                    x == ani.getX() + i ||
                                    x == ani.getX() - i){
                                tempReturned[returnedSize][0] = x;
                                tempReturned[returnedSize][1] = y;
                                returnedSize += 1;
                            }
                        }
                    }
                }
            }
        }
        
        int[][] returned = new int[returnedSize][2];
        for(int i = 0; i < returned.length; i++){
            for(int j = 0; j < returned[0].length; j++){
                returned[i][j] = tempReturned[i][j];
            }
        }
        
        return returned;
    }
    
    /**
     * Takes in the x and y coordinates of a space on the board 
     * and returns a list of terrain adjacent to it
     * 
     * @param x, y coordinates
     * @return list of adjacent terrain
     */
    public LandType[] getAdjacentTerrain(int x, int y){
        LandType[] adjacent;
        if(x == 0){
            if(y == 0){
                adjacent = new LandType[3];
                adjacent[0] = landscape[x][y+1];
                adjacent[1] = landscape[x+1][y+1];
                adjacent[2] = landscape[x+1][y];
                return adjacent;
            }
            
            else if(y == landscape[0].length-1){
                adjacent = new LandType[3];
                adjacent[0] = landscape[x][y-1];
                adjacent[1] = landscape[x+1][y-1];
                adjacent[2] = landscape[x+1][y];
                return adjacent;
            }
            
            else{
                adjacent = new LandType[5];
                adjacent[0] = landscape[x][y+1];
                adjacent[1] = landscape[x+1][y+1];
                adjacent[2] = landscape[x+1][y];
                adjacent[3] = landscape[x][y-1];
                adjacent[4] = landscape[x+1][y-1];
                return adjacent;
            }
        }
        
        else if(x == landscape.length-1){
            if(y == 0){
                adjacent = new LandType[3];
                adjacent[0] = landscape[x][y+1];
                adjacent[1] = landscape[x-1][y+1];
                adjacent[2] = landscape[x-1][y];
                return adjacent;
            }
            
            else if(y == landscape.length-1){
                adjacent = new LandType[3];
                adjacent[0] = landscape[x][y-1];
                adjacent[1] = landscape[x-1][y-1];
                adjacent[2] = landscape[x-1][y];
                return adjacent;
            }
            
            else{
                adjacent = new LandType[5];
                adjacent[0] = landscape[x][y+1];
                adjacent[1] = landscape[x-1][y+1];
                adjacent[2] = landscape[x-1][y];
                adjacent[3] = landscape[x][y-1];
                adjacent[4] = landscape[x-1][y-1];
                return adjacent;
            }
        }
        
        else if(y == 0){
            adjacent = new LandType[5];
            adjacent[0] = landscape[x][y+1];
            adjacent[1] = landscape[x-1][y+1];
            adjacent[2] = landscape[x-1][y];
            adjacent[3] = landscape[x+1][y];
            adjacent[4] = landscape[x+1][y+1];
            return adjacent;
        }
        
        else if(y == landscape[0].length-1){
            adjacent = new LandType[5];
            adjacent[0] = landscape[x][y-1];
            adjacent[1] = landscape[x-1][y-1];
            adjacent[2] = landscape[x-1][y];
            adjacent[3] = landscape[x+1][y];
            adjacent[4] = landscape[x+1][y-1];
            return adjacent;
        }
        
        else{
            adjacent = new LandType[8];
            adjacent[0] = landscape[x][y+1];
            adjacent[1] = landscape[x+1][y+1];
            adjacent[2] = landscape[x+1][y];
            adjacent[3] = landscape[x+1][y-1];
            adjacent[4] = landscape[x][y-1];
            adjacent[5] = landscape[x-1][y-1];
            adjacent[6] = landscape[x-1][y];
            adjacent[7] = landscape[x-1][y-1];
            return adjacent;
        }
    }
    
    public int getWidth(){
        return organisms.length;
    }
    
    public int getHeight(){
        return organisms.length;
    }
    
    public LandType getTile(int x, int y){
        return landscape[x][y];
    }
    
    public void printTerrainComposition(){
        int[] temp = new int[4];
        for(int i = 0; i < landscape.length; i++){
            for(int j = 0; j < landscape[0].length; j++){
                if(landscape[i][j].equals(LandType.DIRT))
                    temp[0] += 1;
                else if(landscape[i][j].equals(LandType.SHALLOW_WATER) || landscape[i][j].equals(LandType.MEDIUM_WATER) || landscape[i][j].equals(LandType.DEEP_WATER))
                    temp[1] += 1;
                else if(landscape[i][j].equals(LandType.ROCK) || landscape[i][j].equals(LandType.BOULDER))
                    temp[2] += 1;
                else if(landscape[i][j].equals(LandType.LAVA))
                    temp[3] += 1;
            }
        }
        
        System.out.println("The world is: ");
        System.out.println((double)((double)(temp[0]*100)/(double)(landscape.length*landscape[0].length)) + "% Dirt");
        System.out.println((double)((double)(temp[1]*100)/(double)(landscape.length*landscape[0].length)) + "% Water");
        System.out.println((double)((double)(temp[2]*100)/(double)(landscape.length*landscape[0].length)) + "% Rock");
        System.out.println((double)((double)(temp[3]*100)/(double)(landscape.length*landscape[0].length)) + "% Lava");
    }
    
    public Iterator<T> aniListIterator(){
        return new AnimalIterator(organismList.iterator());
    }
    
    protected static class AnimalIterator<S> implements Iterator{
        private Iterator<S> aniList;
        
        private AnimalIterator(Iterator<S> iter){
            aniList = iter;
        }
        
        @Override
        public boolean hasNext(){
            if(aniList.hasNext())
                return true;
            else
                return false;
        }
        
        @Override
        public S next(){
            if(aniList.hasNext()){
                return aniList.next();
            }
            else
                throw new NoSuchElementException();
        }
        
        @Override
        public void remove(){
            throw new UnsupportedOperationException("No Admittance");
        }
    }
    
    public static class BoardBuilder<T extends Organism>{
        
        private final int numTiles = 50;
        private LandType[][] landscape;
        private Random generator = new Random();
        
        public Board<T> build(){
            return new Board<T>(this);
        }
        
        public LinkedList<T> buildOrganismList(){
            return new LinkedList<T>();
        }
        
        public LinkedList[][] buildOrganismsBoard(){
            LinkedList[][] temp = new LinkedList[numTiles][numTiles];
            for(int i = 0; i < temp.length; i++){
                for(int j = 0; j < temp[0].length; j++){
                    temp[i][j] = new LinkedList();
                }
            }
            return temp;
        }
        
        public LandType[][] buildLandscape(){
            landscape = new LandType[numTiles][numTiles];
            int randInt = 0;
            int dirt = 0; int water = 0; int rock = 0;
            int[] probabilities = new int[7];
            int sumProb = 0;
            BuildStrategy bStrat;
            for(int i = 0; i < landscape.length; i++){
                if(i % 2 == 0){
                    for(int j = 0; j < landscape[0].length; j++){
                        LandType[] adjacent = getAdjacentTerrain(i,j);
                        for(int k = 0; k < adjacent.length; k++){
                            if(adjacent[k] != null){
                                if(adjacent[k].equals(LandType.DIRT))
                                    dirt += 1;
                                else if(adjacent[k].equals(LandType.SHALLOW_WATER))
                                    water += 2;
                                else if(adjacent[k].equals(LandType.MEDIUM_WATER))
                                    water += 3;
                                else if(adjacent[k].equals(LandType.DEEP_WATER))
                                    water += 4;
                                else if(adjacent[k].equals(LandType.ROCK))
                                    rock += 2;
                                else if(adjacent[k].equals(LandType.BOULDER))
                                    rock += 3;
                                else if(adjacent[k].equals(LandType.LAVA))
                                    rock += 4;
                            }
                        }
                        if(rock >= water && rock >= dirt){
                            bStrat = new RockLandStrategy();
                        }
                        else if(water >= dirt && water > rock){
                            if(water >= 9){
                                bStrat = new DeepWaterStrategy();
                            }
                            else if(water >= 7){
                                bStrat = new MediumWaterStrategy();
                            }
                            else if(generator.nextInt(100) >= 20){
                                bStrat = new ShallowWaterStrategy();
                            }
                            else {
                                bStrat = new BasicLandStrategy();
                            }
                        }
                        else{
                            bStrat = new BasicLandStrategy();
                        }
                        randInt = generator.nextInt(100);
                        probabilities = bStrat.getProbabilities();
                        for(int l = 0; l < probabilities.length; l++){
                           sumProb += probabilities[l];
                            if(sumProb >= randInt){
                                if(l == 0){
                                    landscape[i][j] = LandType.DIRT;
                                    sumProb = 0;
                                    break;
                                }
                                else if(l == 1){
                                    landscape[i][j] = LandType.SHALLOW_WATER;
                                    sumProb = 0;
                                    break;
                                }
                                else if(l == 2){
                                    landscape[i][j] = LandType.MEDIUM_WATER;
                                    sumProb = 0;
                                    break;
                                }
                                else if(l == 3){
                                    landscape[i][j] = LandType.DEEP_WATER;
                                    sumProb = 0;
                                    break;
                                }
                                else if(l == 4){
                                    landscape[i][j] = LandType.ROCK;
                                    sumProb = 0;
                                    break;
                                }
                                else if(l == 5){
                                    landscape[i][j] = LandType.BOULDER;
                                    sumProb = 0;
                                    break;
                                }
                                else if(l == 6){
                                    landscape[i][j] = LandType.LAVA;
                                    sumProb = 0;
                                    break;
                                }
                            
                            }
                        }
                        dirt = 0;
                        water = 0;
                        rock = 0;
                    }
                }
                else if(i % 2 == 1){
                    for(int j = landscape[i].length - 1; j >= 0; j--){
                        LandType[] adjacent = getAdjacentTerrain(i,j);
                        for(int k = 0; k < adjacent.length; k++){
                            if(adjacent[k] != null){
                                if(adjacent[k].equals(LandType.DIRT))
                                    dirt += 1;
                                else if(adjacent[k].equals(LandType.SHALLOW_WATER))
                                    water += 2;
                                else if(adjacent[k].equals(LandType.MEDIUM_WATER))
                                    water += 3;
                                else if(adjacent[k].equals(LandType.DEEP_WATER))
                                    water += 5;
                                else if(adjacent[k].equals(LandType.ROCK))
                                    rock += 2;
                                else if(adjacent[k].equals(LandType.BOULDER))
                                    rock += 3;
                                else if(adjacent[k].equals(LandType.LAVA))
                                    rock += 4;
                            }
                        }
                        if(rock >= water && rock >= dirt){
                            bStrat = new RockLandStrategy();
                        }
                        else if(water >= dirt && water > rock){
                            if(water >= 7){
                                bStrat = new DeepWaterStrategy();
                            }
                            else if(water >= 5){
                                bStrat = new MediumWaterStrategy();
                            }
                            else if(generator.nextInt(100) >= 10){
                                bStrat = new ShallowWaterStrategy();
                            }
                            else {
                                bStrat = new BasicLandStrategy();
                            }
                        }
                        else{
                            bStrat = new BasicLandStrategy();
                        }
                        randInt = generator.nextInt(100);
                        probabilities = bStrat.getProbabilities();
                        for(int l = 0; l < probabilities.length; l++){
                           sumProb += probabilities[l];
                            if(sumProb >= randInt){
                                if(l == 0){
                                    landscape[i][j] = LandType.DIRT;
                                    sumProb = 0;
                                    break;
                                }
                                else if(l == 1){
                                    landscape[i][j] = LandType.SHALLOW_WATER;
                                    sumProb = 0;
                                    break;
                                }
                                else if(l == 2){
                                    landscape[i][j] = LandType.MEDIUM_WATER;
                                    sumProb = 0;
                                    break;
                                }
                                else if(l == 3){
                                    landscape[i][j] = LandType.DEEP_WATER;
                                    sumProb = 0;
                                    break;
                                }
                                else if(l == 4){
                                    landscape[i][j] = LandType.ROCK;
                                    sumProb = 0;
                                    break;
                                }
                                else if(l == 5){
                                    landscape[i][j] = LandType.BOULDER;
                                    sumProb = 0;
                                    break;
                                }
                                else if(l == 6){
                                    landscape[i][j] = LandType.LAVA;
                                    sumProb = 0;
                                    break;
                                }
                            
                            }
                        }
                        dirt = 0;
                        water = 0;
                        rock = 0;
                    }
                }
            }
            return landscape;
        }
        
        private LandType[] getAdjacentTerrain(int x, int y){
            LandType[] adjacent;
            if(x == 0){
                    if(y == 0){
                        adjacent = new LandType[3];
                        adjacent[0] = landscape[x][y+1];
                        adjacent[1] = landscape[x+1][y+1];
                        adjacent[2] = landscape[x+1][y];
                        return adjacent;
                    }
            
                    else if(y == landscape[0].length-1){
                        adjacent = new LandType[3];
                        adjacent[0] = landscape[x][y-1];
                        adjacent[1] = landscape[x+1][y-1];
                        adjacent[2] = landscape[x+1][y];
                        return adjacent;
                    }
            
                    else{
                        adjacent = new LandType[5];
                        adjacent[0] = landscape[x][y+1];
                        adjacent[1] = landscape[x+1][y+1];
                        adjacent[2] = landscape[x+1][y];
                        adjacent[3] = landscape[x][y-1];
                        adjacent[4] = landscape[x+1][y-1];
                        return adjacent;
                    }
            }
        
            else if(x == landscape.length-1){
                if(y == 0){
                    adjacent = new LandType[3];
                    adjacent[0] = landscape[x][y+1];
                    adjacent[1] = landscape[x-1][y+1];
                    adjacent[2] = landscape[x-1][y];
                    return adjacent;
                }
            
                else if(y == landscape.length-1){
                    adjacent = new LandType[3];
                    adjacent[0] = landscape[x][y-1];
                    adjacent[1] = landscape[x-1][y-1];
                    adjacent[2] = landscape[x-1][y];
                    return adjacent;
                }
            
                else{
                    adjacent = new LandType[5];
                    adjacent[0] = landscape[x][y+1];
                    adjacent[1] = landscape[x-1][y+1];
                    adjacent[2] = landscape[x-1][y];
                    adjacent[3] = landscape[x][y-1];
                    adjacent[4] = landscape[x-1][y-1];
                    return adjacent;
                }
            }
        
            else if(y == 0){
                adjacent = new LandType[5];
                adjacent[0] = landscape[x][y+1];
                adjacent[1] = landscape[x-1][y+1];
                adjacent[2] = landscape[x-1][y];
                adjacent[3] = landscape[x+1][y];
                adjacent[4] = landscape[x+1][y+1];
                return adjacent;
            }
        
            else if(y == landscape[0].length-1){
                adjacent = new LandType[5];
                adjacent[0] = landscape[x][y-1];
                adjacent[1] = landscape[x-1][y-1];
                adjacent[2] = landscape[x-1][y];
                adjacent[3] = landscape[x+1][y];
                adjacent[4] = landscape[x+1][y-1];
                return adjacent;
            }
        
            else{
                adjacent = new LandType[8];
                adjacent[0] = landscape[x][y+1];
                adjacent[1] = landscape[x+1][y+1];
                adjacent[2] = landscape[x+1][y];
                adjacent[3] = landscape[x+1][y-1];
                adjacent[4] = landscape[x][y-1];
                adjacent[5] = landscape[x-1][y-1];
                adjacent[6] = landscape[x-1][y];
                adjacent[7] = landscape[x-1][y-1];
                return adjacent;
            }
        }
    }
}
