package window;

import framework.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    public LinkedList<GameObject> objects = new LinkedList<>();

    public void tick() {
        for (GameObject tempObject: objects) {
            tempObject.tick();
        }

    }

    public void render(Graphics g) {
        for (GameObject tempObject: objects) {
            tempObject.render(g);
        }
    }

    public void addObject(GameObject tempObject) {
        objects.add(tempObject);
    }

    public void removeObject(GameObject tempObject) {
        objects.remove(tempObject);
    }
}
