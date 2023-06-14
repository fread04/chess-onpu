package Client;

import java.util.LinkedList;

class Pawn extends Piece {
    boolean isPawnMoved = false;

    public Pawn(int x, int y, boolean isWhite, LinkedList<Piece> pieceList, String name, String path) {
        super(x, y, isWhite, pieceList, name, path);
    }

    @Override
    public boolean moveValidator(Tile tile, Tile[][] tiles) {//TODO: redo
        int[] vector = new int[]{tile.getX() - this.getX(), tile.getY() - this.getY()};
        int isWhite;
        if(super.isWhite()) isWhite = -1;
        else isWhite = 1;
        if(!isPawnMoved){
            if((vector[0] == 0) && (vector[1] == isWhite || vector[1] == 2*isWhite)){
                return true;
            }
        }
        else{
            if((vector[0] == 0) && vector[1] == isWhite){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean captureValidator(Tile tile, Tile[][] tiles) {
        int[] vector = new int[]{tile.getX() - this.getX(), tile.getY() - this.getY()};
        int isWhite;
        if(super.isWhite()) isWhite = -1;
        else isWhite = 1;
        if((Math.abs(vector[0]) == 1) && vector[1] == isWhite ){
            return true;
        }

        return false;
    }

    @Override
    public void setPawnMoved() {
        isPawnMoved = true;
    }
}
