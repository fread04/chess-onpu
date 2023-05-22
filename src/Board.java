import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class Board {
    private final JFrame frame = new JFrame();
    private final Tile[][] tiles = new Tile[8][8];
    public LinkedList<Piece> pieceList = new LinkedList<>();
    private Piece selectedPiece;
    private Tile selectedTile;
    private Tile oldTile;
    private boolean isPieceSelected = false;

    Board() {
        initFrame();
        drawBoard();
        frame.setVisible(true);
        moveableBoard();
    }

    private void initFrame() {
        frame.setBounds(700, 200,  532, 552);
        frame.setTitle("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
    }

    private void drawBoard() {
        for(int i = 0; i < tiles.length; i++) { //y coord
            for (int j = 0; j < tiles.length; j++) {// x coord
                tiles[i][j] = new Tile(j, i, false);
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

        Rook rookBlackLeft          = new   Rook(0, 0, false, pieceList, "rook", "img/b_rook_png_128px.png");
        Knight knightBlackLeft      = new Knight(1, 0, false, pieceList, "knight", "img/b_knight_png_128px.png");
        Bishop bishopBlackLeft      = new Bishop(2, 0, false, pieceList, "bishop", "img/b_bishop_png_128px.png");
        Queen queenBlack            = new  Queen(3, 0, false, pieceList, "queen", "img/b_queen_png_128px.png");
        King kingBlack              = new   King(4, 0, false, pieceList, "king", "img/b_king_png_128px.png");
        Bishop bishopBlackRight     = new Bishop(5, 0, false, pieceList, "bishop", "img/b_bishop_png_128px.png");
        Knight knightBlackRight     = new Knight(6, 0, false, pieceList, "knight", "img/b_knight_png_128px.png");
        Rook rookBlackRight         = new   Rook(7, 0, false, pieceList, "rook", "img/b_rook_png_128px.png");

        Pawn pawnBlackA = new Pawn(0, 1, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackC = new Pawn(1, 1, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackD = new Pawn(2, 1, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackB = new Pawn(3, 1, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackE = new Pawn(4, 1, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackF = new Pawn(5, 1, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackG = new Pawn(6, 1, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackH = new Pawn(7, 1, false, pieceList, "pawn", "img/b_pawn_png_128px.png");

        Pawn pawnWhiteA = new Pawn(0, 6, true, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteB = new Pawn(1, 6, true, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteC = new Pawn(2, 6, true, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteD = new Pawn(3, 6, true, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteE = new Pawn(4, 6, true, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteF = new Pawn(5, 6, true, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteG = new Pawn(6, 6, true, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteH = new Pawn(7, 6, true, pieceList, "pawn", "img/w_pawn_png_128px.png");

        Rook rookWhiteLeft          = new   Rook(0, 7, true, pieceList, "rook", "img/w_rook_png_128px.png");
        Knight knightWhiteLeft      = new Knight(1, 7, true, pieceList, "knight", "img/w_knight_png_128px.png");
        Bishop bishopWhiteLeft      = new Bishop(2, 7, true, pieceList, "bishop", "img/w_bishop_png_128px.png");
        Queen queenWhite            = new  Queen(3, 7, true, pieceList, "queen", "img/w_queen_png_128px.png");
        King kingWhite              = new   King(4, 7, true, pieceList, "king", "img/w_king_png_128px.png");
        Bishop bishopWhiteRight     = new Bishop(5, 7, true, pieceList, "bishop", "img/w_bishop_png_128px.png");
        Knight knightWhiteRight     = new Knight(6, 7, true, pieceList, "knight", "img/w_knight_png_128px.png");
        Rook rookWhiteRight         = new   Rook(7, 7, true, pieceList, "rook", "img/w_rook_png_128px.png");


        for(int i = 0, index = 0; i < tiles.length; i++) {//adding pieces to their tiles
            for(int j = 0; j < tiles.length; j++) {
                if(pieceList.get(index).getY() == i && pieceList.get(index).getX() == j) {
//                    System.out.println(index);
//                    System.out.println(pieceList.get(index).getName());
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
                    selectedTile = null;
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                for(int i = 0; i < tiles.length; i++) {
//                    for(int j = 0; j < tiles.length; j++) {
//                        System.out.println("(" + i + ", " + j + ") tile is occupied: " + tiles[i][j].isOccupied());
//                    }
//                }
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

    private Tile getTile(int x, int y) {
        for (Tile[] tile : tiles) {
            for (int j = 0; j < tiles.length; j++) {
                if (tile[j].getCoordinates()[0] == x && tile[j].getCoordinates()[1] == y) {
                    return tile[j];
                }
            }
        }
//        for(int i = 0; i < tiles.length; i++) {
//            for(int j = 0; j < tiles.length; j++) {
//                if(tiles[j][i].getCoordinates()[0] == x && tiles[j][j].getCoordinates()[1] == y){
//                    return tiles[j][i];
//                }
//            }
//        }
        return null;
    }

    private boolean isPieceSelected(Piece selectedPiece) {
        if(selectedPiece != null) {
            return isPieceSelected = true;
        }
        return  isPieceSelected = false;
    }

    private void makeMove(MouseEvent e) throws Exception {
        if(getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64)).isOccupied()) {// take a piece if there is no piece
            if(selectedPiece != null && getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64)).getPiece().isWhite() != selectedPiece.isWhite()) {
                Tile newTile = getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));//get tile where to move piece
                switch (selectedPiece.getName()) {
                    case "pawn", "knight", "bishop", "rook", "king", "queen" -> {
                        if (selectedPiece.moveValidator(newTile, tiles)) {
                            capture(e, newTile);
                        } else {
                            throw new IllegalAccessException("move isn't valid");
                        }
                    }
                    default -> System.out.println("something got wrong");
                }
            }
            selectedPiece = getPiece(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));
            oldTile = getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));

            System.out.println("| if |");
            System.out.println("old tile is occupied: " + oldTile.isOccupied());
            System.out.println(Arrays.toString(tiles[(e.getY() - 31) / 64][(e.getX() - 8) / 64].getCoordinates()));
            System.out.println(selectedPiece);

        } else if(!getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64)).isOccupied()) {// if there isn't a piece then move it according to the rules
            if(selectedPiece != null) {
                Tile newTile = getTile(((e.getX() - 8) / 64), ((e.getY() - 31) / 64));//get tile where to move piece
                switch (selectedPiece.getName()) {
                    case "pawn", "knight", "bishop", "rook", "king", "queen" -> {
                        if (selectedPiece.moveValidator(newTile, tiles)) {
                            performMove(e, newTile);
                        } else {
                            throw new IllegalAccessException("move isn't valid");
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

                        System.out.println("| else |");
                        System.out.println("new tile coords: " + Arrays.toString(tile.getCoordinates()));
                        System.out.println("old tile is occupied: " + oldTile.isOccupied());
                        System.out.println(Arrays.toString(oldTile.getCoordinates()));
                        System.out.println("new tile is occupied: " + tile.isOccupied());

        //setting variable to null for future work
        selectedPiece = null;
        selectedTile = null;
    }

    private void capture(MouseEvent e, Tile tile) {
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
        selectedTile = null;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Tile[][] getTiles() {
        return tiles;
    }


}
