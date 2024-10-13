package com.loki.chess.model.piece;

import com.loki.chess.model.Cell;
import com.loki.chess.model.ChessBoard;

public class Queen extends Piece{
    public Queen(boolean white){
        super(white);
    }
    @Override
    public boolean canMove(ChessBoard chessBoard, Cell startCell, Cell endCell) {
        return false;
    }
}
