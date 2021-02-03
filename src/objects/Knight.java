package objects;

import framework.Coordinates;
import framework.ObjectId;
import utilities.SpriteSheet;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(float x, float y, ObjectId objectId, SpriteSheet ss) {
        super(x, y, objectId, ss);

        setPiece_image(ss.grabImage(4, 1, 82, 82));
    }

    @Override
    public ArrayList<Coordinates> possibleMoves() {
        return null;
    }
}
