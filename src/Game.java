import java.awt.*;

public class Game extends Canvas implements Runnable  {

    public Game() {
        new Window(800, 800, "sandbox", this);
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        new Game();
    }
}
