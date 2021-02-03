package objects;

import framework.Coordinates;
import framework.ObjectId;
import utilities.SpriteSheet;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(float x, float y, ObjectId objectId, SpriteSheet ss) {
        super(x, y, objectId, ss);

        setPiece_image(ss.grabImage(3, 1, 82, 82));
    }


    @Override
    public ArrayList<Coordinates> possibleMoves() {
        return null;
    }

}
