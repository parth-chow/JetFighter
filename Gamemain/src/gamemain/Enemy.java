
package gamemain;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Enemy extends GameEngine {
private int startX;
    public Enemy(int x, int y) {
        super(x,y);
        startX=x;
    }
    public void update(){
        y+=1;
        checkCollisions();
    }
    public void draw(Graphics2D g2d){
        g2d.drawImage(getEnemyImg(),x,y,null);
        //g2d.draw(getBounds());
    }
    public Image getEnemyImg(){
        ImageIcon i = new ImageIcon("C:\\Users\\Parth\\Downloads\\310 project final-20170705T105700Z-001\\310 project final\\Gamemain\\src\\gamemain\\e1.png");
        return i.getImage();        
    }
    public void checkCollisions(){
        for(int i=0; i<GameFrame.getMissileList().size();i++){
            Missile mi=GameFrame.getMissileList().get(i);
            if(getBounds().intersects(mi.getBounds())){
                GameFrame.removeEnemy(this);
                GameFrame.removeMissile(mi);
            }
        }
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,getEnemyImg().getWidth(null),getEnemyImg().getHeight(null));
    }    
    
}
