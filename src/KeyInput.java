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
                    System.out.println(ObjectId.TestObject + " W");
                }
                if (key == KeyEvent.VK_A) {
                    System.out.println(ObjectId.TestObject + " A");
                }
                if (key == KeyEvent.VK_S) {
                    System.out.println(ObjectId.TestObject + " S");
                }
                if (key == KeyEvent.VK_D) {
                    System.out.println(ObjectId.TestObject + " D");
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        super.keyTyped(e);
    }
}
