import java.util.*;
import java.awt.*;
public class Ball extends Rectangle {
    int yVelocity;
    int xVelocity;
    Random random;
    public Ball(int xposition,int yposition, int width, int height){
           super(xposition,yposition,width,height);
           random = new Random();
           int directionX = random.nextInt(2);
           if (directionX == 0) {
               directionX-=2;
           }else{
               directionX++;
           }
               SetXDirection(directionX);
           int directionY = random.nextInt(2);
           if (directionY == 0) {
               directionY-=2;
           }else {
               directionY++;
           }
               SetYDirection(directionY);
    }
    public void SetXDirection(int x){
          xVelocity = x;
    }
    public void SetYDirection(int y){
          yVelocity = y;
    }
    public void move(){
          x+=xVelocity;
          y+=yVelocity;
    }
    public void draw(Graphics e){
        e.setColor(Color.WHITE);
        e.fillOval(x,y,width,height);
    }
}
