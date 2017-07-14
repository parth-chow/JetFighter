
package gamemain;

import javax.swing.JFrame;


public class Gamemain {

    public static void main(String[] args) {
        JFrame frame = new JFrame("GAME");
        frame.setSize(1000,800);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(new GameFrame());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
