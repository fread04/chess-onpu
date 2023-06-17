package Client;

import java.util.LinkedList;

class King extends Piece {
    private boolean isUnderAttack = false;
    private final CheckMateValidator checkMateValidator = new CheckMateValidator(this);

    public King(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {
        // King can move only one square in any direction
        int[] vector = new int[]{tile.getX() - this.getX(), tile.getY() - this.getY()};
        if (Math.abs(vector[0]) > 1 || Math.abs(vector[1]) > 1) {
            return false;
        }
        // Check for any obstructions on the path of the King (there shouldn't be any)
        return !tile.isOccupied();
    }

    public boolean isUnderAttack() {
        return isUnderAttack;
    }

    public CheckMateValidator getCheckMateValidator() {
        return checkMateValidator;
    }

    public void setUnderAttack() {
        isUnderAttack = !isUnderAttack;
    }
}

