package Client;

import java.util.Objects;

public class CheckMateValidator {
    private final King king;
    private final String color;

    public CheckMateValidator(King king) {
        this.king = king;
        if (king.isWhite()) color = "white";
        else color = "black";
    }

    public Piece checkValidator(Piece selectedPiece, Tile[][] tiles) {
        if (selectedPiece.isWhite() != king.isUnderAttack() && !Objects.equals(selectedPiece.getName(), "pawn")
                && selectedPiece.moveValidator(tiles[king.getY()][king.getX()], tiles)) {
            System.out.println("{GAME}: " + color + " king is under attack");
            king.setUnderAttack();
            return selectedPiece;
        } else if (selectedPiece.isWhite() != king.isUnderAttack() && Objects.equals(selectedPiece.getName(), "pawn")
                && selectedPiece.captureValidator(tiles[king.getY()][king.getX()], tiles)) {
            System.out.println("{GAME}: " + color + " king is under attack");
            king.setUnderAttack();
            return selectedPiece;
        }
        return null;
    }
}
