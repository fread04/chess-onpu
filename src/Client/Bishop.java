package Client;

import java.util.LinkedList;

class Bishop extends Piece {

    public Bishop(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.x, tile.getY() - this.y};
        if( Math.abs(vector[0]) == Math.abs(vector[1]) ) {
            if (this.x < tile.getX() && this.y < tile.getY()) {//right bottom
                int n = 0;
                for (int i = this.x + 1; i < tile.getX(); i++) {// x coordinate
                    for (int j = this.y + 1; j < tile.getY(); j += n) {//y coordinate
                        if ((vector[0] / (i - this.x)) == (vector[1] / (j - this.y))) {
                            if (tiles[j][i].isOccupied()) {
                                return false;
                            }
                        }
                        n++;
                    }
                }
                return (vector[0] / (tile.getX() - this.x)) == (vector[1] / (tile.getY() - this.y));
            } else if (this.x > tile.getX() && this.y > tile.getY()) {//left top
                int n = 0;
                for (int i = this.x - 1; i >= tile.getX(); i--) {// x coordinate
                    for (int j = this.y - 1; j >= tile.getY(); j -= n) {//y coordinate
                        if ((vector[0] / (i - this.x)) == (vector[1] / (j - this.y))) {
                            if (tiles[j][i].isOccupied()) {
                                return false;
                            }
                        }
                        n++;
                    }
                }
                return (vector[0] / (tile.getX() - this.x)) == (vector[1] / (tile.getY() - this.y));
            } else if (this.x < tile.getX() && this.y > tile.getY()) {//right top
                int n = 0;
                for (int i = this.x + 1; i < tile.getX(); i++) {// x coordinate
                    for (int j = this.y - 1; j >= tile.getY(); j -= n) {//y coordinate
                        if ((vector[0] / (i - this.x)) == (vector[1] / (j - this.y))) {
                            if (tiles[j][i].isOccupied()) {
                                return false;
                            }
                        }
                        n++;
                    }
                }
                return (vector[0] / (tile.getX() - this.x)) == (vector[1] / (tile.getY() - this.y));
            } else if (this.x > tile.getX() && this.y < tile.getY()) {//left bottom
                int n = 0;
                for (int i = this.x - 1; i >= tile.getX(); i--) {//x coordinate
                    for (int j = this.y + 1; j < tile.getY(); j += n) {//y coordinate
                        if ((vector[0] / (i - this.x)) == (vector[1] / (j - this.y))) {
                            if (tiles[j][i].isOccupied()) {
                                return false;
                            }
                        }
                        n++;
                    }
                }
                return (vector[0] / (tile.getX() - this.x)) == (vector[1] / (tile.getY() - this.y));
            }
        }
        return false;
    }
}
