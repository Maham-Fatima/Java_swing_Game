import javax.swing.JFrame;

public class SnakeGameFrame extends JFrame {
    SnakeGameLogic logic;
    SnakeGameFrame(){
        logic = new SnakeGameLogic();
        this.add(logic);
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1300,600);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
