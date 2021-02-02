import java.awt.*;

public abstract class GameObject {
    private float x;
    private float y;
    private ObjectId objectId;

    public GameObject(float x, float y, ObjectId objectId) {
        this.x = x;
        this.y = y;
        this.objectId = objectId;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }
}
