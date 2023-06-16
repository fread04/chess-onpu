package Client;

import Server.Server;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.Objects;

public class Board {
    private final JFrame frame = new JFrame();
    private final Tile[][] tiles = new Tile[8][8];
    private ValidatorLegitMoves validatorLegitMoves;
    private JFrame mainFrame; //to reopen main frame when the game is over
    private Client client;
    private Server server;
    public LinkedList<Piece> pieceList = new LinkedList<>();
    private Piece selectedPiece;
    private Tile oldTile;
    private boolean CLIENT_COLOR;
    private boolean SERVER_COLOR;


    public Board(JFrame mainFrame, Client client) {
        this.mainFrame = mainFrame;
        this.client = client;
        CLIENT_COLOR = client.getPlayer().getColor();

        initFrame();
        drawBoard();
        initValidatorLegitMoves();
        moveableBoard();
        frame.setVisible(true);
    }

    public Board(JFrame mainFrame, Server server) {
        this.mainFrame = mainFrame;
        this.server = server;
        SERVER_COLOR = server.getPlayer().getColor();

        initFrame();
        drawBoard();
        initValidatorLegitMoves();
        moveableBoard();
        frame.setVisible(true);
    }

    public Board() {
        initFrame();
        drawBoard();
        initValidatorLegitMoves();
        moveableBoard();
        frame.setVisible(true);
    }

