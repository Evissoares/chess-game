package br.com.evis.chess.game;

import br.com.evis.chess.Board;
import br.com.evis.chess.InvalidMovementException;
import br.com.evis.chess.pieces.Piece;
import br.com.evis.chess.pieces.Spot;
import br.com.evis.chess.pieces.King;
import br.com.evis.chess.players.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player[] players = new Player[2];
    private Board board = new Board();
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed = new ArrayList<>();

    public Board getBoard() {
        return board;
    }

    public void inicialize(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;

        board.resetBoard();

        if (p1.isWhiteSide()) {
            this.currentTurn = p1;
        } else {
            this.currentTurn = p2;
        }

        movesPlayed.clear();
    }

    public List<Move> getMovesPlayed() {
        return movesPlayed;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public boolean isEnd() {
        return this.getStatus() != GameStatus.ACTIVE;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) {

        Spot startBox = null;
        Spot endBox = null;
        try {
            startBox = board.getBox(startX, startY);
            endBox = board.getBox(endX, endY);
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }

        Move move = new Move(player, startBox, endBox);
        return this.makeMove(move, player);


    }

    private boolean makeMove(Move move, Player player) {

        Piece currentPiece = move.getStart().getPiece();

        if (currentPiece == null) {
            return false;
        }

        if (player != currentTurn) {
            return false;
        }

        if (currentPiece.isWhite() != currentTurn.isWhiteSide()) {

            return false;
        }

        if (!currentPiece.canMove(board, move.getStart(), move.getEnd())) {
            return false;
        }

        Piece destPiece = move.getStart().getPiece();
        if (destPiece != null) {
            destPiece.setEliminated(true);
            move.setPieceKilled(destPiece);

        }

        if (currentPiece instanceof King && ((King) currentPiece).isCastlingMove(move.getStart(), move.getEnd())) {

            move.setCastlingMove(true);
        }

        movesPlayed.add(move);

        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);


        if (destPiece instanceof King) {
            this.setStatus(player.isWhiteSide() ? GameStatus.WHITE_WIN : GameStatus.BLACK_WIN);
        }

        this.currentTurn = this.currentTurn == players[0] ? players[1] : players[0];

        return true;
    }


}
