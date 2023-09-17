import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame implements ActionListener {
    GameFrame pongFrame;
    SnakeGameFrame snakeGameFrame;
    TicTacToeGame tictacGame;
    JButton snakeGame;
    JButton TicTacToe;
    JButton PongGame;
    MenuFrame(){
        snakeGame = new JButton("Play Snake Game");
        TicTacToe = new JButton("Play TicTacToe");
        PongGame = new JButton("Play Pong Game");
        snakeGame.setBackground(Color.RED);
        TicTacToe.setBackground(Color.BLUE);
        PongGame.setBackground(Color.GREEN);
        snakeGame.setForeground(Color.WHITE);
        TicTacToe.setForeground(Color.WHITE);
        PongGame.setForeground(Color.WHITE);
        snakeGame.setFont(new Font("Consoles",Font.BOLD,32));
        TicTacToe.setFont(new Font("Consoles",Font.BOLD,32));
        PongGame.setFont(new Font("Consoles",Font.BOLD,32));
        snakeGame.setPreferredSize(new Dimension(300, 100));
        TicTacToe.setPreferredSize(new Dimension(300, 100));
        PongGame.setPreferredSize(new Dimension(300, 100));
        snakeGame.addActionListener(this);
        TicTacToe.addActionListener(this);
        PongGame.addActionListener(this);

        setSize(500,500);
        setLayout(new FlowLayout());
        add(snakeGame);
        add(TicTacToe);
        add(PongGame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == PongGame){
            dispose();
            pongFrame = new GameFrame();
        }
        else if(e.getSource() == snakeGame){
            dispose();
            snakeGameFrame = new SnakeGameFrame();
        } else if (e.getSource() == TicTacToe) {
            dispose();
            tictacGame = new TicTacToeGame();
        }

    }
}
