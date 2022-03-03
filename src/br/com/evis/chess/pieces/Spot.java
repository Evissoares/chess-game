package br.com.evis.chess.pieces;

public class Spot {

    private Piece piece;
    private int posX;
    private int posY;

    public Spot(int posX, int posY, Piece piece) {
        this.piece = piece;
        this.posX = posX;
        this.posY = posY;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

}
