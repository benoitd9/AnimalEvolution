/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lifeforms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 *
 * @author Nate
 */
public class Tree extends Plant{
    
    public Tree(int size, int xPos, int yPos){
        super(size*2, xPos, yPos);
    }
    
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(51, 25, 0));
        int sizeFactor = 0;
        if(size <= 20)
            sizeFactor = 4;
        
        else if(size > 20 && size <= 50)
            sizeFactor = 8;
        
        else if(size > 50 && size <= 100)
            sizeFactor = 16;
        
        else
            sizeFactor = 32;
        
        g2d.translate(xPosition*16+28, yPosition*16+28);
        g2d.rotate(Math.toRadians(30));
        g2d.translate(-(xPosition*16+28), -(yPosition*16+28));
        
        g2d.fillRect(xPosition*16+(28-sizeFactor/4), yPosition*16+(28-sizeFactor/2), sizeFactor/2, sizeFactor);
        g2d.setColor(new Color(0, 102, 0));
        g2d.fillOval(xPosition*16+(28-sizeFactor/2), yPosition*16+(28-sizeFactor), sizeFactor, sizeFactor/2);
        
        g2d.translate(xPosition*16+28, yPosition*16+28);
        g2d.rotate(Math.toRadians(330));
        g2d.translate(-(xPosition*16+28), -(yPosition*16+28));
    }
    
    public int[] grow(){
        size += 10;
        return spread();
    }
    
    protected int[] spread(){
        if(size > 500){
            return new int[]{xPosition, yPosition};
        }
        else{
            return new int[]{-1,-1};
        }
    }
}