package Client;

import java.util.LinkedList;

class Pawn extends Piece {
    boolean isPawnMoved = false;

    public Pawn(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {//TODO: redo
        int[] vector = new int[]{tile.getX() - this.getX(), tile.getY() - this.getY()};
        if (!isPawnMoved) {
            return (vector[0] == 0) && (Math.abs(vector[1]) == 1 || Math.abs(vector[1]) == 2);
        } else {
            return (vector[0] == 0) && Math.abs(vector[1]) == 1;
        }
    }

    @Override
    public boolean captureValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.getX(), tile.getY() - this.getY()};
        return (Math.abs(vector[0]) == 1) && Math.abs(vector[1]) == 1;
    }

    @Override
    public void setPawnMoved() {
        isPawnMoved = true;
    }
}
