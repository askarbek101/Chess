package utilities;

import framework.Constants;
import framework.GameObject;
import framework.ObjectId;
import window.Game;
import window.Handler;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseInput extends MouseAdapter {
    private final Handler handler;
    private boolean mousePressed = false;
    private GameObject object;

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
        for (GameObject tempObject: handler.objects) {
            if (tempObject.objectId != ObjectId.Block && tempObject.getBounds().contains(e.getPoint())) {
                System.out.println(tempObject.objectId);
                System.out.println(e.getPoint().toString());

                tempObject.setX(e.getX() - Constants.BLOCK_SIZE / 2);
                tempObject.setY(e.getY() - Constants.BLOCK_SIZE / 2);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("asd");
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        super.mouseWheelMoved(e);
    }
}
