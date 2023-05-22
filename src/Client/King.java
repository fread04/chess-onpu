package Client;

import java.util.LinkedList;
import java.util.Objects;

class King extends Piece implements checkMateValidator{

    public King(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.x, tile.getY() - this.y};
        if (Math.abs(vector[0]) > 1 || Math.abs(vector[1]) > 1) {
            // Client.King can move only one square in any direction
            return false;
        }
        // Check for any obstructions on the path of the Client.King (there shouldn't be any)
        return !tile.isOccupied();
    }

    @Override
    public boolean validCheck(LinkedList<Piece> pieceLinkedList, Tile tile) {
        if(this.isWhite()) {
            return true;
        } else {
            return true;
        }



        return false;
    }

    @Override
    public boolean validMate(LinkedList<Piece> pieceLinkedList, Tile tile) {
        return false;
    }
}

