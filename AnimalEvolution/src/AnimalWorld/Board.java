/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalWorld;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Board<T extends Organism>{
    
    private List<T> animalList;
    private List<T>[][] organisms;
    private LandType[][] landscape;
    private Random generator;
    
    
    public Board(){
        animalList = new LinkedList<T>();
        organisms = new LinkedList[100][100];
        generator = new Random();
        generateLandscape();
    }
    
    public void addActor(T org){
        try{
            int[] tempLoc = findClosest(null, org.getX(), org.getY());
            organisms[tempLoc[0]][tempLoc[1]].add(org);
            animalList.add(org);
        }
        catch(BadLocationException e){
            System.out.println("Bad Location Exception:" + e.getMessage());
        }
    }
    
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
        throw new BadLocationException("Your animal is bad and should feel bad");
    }
    
    private void generateLandscape(){
        landscape = new LandType[organisms.length][organisms[0].length];
        int shalWater = 0, medWater = 0, deepWater = 0, rock = 0, boulder = 0, lava = 0;
        int rand;
        LandType[] adjacent;
        for(int i = 0; i < landscape.length; i++){
            for(int j = 0; j < landscape.length; j++){
                rand = generator.nextInt(100)+1;
                adjacent = getAdjacentTerrain(i,j);
                for(int k = 0; k < adjacent.length;k++){
                    if(adjacent[k] != null){
                        if(adjacent[k].equals(LandType.SHALLOW_WATER))
                            shalWater += 1;
                        else if(adjacent[k].equals(LandType.MEDIUM_WATER))
                            medWater += 1;
                        else if(adjacent[k].equals(LandType.DEEP_WATER))
                            deepWater += 1;
                        else if(adjacent[k].equals(LandType.ROCK))
                            rock += 1;
                        else if(adjacent[k].equals(LandType.BOULDER))
                            boulder += 1;
                       else if(adjacent[k].equals(LandType.LAVA))
                            lava += 1;
                    }
                }
                if(shalWater > 0){
                    if(medWater > 0){
                        if(deepWater > 0){
                            if(rand < 20)
                                landscape[i][j] = LandType.DIRT;
                            else if(rand >= 20 && rand < 55)
                                landscape[i][j] = LandType.SHALLOW_WATER;
                            else if(rand >= 55 && rand < 80)
                                landscape[i][j] = LandType.MEDIUM_WATER;
                            else if(rand >= 80 && rand < 99)
                                landscape[i][j] = LandType.DEEP_WATER;
                            else if(rand >= 99)
                                landscape[i][j] = LandType.ROCK;
                        }
                        
                        else{
                            if(rand < 30)
                                landscape[i][j] = LandType.DIRT;
                            else if(rand >= 30 && rand < 45)
                                landscape[i][j] = LandType.SHALLOW_WATER;
                            else if(rand >= 45 && rand < 70)
                                landscape[i][j] = LandType.MEDIUM_WATER;
                            else if(rand >= 70 && rand < 99)
                                landscape[i][j] = LandType.DEEP_WATER;
                            else if(rand >= 99)
                                landscape[i][j] = LandType.ROCK;
                        }
                        
                    }
                    
                    else if(deepWater > 0){
                        if(rand < 30)
                            landscape[i][j] = LandType.DIRT;
                        else if(rand >= 30 && rand < 40)
                            landscape[i][j] = LandType.SHALLOW_WATER;
                        else if(rand >= 40 && rand < 80)
                            landscape[i][j] = LandType.MEDIUM_WATER;
                        else if(rand >= 80 && rand < 99)
                            landscape[i][j] = LandType.DEEP_WATER;
                        else if(rand >= 99)
                            landscape[i][j] = LandType.ROCK;
                    }
                    
                    else{
                        if(rand < 75)
                            landscape[i][j] = LandType.DIRT;
                        else if(rand >= 75 && rand < 80)
                            landscape[i][j] = LandType.SHALLOW_WATER;
                        else if(rand >= 80 && rand < 90)
                            landscape[i][j] = LandType.MEDIUM_WATER;
                        else if(rand >= 90 && rand < 99)
                            landscape[i][j] = LandType.DEEP_WATER;
                        else if(rand >= 99)
                            landscape[i][j] = LandType.ROCK;
                    }
                }
                
                else if(medWater > 0){
                    if(deepWater > 0){
                        if(rand < 20)
                            landscape[i][j] = LandType.DIRT;
                        else if(rand >= 20 && rand < 50)
                            landscape[i][j] = LandType.SHALLOW_WATER;
                        else if(rand >= 50 && rand < 75)
                            landscape[i][j] = LandType.MEDIUM_WATER;
                        else if(rand >= 75 && rand < 99)
                            landscape[i][j] = LandType.DEEP_WATER;
                        else if(rand >= 99)
                            landscape[i][j] = LandType.ROCK;
                    }
                        
                    else{
                        if(rand < 40)
                            landscape[i][j] = LandType.DIRT;
                        else if(rand >= 40 && rand < 75)
                            landscape[i][j] = LandType.SHALLOW_WATER;
                        else if(rand >= 75 && rand < 90)
                            landscape[i][j] = LandType.MEDIUM_WATER;
                        else if(rand >= 90 && rand < 99)
                            landscape[i][j] = LandType.DEEP_WATER;
                        else if(rand >= 99)
                            landscape[i][j] = LandType.ROCK;
                    }
                    
                }
                
                else if(deepWater > 0){
                    if(rand < 20)
                        landscape[i][j] = LandType.DIRT;
                    else if(rand >= 20 && rand < 55)
                        landscape[i][j] = LandType.SHALLOW_WATER;
                    else if(rand >= 55 && rand < 80)
                        landscape[i][j] = LandType.MEDIUM_WATER;
                    else if(rand >= 80 && rand < 99)
                        landscape[i][j] = LandType.DEEP_WATER;
                    else if(rand >= 99)
                        landscape[i][j] = LandType.ROCK;
                }
                
                else if(rock > 0){
                    if(boulder > 0){
                        if(lava > 0){
                            if(rand < 55)
                                landscape[i][j] = LandType.DIRT;
                            else if(rand >= 55 && rand < 95)
                                landscape[i][j] = LandType.ROCK;
                            else if(rand >= 95)
                                landscape[i][j] = LandType.LAVA; 
                        }
                        else{
                            if(rand < 55)
                                landscape[i][j] = LandType.DIRT;
                            else if(rand >= 55 && rand < 95)
                                landscape[i][j] = LandType.ROCK;
                            else if(rand >= 95)
                                landscape[i][j] = LandType.LAVA;
                        }
                    }
                    else if(lava > 0){
                        if(rand < 65)
                            landscape[i][j] = LandType.DIRT;
                        else if(rand >= 65 && rand < 80)
                            landscape[i][j] = LandType.ROCK;
                        else if(rand >= 80 && rand < 90)
                            landscape[i][j] = LandType.BOULDER;
                        else if(rand >= 90)
                            landscape[i][j] = LandType.LAVA;
                    }
                    else{
                        if(rand < 55)
                            landscape[i][j] = LandType.DIRT;
                        else if(rand >= 55 && rand < 87)
                            landscape[i][j] = LandType.ROCK;
                        else if(rand >= 87 && rand < 97)
                            landscape[i][j] = LandType.BOULDER;
                        else if(rand >= 97)
                            landscape[i][j] = LandType.LAVA;
                    }
                }
                else if(boulder > 0){
                    if(lava > 0){
                        if(rand < 55)
                            landscape[i][j] = LandType.DIRT;
                        else if(rand >= 55 && rand < 90)
                            landscape[i][j] = LandType.ROCK;
                        else if(rand >= 90)
                            landscape[i][j] = LandType.LAVA; 
                    }
                    else{
                        if(rand < 55)
                            landscape[i][j] = LandType.DIRT;
                        else if(rand >= 55 && rand < 97)
                            landscape[i][j] = LandType.ROCK;
                        else if(rand >= 97)
                            landscape[i][j] = LandType.LAVA;
                    }
                }
                else if(lava > 0){
                    if(rand < 60)
                        landscape[i][j] = LandType.DIRT;
                    else if(rand >= 60 && rand < 90)
                        landscape[i][j] = LandType.ROCK;
                    else if(rand >= 90)
                        landscape[i][j] = LandType.LAVA; 
                }
                else{
                    if(rand < 94)
                        landscape[i][j] = LandType.DIRT;
                    else if(rand >= 94 && rand < 99)
                        landscape[i][j] = LandType.SHALLOW_WATER;
                    else if(rand >= 99){
                        landscape[i][j] = LandType.ROCK;
                    }
                }
                shalWater = 0;
                medWater = 0;
                deepWater = 0;
                rock = 0;
                boulder = 0;
                lava = 0;
            }
        }
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
        return new AnimalIterator(animalList.iterator());
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
}
