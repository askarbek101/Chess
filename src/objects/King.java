package objects;

import framework.Coordinates;
import framework.ObjectId;
import utilities.SpriteSheet;

import java.util.ArrayList;

public class King extends Piece {
    public King(float x, float y, ObjectId objectId, SpriteSheet ss) {
        super(x, y, objectId, ss);

        setPiece_image(ss.grabImage(1, 1, 82, 82));
    }

    @Override
    public ArrayList<Coordinates> possibleMoves() {
        return null;
    }
}
