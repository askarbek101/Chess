package objects;

import framework.Coordinates;
import framework.ObjectId;
import utilities.SpriteSheet;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(float x, float y, ObjectId objectId, SpriteSheet ss) {
        super(x, y, objectId, ss);

        setPiece_image(ss.grabImage(5, 1, 82, 82));
    }

    @Override
    public ArrayList<Coordinates> possibleMoves() {
        return null;
    }
}
