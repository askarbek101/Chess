package objects;

import framework.Constants;
import framework.Coordinates;
import framework.ObjectId;
import utilities.SpriteSheet;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(float x, float y, boolean white, ObjectId objectId, SpriteSheet ss) {
        super(x, y, white, objectId, ss);
        if (white)
            setPieceImage(ss.grabImage(5, 1, Constants.BLOCK_SIZE, Constants.BLOCK_SIZE));
        else
            setPieceImage(ss.grabImage(5, 2, Constants.BLOCK_SIZE, Constants.BLOCK_SIZE));
    }

    @Override
    public ArrayList<Coordinates> possibleMoves() {
        return null;
    }
}
