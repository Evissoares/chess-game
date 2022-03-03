package br.com.evis.chess.pieces;

import br.com.evis.chess.Board;

public class Knight extends Piece{

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {

        if(end.getPiece() != null && end.getPiece().isWhite() == this.isWhite() ) {
            return false;
        }

        int x = Math.abs(start.getPosX() - end.getPosX());
        int y = Math.abs(start.getPosY() - end.getPosY());
        return x * y == 2;
    }


}
