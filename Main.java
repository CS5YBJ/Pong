import javax.swing.*;
public class Main {

    static JFrame f = new JFrame("Paddle Power");
    public static void main(String[] args) {

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(660, 670);

        PongGame game = new PongGame();

        f.add(game);

        f.setVisible(true);

        Timer timer = new Timer(33, e -> {
            game.repaint();
            game.gameLogic();
        });
        timer.start();
    }
}