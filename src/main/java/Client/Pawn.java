package Client;

import java.util.LinkedList;

class Pawn extends Piece {
    public Pawn(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }
    boolean isPawnMoved = false;
    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {//TODO: redo
        if (!isPawnMoved) {
            if (this.getX() == tile.getX() && Math.abs(this.getY() - tile.getY()) == 1 || Math.abs(this.getY() - tile.getY()) == 2) {
                isPawnMoved = true;
                return true;
            } else if(Math.abs(this.getX() - tile.getX()) == 1 && Math.abs(this.getY() - tile.getY()) == 1 &&
                    tiles[tile.getX()][tile.getY()].isOccupied() && tile.getPiece().isWhite() != tiles[tile.getX()][tile.getY()].getPiece().isWhite()) {
                return true;
            }
        } else {
            if(this.getX() == tile.getX() && Math.abs(this.getY() - tile.getY()) == 1) {
                return true;
            } else if(Math.abs(this.getX() - tile.getX()) == 1 && Math.abs(this.getY() - tile.getY()) == 1 &&
                    tiles[tile.getX()][tile.getY()].isOccupied() && tile.getPiece().isWhite() != tiles[tile.getX()][tile.getY()].getPiece().isWhite()) {
                return true;
            }
        }
        return false;
    }
}
