import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener {

    private Ball pongBall;
    private Paddle playerPaddle, computerPaddle;
    private int bounceCount;
    private int playerScore, computerScore;
    static final int PANEL_WIDTH = 670, PANEL_HEIGHT = 670;
    private int userMouseY;
    public PongGame() {
        pongBall = new Ball(300, 200, 3, 3, 4, Color.white, 10);
        playerPaddle = new Paddle(10, 200, 75, 4, Color.magenta);
        computerPaddle = new Paddle(610, 200, 75, 3, Color.green);
        userMouseY = 0;
        bounceCount = 0;
        playerScore = 0;
        computerScore = 0;
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        pongBall.paint(g);
        playerPaddle.paint(g);
        computerPaddle.paint(g);
        g.setColor(Color.white);

        g.drawString("YOU [ " + playerScore + " ]   COMPUTER [ " + computerScore + " ]", 250, 20);
    }
    public void gameLogic() {
        pongBall.moveBall();
        //noinspection SuspiciousNameCombination
        pongBall.bounceOffEdges(0, PANEL_WIDTH);
        computerPaddle.moveTowards(pongBall.getY());
        playerPaddle.moveTowards(userMouseY);

        if (pongBall.getX() < 0) {
            computerScore++;
            reset();
        } else if (pongBall.getX() > PANEL_WIDTH) {
            //pc has lost
            playerScore++;
            reset();
        }
        if (playerPaddle.checkCollision(pongBall)) {
            pongBall.reverseX();
            bounceCount++;
        }
        if (computerPaddle.checkCollision(pongBall)) {
            pongBall.reverseX();
            bounceCount++;

        }
        if (bounceCount == 5) {
            pongBall.speedIncrease();
        }
    }

    public void reset() {
        pongBall = new Ball(300, 200, 3, 3, 3, Color.white, 10);
        playerPaddle = new Paddle(10, 200, 75, 4, Color.magenta);
        computerPaddle = new Paddle(610, 200, 75, 4, Color.green);
        bounceCount = 0;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        userMouseY = e.getY();
    }

}