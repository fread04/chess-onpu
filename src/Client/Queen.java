package Client;

import java.util.LinkedList;

class Queen extends Piece {

    public Queen(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.x, tile.getY() - this.y};

        // Client.Rook can only move in straight lines
        if (Math.abs(vector[0]) != 0 && Math.abs(vector[1]) != 0) {
            // Client.Bishop and Client.Queen can move diagonally
            if (Math.abs(vector[0]) != Math.abs(vector[1])) {
                return false;
            }
            // Check for any obstructions on the path of the bishop
            int xStep = Integer.signum(vector[0]);
            int yStep = Integer.signum(vector[1]);
            int x = this.x + xStep;
            int y = this.y + yStep;
            while (x != tile.getX() || y != tile.getY()) {
                if (tiles[y][x].isOccupied()) {
                    return false;
                }
                x += xStep;
                y += yStep;
            }
        } else {
            // Check for any obstructions on the path of the rook
            int xStep = Integer.signum(vector[0]);
            int yStep = Integer.signum(vector[1]);
            int x = this.x + xStep;
            int y = this.y + yStep;
            while (x != tile.getX() || y != tile.getY()) {
                if (tiles[y][x].isOccupied()) {
                    return false;
                }
                x += xStep;
                y += yStep;
            }
        }

        return true;
    }
}
