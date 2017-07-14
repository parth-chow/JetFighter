
package gamemain;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Missile extends GameEngine {

    public Missile(int x, int y) {
        super(x, y);
    }
    public void update(){
        y-=2;
    }
    public void draw(Graphics2D g2d){
       g2d.drawImage(getMissileImg(),x,y,null);
    }
    public Image getMissileImg(){
        ImageIcon i = new ImageIcon("C:\\Users\\Parth\\Downloads\\310 project final-20170705T105700Z-001\\310 project final\\Gamemain\\src\\gamemain\\m1.png");
        return i.getImage();        
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,getMissileImg().getWidth(null),getMissileImg().getHeight(null));
    }    
}
