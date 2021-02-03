package objects;

import framework.Coordinates;
import framework.GameObject;
import framework.ObjectId;
import utilities.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Piece extends GameObject {

    private BufferedImage piece_image;

    public Piece(float x, float y, ObjectId objectId, SpriteSheet ss) {
        super(x, y, objectId);


    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(piece_image, (int) getX(), (int) getY(), null);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    public abstract ArrayList<Coordinates> possibleMoves();

    public BufferedImage getPiece_image() {
        return piece_image;
    }

    public void setPiece_image(BufferedImage piece_image) {
        this.piece_image = piece_image;
    }

}
