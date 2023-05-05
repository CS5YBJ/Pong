import java.awt.*;

public class Ball {
    private int x;
    private int y;
    private int mx;
    private int my;
    private int speed;
    private final int size;
    private final Color color;

    static final int MAX_SPEED = 15;
    public Ball(int x, int y, int mx, int my, int speed, Color color, int size) {

        this.x = x;
        this.y = y;
        this.mx = mx;
        this.my = my;
        this.speed = speed;
        this.color = color;
        this.size = size;

    }
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
    public void moveBall() {
        x += mx;
        y += my;
    }

    public void bounceOffEdges(int top, int bottom) {
        if (y > bottom - size) {
            reverseY();
        } else if (y < top) {
            reverseY();
        }
    }
    public void reverseX() {
        mx *= -1;
    }
    public void reverseY() {
        my *= -1;
    }
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    public int getSize() {
        return size;
    }

    public void speedIncrease() {
        if (speed < MAX_SPEED) {
            speed++;
            mx = (mx / Math.abs(mx) * speed);
        }
    }

}