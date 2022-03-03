package br.com.evis.chess;

import br.com.evis.chess.pieces.*;

public class Board {

    private Spot[][] boxes = new Spot[8][8];

    public Board() {

    }

    /**
     *
     * @param x this param is used to indicate which line you want to move de piece, in other words
     *          it's used to change the vertical position from a given piece on the board.<br><br>
     * @param y this param is used to indicate which column you want to move de piece, in other words
     *          it's used to change the horizontal position from a given piece on the board.
     *
     * @return This method returns a piece from a given coordinate.
     *
     * (e.g) The board starts with a black rook at [0, 0] position and ends with a white rook at [7, 7] position.
     * If you want to take a queen side white bishop, so you will send x, y coordinates as x = 7 and y = 2.
     *
     * @throws InvalidMovementException
     * Exception is thrown when a player try to take a piece off the board bounds.
     */
    public Spot getBox(int x, int y) throws InvalidMovementException {

        if(x < 0 || x > 7 || y < 0 || y > 7) {
                throw new InvalidMovementException("Movement not allowed.");
        }

        return boxes[x][y];
    }

    public void resetBoard(){


        //black pieces inicialyzed
        boxes[0][0] = new Spot(0, 0, new Rook(false));
        boxes[0][1] = new Spot(0, 1, new Knight(false));
        boxes[0][2] = new Spot(0, 2, new Bishop(false));
        boxes[0][3] = new Spot(0, 3, new Queen(false));
        boxes[0][4] = new Spot(0, 4, new King(false));
        boxes[0][5] = new Spot(0, 5, new Bishop(false));
        boxes[0][6] = new Spot(0, 6, new Knight(false));
        boxes[0][7] = new Spot(0, 7, new Rook(false));

        boxes[1][0] = new Spot(1, 0, new Pawn(false));
        boxes[1][1] = new Spot(1, 1, new Pawn(false));
        boxes[1][2] = new Spot(1, 2, new Pawn(false));
        boxes[1][3] = new Spot(1, 3, new Pawn(false));
        boxes[1][4] = new Spot(1, 4, new Pawn(false));
        boxes[1][5] = new Spot(1, 5, new Pawn(false));
        boxes[1][6] = new Spot(1, 6, new Pawn(false));
        boxes[1][7] = new Spot(1, 7, new Pawn(false));


        //white pieces inicialized
        boxes[7][0] = new Spot(7, 0, new Rook(true));
        boxes[7][1] = new Spot(7, 1, new Knight(true));
        boxes[7][2] = new Spot(7, 2, new Bishop(true));
        boxes[7][3] = new Spot(7, 3, new Queen(true));
        boxes[7][4] = new Spot(7, 4, new King(true));
        boxes[7][5] = new Spot(7, 5, new Bishop(true));
        boxes[7][6] = new Spot(7, 6, new Knight(true));
        boxes[7][7] = new Spot(7, 7, new Rook(true));

        boxes[6][0] = new Spot(6,0, new Pawn(true));
        boxes[6][1] = new Spot(6,1, new Pawn(true));
        boxes[6][2] = new Spot(6,2, new Pawn(true));
        boxes[6][3] = new Spot(6,3, new Pawn(true));
        boxes[6][4] = new Spot(6,4, new Pawn(true));
        boxes[6][5] = new Spot(6,5, new Pawn(true));
        boxes[6][6] = new Spot(6,6, new Pawn(true));
        boxes[6][7] = new Spot(6,7, new Pawn(true));



        for(int x = 2; x < 6; x++) {
            for(int y = 0; y < 8; y++){
                boxes[x][y] = new Spot(x, y, null);
            }
        }


    }


}
