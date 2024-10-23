package com.loki.chess.model;

import com.loki.chess.model.piece.*;

public class ChessBoard {
    private Cell board[][];
    public ChessBoard(){
        this.board = new Cell [8][8];
        initializeBoard();
    }
    public Cell getCell(int x , int y){
        return board[x][y];
    }
    private void  initializeBoard(){
        // setting up the white pieces
        initializeMainPieces(true);
        initializePawns(true);

        // setting up the black pieces
        initializeMainPieces(false);
        initializePawns(false);

        // defining rest of the Cells as null
        for(int row = 2; row < 6;row++){
            for(int col = 0;col<8;col++){
                board[row][col] =  new Cell(row, col, null);
            }
        }

    }

    private void initializeMainPieces(boolean white){
        int row = (white)?7:0;

        board[row][0] = new Cell(row, 0,new Rook(white));
        board[row][7] = new Cell(row, 7,new Rook(white));

        board[row][1] = new Cell(row, 1,new Knight(white));
        board[row][6] = new Cell(row, 6,new Knight(white));

        board[row][2] = new Cell(row, 2,new Bishop(white));
        board[row][5] = new Cell(row, 5,new Bishop(white));

        board[row][3] = new Cell(row, 3,new Queen(white));
        board[row][4] = new Cell(row, 4,new King(white));
    }

    private void initializePawns(boolean white){
        int row = (white)?6:1;
        for(int col = 0;col<8;col++){
            board[row][col] = new Cell(row, col,new Pawn(white));
        }
    }
}
