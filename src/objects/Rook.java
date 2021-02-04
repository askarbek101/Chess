package objects;

import framework.Constants;
import framework.Coordinates;
import framework.ObjectId;
import utilities.SpriteSheet;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(float x, float y, ObjectId objectId, SpriteSheet ss) {
        super(x, y, objectId, ss);

        setPieceImage(ss.grabImage(5, 1, Constants.BLOCK_SIZE, Constants.BLOCK_SIZE));
    }

    @Override
    public ArrayList<Coordinates> possibleMoves() {
        return null;
    }
}
