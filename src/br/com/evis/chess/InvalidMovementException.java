package br.com.evis.chess;

public class InvalidMovementException extends RuntimeException{

    public InvalidMovementException(String message){

        super(message);

    }
}
