import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseInput extends MouseAdapter {
    Handler handler;

    public MouseInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);


        int mouseX = e.getX();
        int mouseY = e.getY();

        System.out.println(mouseX + " " + mouseY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        super.mouseWheelMoved(e);
    }
}
