/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalWorld;


import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Nate
 */
public class GUIBoard extends JPanel{
    
    private Board board;
    private BufferedImage image;
    
    public GUIBoard(Board b){
        super();
        setBackground(Color.WHITE);
        super.setSize(b.getWidth()*16+40,b.getHeight()*16+40);
        super.setVisible(true);
        board = b;
        try{
            image = ImageIO.read(new File("AnimalTiles.png"));
        } catch (IOException ex){
            
        }
    }
    
    public void paintComponent(Graphics g){
        int width = getWidth();
        int height = getHeight();
        
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        
        for(int i = 0; i < board.getWidth(); i++){
            for(int j = 0; j < board.getHeight(); j++){
                g.setColor(board.getTile(i,j).getColor());
                g.fillRect(i*16+20, j*16+20, 16, 16);
            }
        }
        
        List[][] temp = board.getOrganisms();
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[0].length; j++){
                
                if( temp[i][j] != null ){
                    for(int k = 0; k < temp[i][j].size(); k++){
                        g.drawImage(image, 20+i*16, 20+j*16, 36+i*16, 36+j*16,((Organism) (temp[i][j].get(k))).getSpriteX()*16,((Organism)(temp[i][j].get(k))).getSpriteY()*16,((Organism) (temp[i][j].get(k))).getSpriteX()*16+16,((Organism)(temp[i][j].get(k))).getSpriteY()*16+16, null);
                    }
                }
            }
        }
    }
}
