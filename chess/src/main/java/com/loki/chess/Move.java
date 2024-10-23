package com.loki.chess;

import com.loki.chess.model.Cell;

public class Move {
    private Cell startCell;
    private Cell endCell;

    public Move(Cell start, Cell end){
        this.startCell = start;
        this.endCell = end;
    }

    public boolean isValid(){
        if(startCell.getPiece() == null)
            return false;
        if(endCell.getPiece() != null && startCell.getPiece().isWhite() == endCell.getPiece().isWhite())
            return false;

        return true;
    }

    public Cell getStartCell() {
        return startCell;
    }

    public Cell getEndCell() {
        return endCell;
    }
}
