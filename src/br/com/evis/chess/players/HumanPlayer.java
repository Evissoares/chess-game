package br.com.evis.chess.players;

public class HumanPlayer extends Player{

    public HumanPlayer(boolean whiteSide) {
        this.setWhiteSide(whiteSide);
        this.setHumanPlayer(true);
    }


}
