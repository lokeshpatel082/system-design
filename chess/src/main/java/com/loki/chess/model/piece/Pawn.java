package com.loki.chess.model.piece;

import com.loki.chess.model.Cell;
import com.loki.chess.model.ChessBoard;

public class Pawn extends Piece{

    public Pawn(boolean white){
        super(white);
    }
    @Override
    public boolean canMove(ChessBoard chessBoard, Cell startCell, Cell endCell) {
//        int direction = isWhite()?-1:1;
//
//        // regular forward move
//        if(startX + direction == endX && chessBoard.getPiece(endX,endY) == null){
//            return true;
//        }
//
//        // capture move
//        return startX + direction == endX &&
//                Math.abs(endY - startY) == 1 &&
//                chessBoard.getPiece(startX, startY).isWhite() &&
//                !chessBoard.getPiece(endX, endY).isWhite();
    return false;
    }
}
