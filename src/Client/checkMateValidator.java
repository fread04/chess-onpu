package Client;

import java.util.LinkedList;

public interface checkMateValidator {
    public boolean validCheck(LinkedList<Piece> pieceLinkedList, Tile tile);
    public boolean validMate(LinkedList<Piece> pieceLinkedList, Tile tile);
}
