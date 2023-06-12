package Client;

import Server.Server;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.LinkedList;

public class Board {
    private final JFrame frame = new JFrame();
    private final Tile[][] tiles = new Tile[8][8];
    private JFrame mainFrame;
    private Client client;
    private Server server;
    public LinkedList<Piece> pieceList = new LinkedList<>();
    private Piece selectedPiece;
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.setPrettyPrinting().create();
    private Tile oldTile;


    public Board(JFrame mainFrame, Client client) {
        this.mainFrame = mainFrame;
        this.client = client;
//        this.client.initBoard(this);

        initFrame();
        drawBoard();
        moveableBoard();
        frame.setVisible(true);
    }

    public Board(JFrame mainFrame, Server server) {
        this.mainFrame = mainFrame;
        this.server = server;
//        this.server.initBoard(this);

        initFrame();
        drawBoard();
        moveableBoard();
        frame.setVisible(true);
    }

    public Board() {
        initFrame();
        drawBoard();
        moveableBoard();
        frame.setVisible(true);
    }

    private void initFrame() {
        frame.setBounds(700, 200,  526, 548);
        frame.setTitle("Chess Client.Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
    }

    private void drawBoard() {
        for(int i = 0; i < tiles.length; i++) { //y coord
            for (int j = 0; j < tiles.length; j++) {// x coord
                tiles[j][i] = new Tile(i, j, false);
            }
        }

        drawPieces();

        for(int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                frame.add(tiles[i][j].getPanel());
            }
        }
    }

    private void drawPieces() {
        Rook rookBlackLeft          = new   Rook(0, 0, false, pieceList, "rook", "src/main/img/b_rook_png_128px.png");
        Knight knightBlackLeft      = new Knight(1, 0, false, pieceList, "knight", "src/main/img/b_knight_png_128px.png");
        Bishop bishopBlackLeft      = new Bishop(2, 0, false, pieceList, "bishop", "src/main/img/b_bishop_png_128px.png");
        Queen queenBlack            = new  Queen(3, 0, false, pieceList, "queen", "src/main/img/b_queen_png_128px.png");
        King kingBlack              = new   King(4, 0, false, pieceList, "king", "src/main/img/b_king_png_128px.png");
        Bishop bishopBlackRight     = new Bishop(5, 0, false, pieceList, "bishop", "src/main/img/b_bishop_png_128px.png");
        Knight knightBlackRight     = new Knight(6, 0, false, pieceList, "knight", "src/main/img/b_knight_png_128px.png");
        Rook rookBlackRight         = new   Rook(7, 0, false, pieceList, "rook", "src/main/img/b_rook_png_128px.png");

        Pawn pawnBlackA = new Pawn(0, 1, false, pieceList, "pawn", "src/main/img/b_pawn_png_128px.png");
        Pawn pawnBlackC = new Pawn(1, 1, false, pieceList, "pawn", "src/main/img/b_pawn_png_128px.png");
        Pawn pawnBlackD = new Pawn(2, 1, false, pieceList, "pawn", "src/main/img/b_pawn_png_128px.png");
        Pawn pawnBlackB = new Pawn(3, 1, false, pieceList, "pawn", "src/main/img/b_pawn_png_128px.png");
        Pawn pawnBlackE = new Pawn(4, 1, false, pieceList, "pawn", "src/main/img/b_pawn_png_128px.png");
        Pawn pawnBlackF = new Pawn(5, 1, false, pieceList, "pawn", "src/main/img/b_pawn_png_128px.png");
        Pawn pawnBlackG = new Pawn(6, 1, false, pieceList, "pawn", "src/main/img/b_pawn_png_128px.png");
        Pawn pawnBlackH = new Pawn(7, 1, false, pieceList, "pawn", "src/main/img/b_pawn_png_128px.png");

        Pawn pawnWhiteA = new Pawn(0, 6, true, pieceList, "pawn", "src/main/img/w_pawn_png_128px.png");
        Pawn pawnWhiteB = new Pawn(1, 6, true, pieceList, "pawn", "src/main/img/w_pawn_png_128px.png");
        Pawn pawnWhiteC = new Pawn(2, 6, true, pieceList, "pawn", "src/main/img/w_pawn_png_128px.png");
        Pawn pawnWhiteD = new Pawn(3, 6, true, pieceList, "pawn", "src/main/img/w_pawn_png_128px.png");
        Pawn pawnWhiteE = new Pawn(4, 6, true, pieceList, "pawn", "src/main/img/w_pawn_png_128px.png");
        Pawn pawnWhiteF = new Pawn(5, 6, true, pieceList, "pawn", "src/main/img/w_pawn_png_128px.png");
        Pawn pawnWhiteG = new Pawn(6, 6, true, pieceList, "pawn", "src/main/img/w_pawn_png_128px.png");
        Pawn pawnWhiteH = new Pawn(7, 6, true, pieceList, "pawn", "src/main/img/w_pawn_png_128px.png");

        Rook rookWhiteLeft          = new   Rook(0, 7, true, pieceList, "rook", "src/main/img/w_rook_png_128px.png");
        Knight knightWhiteLeft      = new Knight(1, 7, true, pieceList, "knight", "src/main/img/w_knight_png_128px.png");
        Bishop bishopWhiteLeft      = new Bishop(2, 7, true, pieceList, "bishop", "src/main/img/w_bishop_png_128px.png");
        Queen queenWhite            = new  Queen(3, 7, true, pieceList, "queen", "src/main/img/w_queen_png_128px.png");
        King kingWhite              = new   King(4, 7, true, pieceList, "king", "src/main/img/w_king_png_128px.png");
        Bishop bishopWhiteRight     = new Bishop(5, 7, true, pieceList, "bishop", "src/main/img/w_bishop_png_128px.png");
        Knight knightWhiteRight     = new Knight(6, 7, true, pieceList, "knight", "src/main/img/w_knight_png_128px.png");
        Rook rookWhiteRight         = new   Rook(7, 7, true, pieceList, "rook", "src/main/img/w_rook_png_128px.png");


        for(int i = 0, index = 0; i < tiles.length; i++) {//adding pieces to their tiles
            for(int j = 0; j < tiles.length; j++) {
                if(pieceList.get(index).getY() == i && pieceList.get(index).getX() == j) {
                    tiles[i][j].setPiece(pieceList.get(index));
                    tiles[i][j].addLabelToPanel(new JLabel(pieceList.get(index).getImgIcon()));
                    tiles[i][j].setOccupied(true);
                    index++;
                }
            }
        }
    }

