package com.loki.chess.model.piece;

import com.loki.chess.model.Cell;
import com.loki.chess.model.ChessBoard;

public class Bishop extends Piece {
    public Bishop(boolean white){
        super(white);
    }
    @Override
    public boolean canMove(ChessBoard chessBoard, Cell startCell, Cell endCell) {
        int direction = isWhite()?1:-1;
        return false;

    }
}
