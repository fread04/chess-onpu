package Client;

import java.util.LinkedList;

class Pawn extends Piece {
    public Pawn(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }
    boolean isPawnMoved = false;
    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {//REDO
        if (!isPawnMoved) {
            if (this.x == tile.getX() && Math.abs(this.y - tile.getY()) == 1 || Math.abs(this.y - tile.getY()) == 2) {
                isPawnMoved = true;
                return true;
            } else if(Math.abs(this.x - tile.getX()) == 1 && Math.abs(this.y - tile.getY()) == 1 &&
                    tiles[tile.getX()][tile.getY()].isOccupied() && tile.getPiece().isWhite() != tiles[tile.getX()][tile.getY()].getPiece().isWhite()) {
                return true;
            }
        } else {
            if(this.x == tile.getX() && Math.abs(this.y - tile.getY()) == 1) {
                return true;
            } else if(Math.abs(this.x - tile.getX()) == 1 && Math.abs(this.y - tile.getY()) == 1 &&
                    tiles[tile.getX()][tile.getY()].isOccupied() && tile.getPiece().isWhite() != tiles[tile.getX()][tile.getY()].getPiece().isWhite()) {
                return true;
            }
        }
        return false;
    }
}
