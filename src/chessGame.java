import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class chessGame {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel[][] panels = new JPanel[9][9];
        LinkedList<Piece> pieceList = null;
//
        //setting a frame params
        frame.setSize(720, 720);
        frame.setTitle("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);






        Rook rookBlackLeft = new Rook(0, 0, false, pieceList, "rook", "img/b_rook_png_128px.png");
        Rook rookBlackRight = new Rook(0, 0, false, pieceList, "rook", "img/b_rook_png_128px.png");
        Knight knightBlackLeft = new Knight(0, 0, false, pieceList, "knight", "img/b_knight_png_128px.png");
        Knight knightBlackRight = new Knight(0, 0, false, pieceList, "knight", "img/b_knight_png_128px.png");
        Bishop bishopBlackLeft = new Bishop(0, 0, false, pieceList, "bishop", "img/b_bishop_png_128px.png");
        Bishop bishopBlackRight = new Bishop(0, 0, false, pieceList, "bishop", "img/b_bishop_png_128px.png");
        King kingBlack = new King(0, 0, false, pieceList, "king", "img/b_king_png_128px.png");
        Queen queenBlack = new Queen(0, 0, false, pieceList, "queen", "img/b_queen_png_128px.png");

        Pawn pawnBlackA = new Pawn(0, 0, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackB = new Pawn(0, 0, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackC = new Pawn(0, 0, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackD = new Pawn(0, 0, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackE = new Pawn(0, 0, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackF = new Pawn(0, 0, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackG = new Pawn(0, 0, false, pieceList, "pawn", "img/b_pawn_png_128px.png");
        Pawn pawnBlackH = new Pawn(0, 0, false, pieceList, "pawn", "img/b_pawn_png_128px.png");

        Rook rookWhiteLeft = new Rook(0, 0, false, pieceList, "rook", "img/w_rook_png_128px.png");
        Rook rookWhiteRight = new Rook(0, 0, false, pieceList, "rook", "img/w_rook_png_128px.png");
        Knight knightWhiteLeft = new Knight(0, 0, false, pieceList, "knight", "img/w_knight_png_128px.png");
        Knight knightWhiteRight = new Knight(0, 0, false, pieceList, "knight", "img/w_knight_png_128px.png");
        Bishop bishopWhiteLeft = new Bishop(0, 0, false, pieceList, "bishop", "img/w_bishop_png_128px.png");
        Bishop bishopWhiteRight = new Bishop(0, 0, false, pieceList, "bishop", "img/w_bishop_png_128px.png");
        King kingWhite = new King(0, 0, false, pieceList, "king", "img/w_king_png_128px.png");
        Queen queenWhite = new Queen(0, 0, false, pieceList, "queen", "img/w_queen_png_128px.png");

        Pawn pawnWhiteA = new Pawn(0, 0, false, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteB = new Pawn(0, 0, false, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteC = new Pawn(0, 0, false, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteD = new Pawn(0, 0, false, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteE = new Pawn(0, 0, false, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteF = new Pawn(0, 0, false, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteG = new Pawn(0, 0, false, pieceList, "pawn", "img/w_pawn_png_128px.png");
        Pawn pawnWhiteH = new Pawn(0, 0, false, pieceList, "pawn", "img/w_pawn_png_128px.png");




        //drawing a chess board
        for(int i = 0, y = 0; i < panels.length; i++, y += 64) {
            for(int j = 0, x = 0; j < panels.length; j++, x += 64) {

                panels[i][j] = new JPanel();
                panels[i][j].setLayout(new BorderLayout());

                if(j == 0) {
                    panels[i][j].setBounds(x, y, 32, 64);
                    panels[i][j].setBackground(Color.white);
                    x -= 32;
                    if(i == 8) panels[i][j].setBounds(x, y, 32, 32);
                } else if (i == 8) {
                    panels[i][j].setBounds(x, y, 64, 32);
                    panels[i][j].setBackground(Color.white);
                } else {
                    panels[i][j].setBounds(x, y, 64, 64);
                    if((i + j) % 2 == 1) {
                        panels[i][j].setBackground(new Color(106, 119, 135));
                    } else {
                        panels[i][j].setBackground(new Color(42, 47, 54));
                    }
                }
            }
        }


       //adding numbers to panels
        for(int i = 0, ind = panels.length - 1; i < panels.length; i++, ind--) {
            JLabel newLabel = new JLabel();

            newLabel.setText(String.valueOf(ind));
            newLabel.setForeground(Color.black);
            newLabel.setVerticalAlignment(JLabel.CENTER);
            newLabel.setHorizontalAlignment(JLabel.CENTER);

            panels[i][0].add(newLabel);
        }

        //adding characters to panels
        char c = 'a';
        for(int i = 1; i < panels.length; i++) {
            JLabel newLabel = new JLabel();

            newLabel.setText(String.valueOf(c));
            newLabel.setForeground(Color.black);
            newLabel.setVerticalAlignment(JLabel.CENTER);
            newLabel.setHorizontalAlignment(JLabel.CENTER);

            panels[8][i].add(newLabel);
            c++;
        }

        //adding pieces to their respective panels
        panels[0][1].add(new JLabel(rookBlackRight.getImgIcon()));
        panels[0][2].add(new JLabel(knightBlackRight.getImgIcon()));
        panels[0][3].add(new JLabel(bishopBlackRight.getImgIcon()));
        panels[0][4].add(new JLabel(queenBlack.getImgIcon()));
        panels[0][5].add(new JLabel(kingBlack.getImgIcon()));
        panels[0][6].add(new JLabel(bishopBlackLeft.getImgIcon()));
        panels[0][7].add(new JLabel(knightBlackLeft.getImgIcon()));
        panels[0][8].add(new JLabel(rookBlackLeft.getImgIcon()));

        panels[1][1].add(new JLabel(pawnBlackA.getImgIcon()));
        panels[1][2].add(new JLabel(pawnBlackB.getImgIcon()));
        panels[1][3].add(new JLabel(pawnBlackC.getImgIcon()));
        panels[1][4].add(new JLabel(pawnBlackD.getImgIcon()));
        panels[1][5].add(new JLabel(pawnBlackE.getImgIcon()));
        panels[1][6].add(new JLabel(pawnBlackF.getImgIcon()));
        panels[1][7].add(new JLabel(pawnBlackG.getImgIcon()));
        panels[1][8].add(new JLabel(pawnBlackH.getImgIcon()));


        panels[7][1].add(new JLabel(rookWhiteRight.getImgIcon()));
        panels[7][2].add(new JLabel(knightWhiteRight.getImgIcon()));
        panels[7][3].add(new JLabel(bishopWhiteRight.getImgIcon()));
        panels[7][4].add(new JLabel(queenWhite.getImgIcon()));
        panels[7][5].add(new JLabel(kingWhite.getImgIcon()));
        panels[7][6].add(new JLabel(bishopWhiteLeft.getImgIcon()));
        panels[7][7].add(new JLabel(knightWhiteLeft.getImgIcon()));
        panels[7][8].add(new JLabel(rookWhiteLeft.getImgIcon()));

        panels[6][1].add(new JLabel(pawnWhiteA.getImgIcon()));
        panels[6][2].add(new JLabel(pawnWhiteB.getImgIcon()));
        panels[6][3].add(new JLabel(pawnWhiteC.getImgIcon()));
        panels[6][4].add(new JLabel(pawnWhiteD.getImgIcon()));
        panels[6][5].add(new JLabel(pawnWhiteE.getImgIcon()));
        panels[6][6].add(new JLabel(pawnWhiteF.getImgIcon()));
        panels[6][7].add(new JLabel(pawnWhiteG.getImgIcon()));
        panels[6][8].add(new JLabel(pawnWhiteH.getImgIcon()));




        //adding panels to the frame
        for(int i = 0, y = 0; i < panels.length; i++, y += 64) {
            for (int j = 0, x = 0; j < panels.length; j++, x += 64) {
                frame.add(panels[i][j]);
            }
        }
        frame.add(new JPanel());
        frame.repaint();
        frame.repaint();
    }
}


//new Color(106, 119, 135)
//new Color(42, 47, 54)
//"C:/Users/Professional/IdeaProjects/chessGame/src/1.png"