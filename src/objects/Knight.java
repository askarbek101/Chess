package objects;

import framework.Constants;
import framework.Coordinates;
import framework.ObjectId;
import utilities.SpriteSheet;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(float x, float y, boolean white, ObjectId objectId, SpriteSheet ss) {
        super(x, y, white, objectId, ss);
        if (white)
            setPieceImage(ss.grabImage(4, 1, Constants.BLOCK_SIZE, Constants.BLOCK_SIZE));
        else
            setPieceImage(ss.grabImage(4, 2, Constants.BLOCK_SIZE, Constants.BLOCK_SIZE));
    }

    @Override
    public ArrayList<Coordinates> possibleMoves() {
        return null;
    }
}
