import javax.swing.*;
import java.awt.*;
public class GameFrame extends JFrame{
    GamePanel gamePanel;
    public GameFrame(){
         gamePanel= new GamePanel();
         this.setTitle("Pong Game");
         this.add(gamePanel);
         this.setResizable(false);
         this.setBackground(Color.GREEN);
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         this.pack();
         this.setVisible(true);
         this.setResizable(false);
         this.setLocationRelativeTo(null);
    }
}
