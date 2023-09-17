import java.awt.event.KeyEvent;
import java.awt.*;
public class Paddle extends Rectangle{
    int id;
    int yVelocity;
    public Paddle(int position, int mid,int width, int height,int id){
        super(position,mid,width,height);
        this.id = id;
    }
    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1 -> {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    SetYDirection(-10);
                    move();
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    SetYDirection(10);
                    move();
                }
            }
            case 2 -> {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    SetYDirection(-10);
                    move();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    SetYDirection(10);
                    move();
                }
            }
        }
    }
    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1 -> {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    SetYDirection(0);
                    move();
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    SetYDirection(0);
                    move();
                }
            }
            case 2 -> {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    SetYDirection(0);
                    move();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    SetYDirection(0);
                    move();
                }
            }
        }
    }
    public void SetYDirection(int ydir){
         yVelocity = ydir;
    }
    public void move(){
        y = y + yVelocity; // position(y) - 10 up, position(y) + 10 down
    }
    public void draw(Graphics e){
       if (id == 1){
           e.setColor(Color.BLUE);
       }else{
           e.setColor(Color.RED);
       }
       e.fillRect(x,y,width,height);
    }
}
