import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

abstract class Piece {
    public int x;
    public int y;
    private final boolean isWhite;
    private final LinkedList<Piece> pieceList;
    private boolean isPieceSelected = false;
    private final String name;
    private final String path;

    public Piece(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.pieceList = pieceList;
        this.name = name;
        this.path = path;
        pieceList.add(this);
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private ImageIcon scaleImg(int w, int h) { //scaling img that we are getting
        ImageIcon imageIcon = new ImageIcon(path);
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    public abstract boolean moveValidator(Tile tile, Tile[][] tiles);

    public abstract boolean validMoves(Tile tile, Tile[][] tiles);

    public void selectPiece() {
        isPieceSelected = true;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImgIcon() {
        return scaleImg(50, 50);
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public boolean isPieceSelected() {return this.isPieceSelected;}

}

class Pawn extends Piece {
    public Pawn(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }
    boolean isPawnMoved = false;
    private final int[][] validVectors = new int[][]{{0, -1}, {0, -2}, {1, -1}, {-1, -1}};
    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {//REDO
        validMoves(tile, tiles);
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
    @Override
    public boolean validMoves(Tile tile, Tile[][] tiles) {//REDO
        int[][] vector = new int[1][2];

        vector[0][0] = tile.getX() - this.x;
        vector[0][1] = tile.getY() - this.y;

        System.out.println("vector x coord: " + vector[0]);

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 2; j++){
                return validVectors[i][j] == vector[0][j];
            }
        }

        return false;
    }
}

class Rook extends Piece {

    public Rook(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.x, tile.getY() - this.y};

        // Rook can only move in straight lines
        if (Math.abs(vector[0]) != 0 && Math.abs(vector[1]) != 0) {
            return false;
        }

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

        return true;
    }

    @Override
    public boolean validMoves(Tile tile, Tile[][] tiles) {
        return false;
    }
}

class Knight extends Piece {

    public Knight(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.x, tile.getY() - this.y};
        return (Math.abs(vector[0]) == 1 && Math.abs(vector[1]) == 2) || (Math.abs(vector[0]) == 2 && Math.abs(vector[1]) == 1);
    }


    @Override
    public boolean validMoves(Tile tile, Tile[][] tiles) {
        int[] vector = new int[2];
        int[][] vectors = new int[8][2];



//        if(Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2)) == Math.sqrt(5)) {
//            return
//        }
        return false;
    }
}

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

    @Override
    public boolean validMoves(Tile tile, Tile[][] tiles) {
        return false;
    }
}

class Queen extends Piece {

    public Queen(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.x, tile.getY() - this.y};

        // Rook can only move in straight lines
        if (Math.abs(vector[0]) != 0 && Math.abs(vector[1]) != 0) {
            // Bishop and Queen can move diagonally
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


    @Override
    public boolean validMoves(Tile tile, Tile[][] tiles) {
        return false;
    }
}

class King extends Piece {

    public King(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.x, tile.getY() - this.y};
        if (Math.abs(vector[0]) > 1 || Math.abs(vector[1]) > 1) {
            // King can move only one square in any direction
            return false;
        }
        // Check for any obstructions on the path of the King (there shouldn't be any)
        return !tile.isOccupied();
    }

    @Override
    public boolean validMoves(Tile tile, Tile[][] tiles) {
        return false;
    }
}
