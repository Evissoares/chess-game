package br.com.evis.chess.pieces;

import br.com.evis.chess.Board;

public class King extends Piece{

    private boolean castlingDone = false;

    public King(boolean white){
        super(white);
    }

    public boolean isCastlingDone() {
        return castlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {

        this.castlingDone = castlingDone;
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {

        if(end.getPiece() != null && end.getPiece().isWhite() == this.isWhite() ) {
            return false;
        }

        int x = Math.abs(start.getPosX() - end.getPosX());
        int y = Math.abs(start.getPosY() - end.getPosY());
        if (x + y == 1){

            return true;
        }

        return this.isValidCastling(board, start, end);
    }

    private boolean isValidCastling(Board board, Spot start, Spot end){

        return isCastlingDone();
    }

    public boolean isCastlingMove(Spot start, Spot end){
        return true;
    }



}
