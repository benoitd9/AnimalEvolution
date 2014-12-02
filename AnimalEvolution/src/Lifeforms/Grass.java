/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lifeforms;

import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author Nate
 */
public class Grass extends Plant{
    
    public Grass(int size, int xPos, int yPos){
        super(size, xPos, yPos);
    }
    
    public void paintComponent(Graphics g){
        g.setColor(Color.GREEN);
        int sizeFactor = 0;
        if(size <= 4)
            sizeFactor = 4;
        
        else if(size > 4 && size <= 8)
            sizeFactor = 8;
        
        else if(size > 8 && size <= 16)
            sizeFactor = 16;
        
        else
            sizeFactor = 32;
        //g.fillRect(xPosition*16+20, yPosition*16+20, 16, 16);
        g.setColor(new Color(0, 153, 0));
        if(sizeFactor == 4){
            g.drawLine(xPosition*16+25, yPosition*16+25, xPosition*16+25, yPosition*16+28);
            g.drawLine(xPosition*16+32, yPosition*16+30, xPosition*16+32, yPosition*16+33);
        }
        else if(sizeFactor == 8){
            g.drawLine(xPosition*16+25, yPosition*16+25, xPosition*16+25, yPosition*16+28);
            g.drawLine(xPosition*16+32, yPosition*16+30, xPosition*16+32, yPosition*16+33);
            g.drawLine(xPosition*16+23, yPosition*16+30, xPosition*16+23, yPosition*16+33);
            g.drawLine(xPosition*16+30, yPosition*16+22, xPosition*16+30, yPosition*16+25);
        }
        else if(sizeFactor == 16){
            g.drawLine(xPosition*16+25, yPosition*16+25, xPosition*16+25, yPosition*16+28);
            g.drawLine(xPosition*16+32, yPosition*16+30, xPosition*16+32, yPosition*16+33);
            g.drawLine(xPosition*16+23, yPosition*16+30, xPosition*16+23, yPosition*16+33);
            g.drawLine(xPosition*16+30, yPosition*16+22, xPosition*16+30, yPosition*16+25);
            g.drawLine(xPosition*16+22, yPosition*16+22, xPosition*16+22, yPosition*16+25);
            g.drawLine(xPosition*16+30, yPosition*16+33, xPosition*16+30, yPosition*16+36);
        }
        else if(sizeFactor == 32){
            g.drawLine(xPosition*16+25, yPosition*16+25, xPosition*16+25, yPosition*16+28);
            g.drawLine(xPosition*16+32, yPosition*16+30, xPosition*16+32, yPosition*16+33);
            g.drawLine(xPosition*16+23, yPosition*16+30, xPosition*16+23, yPosition*16+33);
            g.drawLine(xPosition*16+30, yPosition*16+22, xPosition*16+30, yPosition*16+25);
            g.drawLine(xPosition*16+22, yPosition*16+22, xPosition*16+22, yPosition*16+25);
            g.drawLine(xPosition*16+30, yPosition*16+33, xPosition*16+30, yPosition*16+36);
            g.drawLine(xPosition*16+34, yPosition*16+23, xPosition*16+34, yPosition*16+26);
            g.drawLine(xPosition*16+27, yPosition*16+22, xPosition*16+27, yPosition*16+22);
            g.drawLine(xPosition*16+31, yPosition*16+27, xPosition*16+31, yPosition*16+27);
            g.drawLine(xPosition*16+25, yPosition*16+33, xPosition*16+25, yPosition*16+36);
            g.drawLine(xPosition*16+27, yPosition*16+31, xPosition*16+27, yPosition*16+34);
            g.drawLine(xPosition*16+23, yPosition*16+26, xPosition*16+23, yPosition*16+29);
        }
    }
    
    public int[] grow(){
        size += 1;
        return spread();
    }
    
    protected int[] spread(){
        if(size > 20){
            size = size/2;
            return new int[]{xPosition, yPosition};
        }
        else
            return new int[]{-1,-1};
    }
}
