import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
    public boolean isRunning = false;
    public Thread thread;
    public final Handler handler;

    public BufferedImage level;
    public BufferedImage pieces;

    public Game() {
        new Window(Constants.SIZE, Constants.TITLE, this);

        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/board.png");
        pieces = loader.loadImage("/pieces.png");

        start();

        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput(handler));

        loadLevel(level, pieces);
    }

    public void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        isRunning = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();

        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            render();

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
            }
        }

        stop();
    }

    public void tick() {
        handler.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();


        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public void loadLevel(BufferedImage image, BufferedImage pieces) {
        int w = image.getWidth();
        int h = image.getHeight();

        for (int xx = 0; xx < w; xx++) {
            for (int yy = 0; yy < h; yy++) {
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if (red == 0 && green == 0 & blue == 0) {
                    handler.addObject(new Block(xx * Constants.BLOCK_SIZE, yy * Constants.BLOCK_SIZE, ObjectId.Block));
                }
            }
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
