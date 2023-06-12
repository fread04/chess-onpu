package Client;

import java.util.LinkedList;

class Knight extends Piece {

    public Knight(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.getX(), tile.getY() - this.getY()};
        return (Math.abs(vector[0]) == 1 && Math.abs(vector[1]) == 2) || (Math.abs(vector[0]) == 2 && Math.abs(vector[1]) == 1);
    }
}