    private void moveableBoard() {

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    makeMove(e);
                } catch (Exception ex) {
                    selectedPiece = null;
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    private Piece getPiece(int x, int y) {
        for(Piece p : pieceList) {
            if(p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }

    private Piece getPiece() {
        return null;
    }

    private Tile getTile(int x, int y) {
        for (Tile[] tile : tiles) {
            for (int j = 0; j < tiles.length; j++) {
                if (tile[j].getCoordinates()[0] == x && tile[j].getCoordinates()[1] == y) {
                    return tile[j];
                }
            }
        }
        return null;
    }

    private void makeMove(MouseEvent e) throws Exception {
        if(getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64)).isOccupied()) {// take a piece if there is no piece
            if(selectedPiece != null && getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64)).getPiece().isWhite() != selectedPiece.isWhite()) {
                Tile newTile = getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));//get tile where to move piece
                switch (selectedPiece.getName()) {
                    case "pawn", "knight", "bishop", "rook", "king", "queen" -> {
                        if (selectedPiece.moveValidator(newTile, tiles)) {

                            System.out.println(this.client);
                            if(client != null) {
                                client.write(selectedPiece.getX() + " " + selectedPiece.getY() + " " + (e.getX() - 8) / 64 + " " + (e.getY() - 31) / 64);
                            }
                            System.out.println(this.server);
                            if(server != null) {
                                server.getHandler().write(selectedPiece.getX() + " " + selectedPiece.getY() + " " + (e.getX() - 8) / 64 + " " + (e.getY() - 31) / 64);
                            }

                            capture(e, newTile);
                        } else {
                            throw new IllegalAccessException("move isn't valid");
                        }
                    }
                    default -> System.out.println("something got wrong");
                }
            } else {
                selectedPiece = getPiece(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));
                oldTile = getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));
            }

        } else if(!getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64)).isOccupied()) {// if there isn't a piece then move it according to the rules
            if(selectedPiece != null) {
                Tile newTile = getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));//get tile where to move piece
                switch (selectedPiece.getName()) {
                    case "pawn", "knight", "bishop", "rook", "king", "queen" -> {
                        if (selectedPiece.moveValidator(newTile, tiles)) {

                            if(client != null) {
                                client.write(selectedPiece.getX() + " " + selectedPiece.getY() + " " + (e.getX() - 8) / 64 + " " + (e.getY() - 31) / 64);
                            }

                            if(server != null) {
                                server.getHandler().write(selectedPiece.getX() + " " + selectedPiece.getY() + " " + ((e.getX() - 8) / 64) + " " + ((e.getY() - 31) / 64));
                            }

                            performMove(e, newTile);
                        } else {
                            throw new IllegalAccessException(selectedPiece.getName() + "'s move isn't valid");
                        }
                    }
                    default -> System.out.println("something got wrong");
                }
            }
        }
    }

    private void performMove(MouseEvent e, Tile tile) {
        selectedPiece.move(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));

        //setting piece to new tile
        tile.setPiece(selectedPiece);
        tile.addLabelToPanel(new JLabel(selectedPiece.getImgIcon()));
        tile.setOccupied(true);

        //removing from old tile
        oldTile.setOccupied(false);
        oldTile.removeLabelFromPanel(oldTile.getPanel());
        oldTile.setPiece(null);

        //setting variable to null for future work
        selectedPiece = null;
    }

    public void performMove(int oldX, int oldY, int curX, int curY) {


        selectedPiece = tiles[oldY][oldX].getPiece();

        tiles[curY][curX].setPiece(selectedPiece);
        tiles[curY][curX].addLabelToPanel(new JLabel(selectedPiece.getImgIcon()));
        tiles[curY][curX].setOccupied(true);

        //removing from old tile

//        tiles[oldX][oldY].setOccupied(false);
//        tiles[oldX][oldY].removeLabelFromPanel(oldTile.getPanel());
//        tiles[oldX][oldY].setPiece(null);

        tiles[oldY][oldX].setOccupied(false);
        tiles[oldY][oldX].removeLabelFromPanel(tiles[oldY][oldX].getPanel());
        tiles[oldY][oldX].setPiece(null);

        //setting variable to null for future work
        selectedPiece = null;
    }

    private void capture(MouseEvent e, Tile tile) {
        pieceList.remove(tile.getPiece());
        selectedPiece.move(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));
        //deleting if there is a piece from new tile
        tile.removeLabelFromPanel(tile.getPanel());
        tile.setPiece(null);

        //setting new tile
        tile.setPiece(selectedPiece);
        tile.addLabelToPanel(new JLabel(selectedPiece.getImgIcon()));

        //removing from old tile
        oldTile.removeLabelFromPanel(oldTile.getPanel());
        oldTile.setPiece(null);
        oldTile.setOccupied(false);

        //setting variable to null for future work
        selectedPiece = null;
    }



    public JFrame getFrame() {
        return frame;
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
