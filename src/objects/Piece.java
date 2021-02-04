package objects;

import framework.Constants;
import framework.Coordinates;
import framework.GameObject;
import framework.ObjectId;
import utilities.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Piece extends GameObject {

    private BufferedImage pieceImage;

    public Piece(float x, float y, ObjectId objectId, SpriteSheet ss) {
        super(x, y, objectId);


    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(pieceImage, (int) x, (int) getY(), Constants.BLOCK_SIZE, Constants.BLOCK_SIZE, null);

        g.setColor(Color.BLACK);
        g.drawRect((int) getX(), (int) getY(), Constants.BLOCK_SIZE, Constants.BLOCK_SIZE);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) getX(), (int) getY(), Constants.BLOCK_SIZE, Constants.BLOCK_SIZE);
    }

    public abstract ArrayList<Coordinates> possibleMoves();

    public BufferedImage getPieceImage() {
        return pieceImage;
    }

    public void setPieceImage(BufferedImage pieceImage) {
        this.pieceImage = pieceImage;
    }

}
