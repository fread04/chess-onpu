package Client;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

public class ValidatorLegitMoves {
    private final Tile[][] tiles;
    private Tile[][] tilesWithMoves = new Tile[8][8];
    private Piece selectedPiece;

    public ValidatorLegitMoves(Tile[][] tiles) {
        this.tiles = tiles;
        System.out.println(Arrays.deepToString(this.tiles));
    }

    public void validateLegitMoves(Piece selectedPiece) {
        reselectSelectedPiece(selectedPiece);
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (this.selectedPiece.moveValidator(tiles[i][j], tiles) && !tiles[i][j].isOccupied()) {
                    tilesWithMoves[i][j] = tiles[i][j];//remembering tiles where we placed moves;
                    addLegitMovesToPanel(tiles[i][j]);
                } else if(!Objects.equals(this.selectedPiece.getName(), "pawn")
                        && this.selectedPiece.moveValidator(tiles[i][j], tiles) && tiles[i][j].isOccupied()
                        && this.selectedPiece.isWhite() != tiles[i][j].getPiece().isWhite()) {
                    tilesWithMoves[i][j] = tiles[i][j];//remembering tiles where we placed moves;
                    addLegitMovesToPanel(tiles[i][j]);
                } else if(Objects.equals(this.selectedPiece.getName(), "pawn")
                        && this.selectedPiece.captureValidator(tiles[i][j], tiles) && tiles[i][j].isOccupied()
                        && this.selectedPiece.isWhite() != tiles[i][j].getPiece().isWhite()) {
                    tilesWithMoves[i][j] = tiles[i][j];//remembering tiles where we placed moves;
                    addLegitMovesToPanel(tiles[i][j]);
                }
            }
        }
    }

    private void reselectSelectedPiece(Piece piece) {
        if(selectedPiece == null) {
            selectedPiece = piece;
        } else if(selectedPiece != piece) {
            removeLegitMovesFromPanel(tiles);
            selectedPiece = piece;
        }
    }

    private void addLegitMovesToPanel(Tile tile) {
        if(!tile.isOccupied()) {
            tile.addLabelToPanel(new JLabel(new ImageIcon("src/main/img/moves.png")));
            tile.getPanel().revalidate();
        } else {
            tile.addLabelToPanel(new JLabel(new ImageIcon("src/main/img/movesOccupiedTile.png")));
            tile.getPanel().revalidate();
        }
    }

    public void removeLegitMovesFromPanel(Tile[][] tiles) {
        for (int i = 0; i < tilesWithMoves.length; i++) {
            for (int j = 0; j < tilesWithMoves.length; j++) {
                if(tilesWithMoves[i][j] == tiles[i][j] && tilesWithMoves[i][j] != null
                && tilesWithMoves[i][j].getPanel().getComponent(0) != null) {
                    if(tilesWithMoves[i][j].isOccupied()) {
                        tiles[i][j].removeFirstLabelFromPanel(tiles[i][j].getPanel());
                    } else {
                        tiles[i][j].removeZeroLabelFromPanel(tiles[i][j].getPanel());
                    }
                }
            }
        }
        tilesWithMoves = new Tile[8][8];
    }
}
