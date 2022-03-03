package br.com.evis.chess.pieces;


import br.com.evis.chess.Board;

import static java.lang.Math.abs;

public abstract class Piece {

    private boolean white = false;
    private boolean eliminated = false;
    private boolean selected = false;

    protected Piece(boolean white) {
        this.white = white;
    }

    public abstract boolean canMove(Board board, Spot start, Spot end);

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
