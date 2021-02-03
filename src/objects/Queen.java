package objects;

import framework.Coordinates;
import framework.ObjectId;
import utilities.SpriteSheet;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(float x, float y, ObjectId objectId, SpriteSheet ss) {
        super(x, y, objectId, ss);
    }

    @Override
    public ArrayList<Coordinates> possibleMoves() {
        return null;
    }
}
