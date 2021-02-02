import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObject tempObject: handler.objects) {
            if (tempObject.getObjectId() == ObjectId.TestObject) {
                if (key == KeyEvent.VK_W) {
                    System.out.println(ObjectId.TestObject + " W key pressed");
                }
                if (key == KeyEvent.VK_A) {
                    System.out.println(ObjectId.TestObject + " A key pressed");
                }
                if (key == KeyEvent.VK_S) {
                    System.out.println(ObjectId.TestObject + " S key pressed");
                }
                if (key == KeyEvent.VK_D) {
                    System.out.println(ObjectId.TestObject + " D key pressed");
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObject tempObject: handler.objects) {
            if (tempObject.getObjectId() == ObjectId.TestObject) {
                if (key == KeyEvent.VK_W) {
                    System.out.println(ObjectId.TestObject + " W key released");
                }
                if (key == KeyEvent.VK_A) {
                    System.out.println(ObjectId.TestObject + " A key released");
                }
                if (key == KeyEvent.VK_S) {
                    System.out.println(ObjectId.TestObject + " S key released");
                }
                if (key == KeyEvent.VK_D) {
                    System.out.println(ObjectId.TestObject + " D key released");
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        super.keyTyped(e);
    }
}
