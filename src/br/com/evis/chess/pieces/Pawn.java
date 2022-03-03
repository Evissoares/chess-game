package br.com.evis.chess.pieces;

import br.com.evis.chess.Board;

public class Pawn extends Piece {

    private boolean firstMove = false;

    public Pawn(boolean white) {
        super(white);
    }

    private void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {

        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = Math.abs(start.getPosX() - end.getPosX());
        int y = Math.abs(start.getPosY() - end.getPosY());

        boolean allowDoubleAdvance = Math.abs(x - y) == 2;
        boolean allowCapturePiece = x - y == 1;

        if (allowDoubleAdvance && !firstMove) {
            this.setFirstMove(true);
            return true;
        }

        if (end.getPiece() != null && x == 1 && y == 1 && (end.getPiece().isWhite() != this.isWhite())) {
            return true;
        } else {

            return false;
        }


    }

    //se o peão sair da linha, false
    //se e somente se proxima casa na diagonal for não nula e for de outra cor, true
}
