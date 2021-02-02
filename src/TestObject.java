import java.awt.*;

public class TestObject extends GameObject {

    public TestObject(float x, float y, ObjectId objectId) {
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
        return null;
    }
}
