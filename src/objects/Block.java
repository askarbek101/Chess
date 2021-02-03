package objects;

import framework.Constants;
import framework.GameObject;
import framework.ObjectId;

import java.awt.*;

public class Block extends GameObject {
    public Block(float x, float y, ObjectId objectId) {
        super(x, y, objectId);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) getX(), (int) getY(), Constants.BLOCK_SIZE, Constants.BLOCK_SIZE);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) getX(), (int) getY(), Constants.BLOCK_SIZE, Constants.BLOCK_SIZE);
    }
}
