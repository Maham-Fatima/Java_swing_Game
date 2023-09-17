import java.awt.*;
public class Score extends Rectangle{
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    static int player1;
    static int player2;

    public Score(int GAME_WIDTH,int GAME_HEIGHT){
          Score.GAME_WIDTH = GAME_WIDTH;
          Score.GAME_HEIGHT = GAME_HEIGHT;
    }
    public void draw(Graphics e){
        e.setColor(Color.black);
        e.setFont(new Font(null,Font.PLAIN,26));
        e.drawString(player1 / 10 +String.valueOf(player1%10),(GAME_WIDTH/2)-40, 40);
        e.drawString(player2 / 10+String.valueOf(player2%10),(GAME_WIDTH/2)+10, 40);
        e.drawLine(GAME_WIDTH/2,0,GAME_WIDTH/2,GAME_HEIGHT);
    }

}
