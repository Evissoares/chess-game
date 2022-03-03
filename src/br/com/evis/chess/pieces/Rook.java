package br.com.evis.chess.pieces;

import br.com.evis.chess.Board;

public class Rook extends Piece {

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {

        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) return false;

        int fromRow = start.getPosX();
        int toRow = end.getPosX();
        int fromCol = start.getPosY();
        int toCol = end.getPosY();

        int dx = (fromRow < toRow) ? 1 : -1;
        int dy = (fromCol < toCol) ? 1 : -1;

        boolean verticalMove = fromCol == toCol;
        boolean horizontalMove = fromRow == toRow;

        int i;


        if (verticalMove){
            for (i = fromRow + dx; i != toRow; i += dx)
                if (board.getBox(i, fromCol).getPiece() != null) return false;
            return true;
        }

        if (horizontalMove){
            for (i = fromCol + dy; i != toCol; i += dy)
                if (board.getBox(fromRow, i).getPiece() != null) return false;
            return true;
        }

        return false;

    }
}
