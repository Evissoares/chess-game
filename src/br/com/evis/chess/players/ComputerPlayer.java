package br.com.evis.chess.players;

public class ComputerPlayer extends Player{

    public ComputerPlayer(boolean whiteSide) {
        this.setWhiteSide(whiteSide);
        this.setHumanPlayer(false);
    }
}