    private void initFrame() {
        frame.setBounds(700, 200, 526, 548);
        frame.setTitle("Chess Client.Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
    }

    private void drawBoard() {
        for (int i = 0; i < tiles.length; i++) { //y coord
            for (int j = 0; j < tiles.length; j++) {// x coord
                tiles[j][i] = new Tile(i, j, false);
            }
        }

        drawPieces();

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                frame.add(tiles[i][j].getPanel());
            }
        }
    }

    private void initValidatorLegitMoves() {
        validatorLegitMoves = new ValidatorLegitMoves(tiles);
    }

    private void drawPieces() {
        Rook rookBlackLeft = new Rook(0, 0, false, pieceList, "rook", "src/main/img/b_rook_png_128px.png");
        Knight knightBlackLeft = new Knight(1, 0, false, pieceList, "knight", "src/main/img/b_knight_png_128px.png");
        Bishop bishopBlackLeft = new Bishop(2, 0, false, pieceList, "bishop", "src/main/img/b_bishop_png_128px.png");
        Queen queenBlack = new Queen(3, 0, false, pieceList, "queen", "src/main/img/b_queen_png_128px.png");
        King kingBlack = new King(4, 0, false, pieceList, "king", "src/main/img/b_king_png_128px.png");
        Bishop bishopBlackRight = new Bishop(5, 0, false, pieceList, "bishop", "src/main/img/b_bishop_png_128px.png");
        Knight knightBlackRight = new Knight(6, 0, false, pieceList, "knight", "src/main/img/b_knight_png_128px.png");
        Rook rookBlackRight = new Rook(7, 0, false, pieceList, "rook", "src/main/img/b_rook_png_128px.png");

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

        Rook rookWhiteLeft = new Rook(0, 7, true, pieceList, "rook", "src/main/img/w_rook_png_128px.png");
        Knight knightWhiteLeft = new Knight(1, 7, true, pieceList, "knight", "src/main/img/w_knight_png_128px.png");
        Bishop bishopWhiteLeft = new Bishop(2, 7, true, pieceList, "bishop", "src/main/img/w_bishop_png_128px.png");
        Queen queenWhite = new Queen(3, 7, true, pieceList, "queen", "src/main/img/w_queen_png_128px.png");
        King kingWhite = new King(4, 7, true, pieceList, "king", "src/main/img/w_king_png_128px.png");
        Bishop bishopWhiteRight = new Bishop(5, 7, true, pieceList, "bishop", "src/main/img/w_bishop_png_128px.png");
        Knight knightWhiteRight = new Knight(6, 7, true, pieceList, "knight", "src/main/img/w_knight_png_128px.png");
        Rook rookWhiteRight = new Rook(7, 7, true, pieceList, "rook", "src/main/img/w_rook_png_128px.png");


        for (int i = 0, index = 0; i < tiles.length; i++) {//adding pieces to their tiles
            for (int j = 0; j < tiles.length; j++) {
                if (pieceList.get(index).getY() == i && pieceList.get(index).getX() == j) {
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

    public Piece getPiece(int x, int y) {
        for (Piece p : pieceList) {
            if (p.getX() == x && p.getY() == y) {
                if (client != null && CLIENT_COLOR == p.isWhite() && client.getPlayer().isActiveTurn()) {
                    return p;
                } else if (server != null && SERVER_COLOR == p.isWhite() && server.getPlayer().isActiveTurn()) {
                    return p;
                } else if (server == null && client == null) {
                    return p;
                }
            }
        }
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

    private boolean isChecked(){
        Piece tempKingPiece = null;
        for(Piece piece : pieceList) {
            if((piece.isWhite() == selectedPiece.isWhite()) && (Objects.equals(piece.getName(), "king"))) {
                tempKingPiece = piece;
            }
        }
        for(Piece piece : pieceList) {
            if((piece.isWhite() != tempKingPiece.isWhite()) && ((!Objects.equals(piece.getName(), "pawn")
                && piece.moveValidator(tiles[tempKingPiece.getX()][tempKingPiece.getY()], tiles))
                || (Objects.equals(piece.getName(), "pawn")
                && piece.captureValidator(tiles[tempKingPiece.getX()][tempKingPiece.getY()], tiles)))) {
                return true;
            }
        }
        return false;
    }
    private void makeMove(MouseEvent e) throws Exception {
        if (getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64)).isOccupied()) {// take a piece if there is no piece
            if (selectedPiece != null && getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64)).getPiece().isWhite() != selectedPiece.isWhite()) {
                Tile newTile = getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));//get tile where to move piece
                switch (selectedPiece.getName()) {
                    case "pawn", "knight", "bishop", "rook", "king", "queen" -> {
                        if ((Objects.equals(selectedPiece.getName(), "pawn") && selectedPiece.captureValidator(newTile, tiles))
                        || (!Objects.equals(selectedPiece.getName(), "pawn") && selectedPiece.moveValidator(newTile, tiles))) {
                            // write signature: writing to server message with this prototype:
                            // (current position of piece "x, y" + coordinates of clicked tile "x, y" + move(0 - performMove, 1 - capture))
                            if (client != null) {
                                client.write(selectedPiece.getX() + " " + selectedPiece.getY() + " " + (e.getX() - 8) / 64 + " " + (e.getY() - 31) / 64 + " 1");
                                client.getPlayer().switchTurn();
                            }
                            if (server != null) {
                                server.getHandler().write(selectedPiece.getX() + " " + selectedPiece.getY() + " " + (e.getX() - 8) / 64 + " " + (e.getY() - 31) / 64 + " 1");
                                server.getPlayer().switchTurn();
                            }

                            validatorLegitMoves.removeLegitMovesFromPanel(tiles);
                            capture(e, newTile);
                        } else {
                            validatorLegitMoves.removeLegitMovesFromPanel(tiles);
                            throw new IllegalAccessException("move to capture isn't valid");
                        }
                    }
                    default -> System.out.println("something got wrong");
                }
            } else {
                selectedPiece = getPiece(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));
                oldTile = getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));
                if(isChecked()) {
                    System.out.println("is check");
                }
                validatorLegitMoves.validateLegitMoves(selectedPiece);
            }

        } else if (!getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64)).isOccupied()) {// if there isn't a piece then move it according to the rules
            if (selectedPiece != null) {
                Tile newTile = getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));//get tile where to move piece
                switch (selectedPiece.getName()) {
                    case "pawn", "knight", "bishop", "rook", "king", "queen" -> {
                        if (selectedPiece.moveValidator(newTile, tiles)) {
                            // write signature: writing to server message with this prototype:
                            // (current position of piece "x, y" + coordinates of clicked tile "x, y" + move(0 - performMove, 1 - capture))
                            if (client != null) {
                                client.write(selectedPiece.getX() + " " + selectedPiece.getY() + " " + (e.getX() - 8) / 64 + " " + (e.getY() - 31) / 64 + " 0");
                                client.getPlayer().switchTurn();
                            }
                            if (server != null) {
                                server.getHandler().write(selectedPiece.getX() + " " + selectedPiece.getY() + " " + (e.getX() - 8) / 64 + " " + (e.getY() - 31) / 64 + " 0");
                                server.getPlayer().switchTurn();
                            }
                            validatorLegitMoves.removeLegitMovesFromPanel(tiles);
                            performMove(e, newTile);
                        } else {
                            validatorLegitMoves.removeLegitMovesFromPanel(tiles);
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

        if(Objects.equals(selectedPiece.getName(), "pawn")) {
            selectedPiece.setPawnMoved();
        }

        //setting piece to new tile
        tile.setPiece(selectedPiece);
        tile.addLabelToPanel(new JLabel(selectedPiece.getImgIcon()));
        tile.setOccupied(true);

        //removing from old tile
        oldTile.setOccupied(false);
        oldTile.removeZeroLabelFromPanel(oldTile.getPanel());
        oldTile.setPiece(null);

        //setting variable to null for future work
        selectedPiece = null;
    }

    public void performMove(int oldX, int oldY, int curX, int curY) {

        selectedPiece = tiles[oldY][oldX].getPiece();
        selectedPiece.move(curX, curY);

        tiles[curY][curX].setPiece(selectedPiece);
        tiles[curY][curX].addLabelToPanel(new JLabel(selectedPiece.getImgIcon()));
        tiles[curY][curX].setOccupied(true);

        //removing from old tile
        tiles[oldY][oldX].setOccupied(false);
        tiles[oldY][oldX].removeZeroLabelFromPanel(tiles[oldY][oldX].getPanel());
        tiles[oldY][oldX].setPiece(null);

        //setting variable to null for future work
        selectedPiece = null;
    }

    private void capture(MouseEvent e, Tile tile) {
        pieceList.remove(tile.getPiece());
        selectedPiece.move(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));
        //deleting if there is a piece from new tile
        tile.removeZeroLabelFromPanel(tile.getPanel());
        tile.setPiece(null);

        //setting new tile
        tile.setPiece(selectedPiece);
        tile.addLabelToPanel(new JLabel(selectedPiece.getImgIcon()));

        //removing from old tile
        oldTile.removeZeroLabelFromPanel(oldTile.getPanel());
        oldTile.setPiece(null);
        oldTile.setOccupied(false);

        //setting variable to null for future work
        selectedPiece = null;
    }

    public void capture(int oldX, int oldY, int curX, int curY) {
        pieceList.remove(tiles[curY][curX].getPiece());

        selectedPiece = tiles[oldY][oldX].getPiece();

        tiles[curY][curX].removeZeroLabelFromPanel(tiles[curY][curX].getPanel());
        tiles[curY][curX].setPiece(null);

        tiles[curY][curX].setPiece(selectedPiece);
        tiles[curY][curX].addLabelToPanel(new JLabel(selectedPiece.getImgIcon()));

        tiles[oldY][oldX].removeZeroLabelFromPanel(tiles[oldY][oldX].getPanel());
        tiles[oldY][oldX].setPiece(null);
        tiles[oldY][oldX].setOccupied(false);

        selectedPiece = null;
    }

    public JFrame getFrame() {
        return frame;
    }
}
