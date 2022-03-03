package br.com.evis.chess.pieces;

import br.com.evis.chess.Board;

public class Bishop extends Piece{

    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if(end.getPiece() != null && end.getPiece().isWhite() == this.isWhite() ) {
            return false;
        }

        int fromRow = start.getPosX();
        int toRow = end.getPosX();
        int fromCol = start.getPosY();
        int toCol = end.getPosY();

        int dx = (fromRow < toRow) ? 1 : -1;
        int dy = (fromCol < toCol) ? 1 : -1;


        if(Math.abs(fromRow - toRow) != Math.abs(fromCol - toCol)) {
            return false;
        }

        for(int i = 1; i < Math.abs(fromRow - toRow); i++){
            if(board.getBox(fromRow + i*dx, fromCol + i*dy).getPiece() != null){
                return false;
            }
        }

        return true;
    }
}
