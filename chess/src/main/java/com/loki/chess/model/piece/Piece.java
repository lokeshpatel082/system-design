package com.loki.chess.model.piece;

import com.loki.chess.model.Cell;
import com.loki.chess.model.ChessBoard;

public abstract class Piece {
    private boolean white;
    private boolean killed = false;
    public Piece(boolean white){
        this.white = white;
    }
    public boolean isWhite(){
        return this.white;
    }

    public boolean isKilled() {
        return killed;
    }
    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public abstract  boolean canMove(ChessBoard chessBoard, Cell startCell, Cell endCell);

}
