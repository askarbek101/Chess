package window;

import framework.Constants;
import framework.ObjectId;
import objects.*;
import utilities.BufferedImageLoader;
import utilities.KeyInput;
import utilities.MouseInput;
import utilities.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
    public boolean isRunning = false;
    public Thread thread;
    public Handler handler;

    public BufferedImage level;
    public BufferedImage pieces;
    public SpriteSheet ss;

    public Game() {
        new Window(Constants.SIZE, Constants.TITLE, this);

        init();

        start();
    }

    public void init() {
        handler = new Handler();

        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/board.png");
        pieces = loader.loadImage("/pieces.png");


        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput(handler));
        this.addMouseMotionListener(new MouseInput(handler));

        loadLevel(level, pieces);

    }

    public synchronized void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
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
                    Block block = new Block(xx * Constants.BLOCK_SIZE, yy * Constants.BLOCK_SIZE, ObjectId.Block);
                    block.setColour(new Color(0, 148, 255));
                    handler.addObject(block);
                }
                if (red == 255 && green == 255 & blue == 255) {
                    Block block = new Block(xx * Constants.BLOCK_SIZE, yy * Constants.BLOCK_SIZE, ObjectId.Block);
                    block.setColour(new Color(128, 128, 128));
                    handler.addObject(block);
                }
            }
        }

        BufferedImage resizedImage = resize(pieces, Constants.BLOCK_SIZE * 6, Constants.BLOCK_SIZE * 2);


        ss = new SpriteSheet(resizedImage);

        handler.addObject(new Rook(0, 448, ObjectId.Rook, ss));
        handler.addObject(new Knight(64, 448, ObjectId.Knight, ss));
        handler.addObject(new Bishop(128, 448, ObjectId.Bishop, ss));
        handler.addObject(new Queen(192, 448, ObjectId.Queen, ss));
        handler.addObject(new King(256, 448, ObjectId.King, ss));
        handler.addObject(new Bishop(320, 448, ObjectId.Bishop, ss));
        handler.addObject(new Knight(384, 448, ObjectId.Knight, ss));
        handler.addObject(new Rook(448, 448, ObjectId.Rook, ss));
        handler.addObject(new Pawn(0, 384, ObjectId.Pawn, ss));
        handler.addObject(new Pawn(64, 384, ObjectId.Pawn, ss));
        handler.addObject(new Pawn(128, 384, ObjectId.Pawn, ss));
        handler.addObject(new Pawn(192, 384, ObjectId.Pawn, ss));
        handler.addObject(new Pawn(256, 384, ObjectId.Pawn, ss));
        handler.addObject(new Pawn(320, 384, ObjectId.Pawn, ss));
        handler.addObject(new Pawn(384, 384, ObjectId.Pawn, ss));
        handler.addObject(new Pawn(448, 384, ObjectId.Pawn, ss));

    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    public static void main(String[] args) {
        new Game();
    }
}
