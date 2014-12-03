/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReader;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Holly
 */
public class TextFileReader {
    private Scanner scan;
    private List<String> returnList;
    
    public TextFileReader(){
        scan = new Scanner(System.in);
    }
    
    public List<String> strings(){
        return returnList;
    }
    
    public void read(){
        boolean tryAgain = true;
        List<String> returned = null;
        while(tryAgain){
        
            try{
                returned = readFile();
            }
            catch(Exception e){
                System.out.println("Bad file name, would you like to try again? (y/n)");
                String s = scan.next();
                if(s.equalsIgnoreCase("y")){
                    tryAgain = true;
                }
                else{
                    tryAgain = false;
                }
            }
        }
        if(returned != null){
            returnList = returned;
        }
    }
    
    private List<String> readFile() throws IOException{
        System.out.println("This program takes a list of Strings in format");
        System.out.println("NAME:xPosition, yPosition, EatingStrategy, isCannibal, MovementSpeed, gender");
        System.out.println("enter file path: ");
        String fileName = scan.next();
        String str = null;
        
        FileReader fr = new FileReader(fileName);
        BufferedReader textReader = new BufferedReader(fr);
        
        while((str=textReader.readLine()) != null){
            returnList.add(str);
        }
        
        return returnList;
        
    }
    
}
