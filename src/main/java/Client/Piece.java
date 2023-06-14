package Client;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

abstract public class Piece {
    private int x;
    private int y;
    private final boolean isWhite;
    private final String name;
    private final String path;

    public Piece(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
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

    public boolean captureValidator(Tile tile, Tile[][] tiles) {
        return false;
    }

    public void setPawnMoved() {}
}
