package Server;

import Client.Piece;

public class Packet {
    private final Piece piece;
    public Packet(Piece piece) {
        this.piece = piece;
    }

    public Packet() {
        this.piece = null;
    }

    public Piece getPiece() {
        return piece;
    }
}
