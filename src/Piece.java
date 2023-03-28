import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Piece {
    int x;
    int y;
    boolean isWhite;
    LinkedList<Piece> pieceList;
    String name;
    String path;

    public Piece(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.pieceList = pieceList;
        this.name = name;
        this.path = path;
    }

    public void move(int x, int y) {
        pieceList.stream().filter(p -> (p.x == this.x && p.y == this.y)).forEachOrdered(Piece::kill);

        this.x = x;
        this.y = y;
    }

    public void kill() {
        pieceList.remove(this);
    }

    private ImageIcon scaleImg(int w, int h) { //scaling img that we are getting
        ImageIcon imageIcon = new ImageIcon(path);
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);

        return new ImageIcon(newImg);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public ImageIcon getImgIcon() {
        return scaleImg(52, 52);
    }

    public boolean isWhite() {
        return this.isWhite;
    }
}

class Pawn extends Piece {

    public Pawn(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }
}

class Rook extends Piece {

    public Rook(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }
}

class Knight extends Piece {

    public Knight(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }
}

class Bishop extends Piece {

    public Bishop(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }
}

class Queen extends Piece {

    public Queen(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }
}

class King extends Piece {

    public King(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }
}
