package Client;

import java.util.LinkedList;

class Bishop extends Piece {

    public Bishop(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.getX(), tile.getY() - this.getY()};
        if (Math.abs(vector[0]) == Math.abs(vector[1])) {
            int startX = this.getX();
            int startY = this.getY();
            int stepX = Integer.compare(vector[0], 0);
            int stepY = Integer.compare(vector[1], 0);

            for (int i = 1; i < Math.abs(vector[0]); i++) {
                int nextX = startX + i * stepX;
                int nextY = startY + i * stepY;

                if (tiles[nextY][nextX].isOccupied()) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }
}
