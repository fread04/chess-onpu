package Client;

import java.util.LinkedList;

class Bishop extends Piece {

    public Bishop(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.getX(), tile.getY() - this.getY()};
        if( Math.abs(vector[0]) == Math.abs(vector[1]) ) {
            if (this.getX() < tile.getX() && this.getY() < tile.getY()) {//right bottom
                int n = 0;
                for (int i = this.getX() + 1; i < tile.getX(); i++) {// x coordinate
                    for (int j = this.getY() + 1; j < tile.getY(); j += n) {//y coordinate
                        if ((vector[0] / (i - this.getX())) == (vector[1] / (j - this.getY()))) {
                            if (tiles[j][i].isOccupied()) {
                                return false;
                            }
                        }
                        n++;
                    }
                }
                return (vector[0] / (tile.getX() - this.getX())) == (vector[1] / (tile.getY() - this.getY()));
            } else if (this.getX() > tile.getX() && this.getY() > tile.getY()) {//left top
                int n = 0;
                for (int i = this.getX() - 1; i >= tile.getX(); i--) {// x coordinate
                    for (int j = this.getY() - 1; j >= tile.getY(); j -= n) {//y coordinate
                        if ((vector[0] / (i - this.getX())) == (vector[1] / (j - this.getY()))) {
                            if (tiles[j][i].isOccupied()) {
                                return false;
                            }
                        }
                        n++;
                    }
                }
                return (vector[0] / (tile.getX() - this.getX())) == (vector[1] / (tile.getY() - this.getY()));
            } else if (this.getX() < tile.getX() && this.getY() > tile.getY()) {//right top
                int n = 0;
                for (int i = this.getX() + 1; i < tile.getX(); i++) {// x coordinate
                    for (int j = this.getY() - 1; j >= tile.getY(); j -= n) {//y coordinate
                        if ((vector[0] / (i - this.getX())) == (vector[1] / (j - this.getY()))) {
                            if (tiles[j][i].isOccupied()) {
                                return false;
                            }
                        }
                        n++;
                    }
                }
                return (vector[0] / (tile.getX() - this.getX())) == (vector[1] / (tile.getY() - this.getY()));
            } else if (this.getX() > tile.getX() && this.getY() < tile.getY()) {//left bottom
                int n = 0;
                for (int i = this.getX() - 1; i >= tile.getX(); i--) {//x coordinate
                    for (int j = this.getY() + 1; j < tile.getY(); j += n) {//y coordinate
                        if ((vector[0] / (i - this.getX())) == (vector[1] / (j - this.getY()))) {
                            if (tiles[j][i].isOccupied()) {
                                return false;
                            }
                        }
                        n++;
                    }
                }
                return (vector[0] / (tile.getX() - this.getX())) == (vector[1] / (tile.getY() - this.getY()));
            }
        }
        return false;
    }
}
