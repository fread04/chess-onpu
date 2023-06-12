package Client;

import java.util.LinkedList;

class Rook extends Piece {

    public Rook(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.getX(), tile.getY() - this.getY()};

        // Client.Rook can only move in straight lines
        if (Math.abs(vector[0]) != 0 && Math.abs(vector[1]) != 0) {
            return false;
        }

        // Check for any obstructions on the path of the rook
        int xStep = Integer.signum(vector[0]);
        int yStep = Integer.signum(vector[1]);
        int x = this.getX() + xStep;
        int y = this.getY() + yStep;
        while (x != tile.getX() || y != tile.getY()) {
            if (tiles[y][x].isOccupied()) {
                return false;
            }
            x += xStep;
            y += yStep;
        }

        return true;
    }
}
