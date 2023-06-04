package Client;

import javax.swing.*;
import java.awt.*;

public class Tile {
    private int x;
    private int y;
    private boolean isOccupied;
    private Piece piece;
    private JPanel panel;


    public Tile(int x, int y, boolean isOccupied) {
        this.x = x;
        this.y = y;
        this.isOccupied = isOccupied;
        createPanel();
    }

    private void createPanel() {
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BorderLayout());
        newPanel.setBounds(x * 64, y * 64, 64, 64);
        if((x + y) % 2 == 1) {
            newPanel.setBackground(new Color(42, 47, 54));
        } else {
            newPanel.setBackground(new Color(106, 119, 135));
        }
        panel = newPanel;
    }

    public void addLabelToPanel(JLabel label) {
        panel.add(label);
//        System.out.println(label);
    }

    public void removeLabelFromPanel(JPanel panel) {
        if(panel.getComponent(0) != null) {
            panel.remove(panel.getComponent(0));
            panel.revalidate();
            panel.repaint();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getCoordinates() {
        return new int[]{x, y};
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public JPanel getPanel() {
        return panel;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}