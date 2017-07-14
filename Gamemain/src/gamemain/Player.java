
package gamemain;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Player extends GameEngine implements KeyListener{
    int speed=2;
    int velx=0;
    int vely=0;
    public Player(int x,int y){
        super(x,y);
    }
    public void update(){
        y+=vely;
        x+=velx;
        checkCollisions();
    }
    public void draw(Graphics2D g2d){
        g2d.drawImage(getPlayerImg(),x,y, null);
        //g2d.draw(getBounds());
    }
    public Image getPlayerImg(){
        ImageIcon i = new ImageIcon("C:\\Users\\Parth\\Downloads\\310 project final-20170705T105700Z-001\\310 project final\\Gamemain\\src\\gamemain\\spaceshipsteady.png");
        return i.getImage();
    }
    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_UP){
            vely=-2;
        }else if(key==KeyEvent.VK_DOWN){
            vely=2;
        }
        else if(key==KeyEvent.VK_RIGHT){
            velx=2;
        }
        else if(key==KeyEvent.VK_LEFT){
            velx=-2;
        }else if(key==KeyEvent.VK_SPACE){
            GameFrame.addMissile(new Missile(x,y));
        }        
    }
    public void keyReleased(KeyEvent e){
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_UP){
            vely=0;
        }else if(key==KeyEvent.VK_DOWN){
            vely=0;
        }
        else if(key==KeyEvent.VK_RIGHT){
            velx=0;
        }
        else if(key==KeyEvent.VK_LEFT){
            velx=0;
        }        
        
    }      

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void checkCollisions(){
        ArrayList<Enemy> enemies=GameFrame.getEnemyList();
        for(int i=0; i<enemies.size();i++){
            Enemy tempEnemy=enemies.get(i);
            if(getBounds().intersects(tempEnemy.getBounds())){
                GameFrame.removeEnemy(tempEnemy);
            }
        }
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,getPlayerImg().getWidth(null),getPlayerImg().getHeight(null));
    }
}
