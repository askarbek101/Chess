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

    public synchronized void loadLevel(BufferedImage image, BufferedImage pieces) {
        int w = image.getWidth();
        int h = image.getHeight();

        for (int xx = 0; xx < w; xx++) {
            for (int yy = 0; yy < h; yy++) {
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if (red == 0 && green == 0 & blue == 0) {
                    Tile block = new Tile(xx * Constants.BLOCK_SIZE, yy * Constants.BLOCK_SIZE,  ObjectId.Block);
                    block.setColor(new Color(0, 148, 255));
                    handler.addObject(block);

                }
                if (red == 255 && green == 255 & blue == 255) {
                    Tile block = new Tile(xx * Constants.BLOCK_SIZE, yy * Constants.BLOCK_SIZE, ObjectId.Block);
                    block.setColor(new Color(128, 128, 128));
                    handler.addObject(block);
                }
            }
        }


        BufferedImage resizedImage = resize(pieces, Constants.BLOCK_SIZE * 6, Constants.BLOCK_SIZE * 2);


        String[][] chessBoardStandard = {
                {"r","n","b","q","k","b","n","r"},
                {"p","p","p","p","p","p","p","p"},
                {"-","-","-","-","-","-","-","-"},
                {"-","-","-","-","-","-","-","-"},
                {"-","-","-","-","-","-","-","-"},
                {"-","-","-","-","-","-","-","-"},
                {"P","P","P","P","P","P","P","P"},
                {"R","N","B","Q","K","B","N","R"},
        };

        ss = new SpriteSheet(resizedImage);
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                switch (chessBoardStandard[i][j]){
                    case("r"):
                        handler.addObject(new Rook(j*64, i*64, false, ObjectId.Rook, ss)); break;
                    case("n"):
                        handler.addObject(new Knight(j*64, i*64, false, ObjectId.Knight, ss)); break;
                    case("b"):
                        handler.addObject(new Bishop(j*64, i*64, false, ObjectId.Bishop, ss)); break;
                    case("q"):
                        handler.addObject(new Queen(j*64, i*64, false, ObjectId.Queen, ss)); break;
                    case("k"):
                        handler.addObject(new King(j*64, i*64, false, ObjectId.King, ss)); break;
                    case("p"):
                        handler.addObject(new Pawn(j*64, i*64, false, ObjectId.Pawn, ss)); break;
                    case("R"):
                        handler.addObject(new Rook(j*64, i*64, true, ObjectId.Rook, ss)); break;
                    case("N"):
                        handler.addObject(new Knight(j*64, i*64, true, ObjectId.Knight, ss)); break;
                    case("B"):
                        handler.addObject(new Bishop(j*64, i*64, true, ObjectId.Bishop, ss)); break;
                    case("Q"):
                        handler.addObject(new Queen(j*64, i*64, true, ObjectId.Queen, ss)); break;
                    case("K"):
                        handler.addObject(new King(j*64, i*64, true, ObjectId.King, ss)); break;
                    case("P"):
                        handler.addObject(new Pawn(j*64, i*64, true, ObjectId.Pawn, ss)); break;
                    default: break;
                }
            }
        }
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
