
package gamemain;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameFrame extends JPanel implements ActionListener{
    
    Timer mainTimer;
    Player player;
    static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    static ArrayList<Missile>missiles = new ArrayList<Missile>();
    int enemyCount=5;
    int level=1;
    Random r = new Random();
    public GameFrame(){
        setFocusable(true);
        player = new Player(500,200);
        addKeyListener(new KeyAdapt(player));
        mainTimer = new Timer(5,this);
        mainTimer.start();
        newLevel();
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d =(Graphics2D)g;
        player.draw(g2d);
        for(int i=0; i<enemies.size();i++){
            Enemy tempEnemy=enemies.get(i);
            tempEnemy.draw(g2d);
        }
        for(int i=0; i<missiles.size();i++){
            Missile mi=missiles.get(i);
            mi.draw(g2d);
        }        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        player.update();
        for(int i=0; i<enemies.size();i++){
            Enemy tempEnemy=enemies.get(i);
            tempEnemy.update();
        }
        for(int i=0; i<missiles.size();i++){
            Missile mi=missiles.get(i);
            mi.update();
        } 
        checkEnd();
        repaint();
    }
    public static void addEnemy(Enemy e){
        enemies.add(e);
    }
    public static void removeEnemy(Enemy e){
        enemies.remove(e);
    }
    public static ArrayList<Enemy> getEnemyList(){
        return enemies;
    }
    public static void addMissile(Missile m){
        missiles.add(m);
    }
    public static void removeMissile(Missile m){
        missiles.remove(m);
    }
    public static ArrayList<Missile> getMissileList(){
        return missiles;
    }    
    public void newLevel(){
        enemyCount=level*5;
        for(int i=0; i<enemyCount; i++){
            addEnemy(new Enemy(r.nextInt(800),-r.nextInt(600)));
        }        
    }
    public void checkEnd(){
        if(enemies.size()==0){
            level++;
            enemies.clear();
            missiles.clear();
            JOptionPane.showMessageDialog(null,"GOOD JOB... YOU HAVE CLEARED THE CURRENT LEVEL... LET'S MOVE TO THE NEXT LEVEL");
            newLevel();
        }
    }
}
