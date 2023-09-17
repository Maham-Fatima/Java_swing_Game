import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable{
    static final int GAME_WIDTH=1300;//fix height and width
    static final int GAME_HEIGHT=600;
    static final Dimension SCREEN_SIZE= new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER=20;
    static final int PADDLE_WIDTH=20;
    static final int PADDLE_HEIGHT=100;
    Thread thread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    public GamePanel(){
        ball();
        paddle();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        setBackground(Color.GREEN);
        setFocusable(true);
        addKeyListener(new KeyListener());
        setPreferredSize(SCREEN_SIZE);
        thread = new Thread(this);
        thread.start();//start game
    }
    public void ball(){
        ball = new Ball((GAME_WIDTH/2-BALL_DIAMETER/2),(GAME_HEIGHT/2-BALL_DIAMETER/2),BALL_DIAMETER,BALL_DIAMETER);
    }
    public void paddle(){
         paddle1 = new Paddle(0, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
         paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }
    public int GAME_WIN_CHECK(){
        if(Score.player1 >= 10){
          return 1;
        }else if(Score.player2 >= 10){
            return 2;
        }
        return 0;
    }
    public void draw(Graphics e){
        int winner = GAME_WIN_CHECK();
        if(winner > 0){
            e.setColor(Color.WHITE);
            e.setFont(new Font(null,Font.BOLD,42));
            e.drawString("PLAYER "+winner+" WON",GAME_WIDTH/2,GAME_HEIGHT/2);
            Timer time= new Timer(2000, e1 -> System.exit(1));
            time.start();
        }else {
            paddle1.draw(e);
            paddle2.draw(e);
            ball.draw(e);
            score.draw(e);
        }
    }
    public void paint(Graphics e){
       image = createImage(getWidth(),getHeight());
       graphics = image.getGraphics();
       draw(graphics);
       e.drawImage(image,0,0,this);
    }
    public void move(){
        /*
        If it is not called here then frame is updating but response is slow.
        during key pressed if frame is updated then it will continue to move, whether than again start listening process
        */
        paddle1.move();
        paddle2.move();
        ball.move();
    }
    public void run(){
        long initialTime = System.nanoTime();
        double AmountOfTicks = 60;
        double nanoseconds = 1000000000 / AmountOfTicks;
        double delta = 0;
        while (true){
            long currentTime = System.nanoTime();
            delta += (currentTime - initialTime)/nanoseconds;
            initialTime = currentTime;
            if (delta >= 1){// 1 second passed
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    public void checkCollision(){
      //paddle do not move out of windows
        if(paddle1.y <= 0)
        {
            paddle1.y = 0;
        }else if(paddle1.y >= GAME_HEIGHT-PADDLE_HEIGHT){
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        }
        if(paddle2.y <= 0)
        {
            paddle2.y = 0;
        }else if(paddle2.y >= GAME_HEIGHT-PADDLE_HEIGHT){
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
        }
        if(ball.y <= 0 ){
            ball.SetYDirection(-ball.yVelocity);
        }
        if(ball.y >= GAME_HEIGHT - BALL_DIAMETER){
            ball.SetYDirection(-ball.yVelocity);
        }
        //ball misses the paddle{
        if(ball.x <= 0){
            score.player2++;
            //restart ball from middle
            ball();
        }
        if(ball.x >= GAME_WIDTH-BALL_DIAMETER+1){
            score.player1++;
            //restart ball from middle
            ball();
        }
        // ball hits the paddle
        if (ball.intersects(paddle1)||ball.intersects(paddle2)){
            if(Math.abs(ball.xVelocity) < 6) {
                if(ball.xVelocity < 0){
                    ball.xVelocity--;
                    ball.SetXDirection(-ball.xVelocity);
                }
                else {
                    ball.xVelocity++;
                    ball.SetXDirection(-ball.xVelocity);
                }
                if(ball.yVelocity < 0){
                    ball.yVelocity--;
                    ball.SetYDirection(ball.yVelocity);
                }
                else {
                    ball.yVelocity++;
                    ball.SetYDirection(ball.yVelocity);
                }
            }else{
                ball.SetXDirection(-ball.xVelocity);
                ball.SetYDirection(ball.yVelocity);
            }
        }

    }
    public class KeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }

}
