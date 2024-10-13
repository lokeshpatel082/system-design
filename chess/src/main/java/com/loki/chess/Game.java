package com.loki.chess;

import com.loki.chess.enums.GameStatus;
import com.loki.chess.model.ChessBoard;
import com.loki.chess.model.piece.King;
import com.loki.chess.model.piece.Piece;

import java.util.ArrayList;

public class Game {
    private final Player player1;
    private final Player player2;
    private final ChessBoard chessBoard;
    private boolean whiteTurn;
    private GameStatus status;
    private final ArrayList<Move> gameLog;

    public Game(Player p1, Player p2){
        this.player1 = p1;
        this.player2 = p2;
        this.chessBoard = new ChessBoard();
        this.status = GameStatus.IN_PROGRESS;
        this.whiteTurn = true;
        this.gameLog = new ArrayList<>();
    }

    public void start(){
        while(status == GameStatus.IN_PROGRESS){
            if(whiteTurn) {
                // create move for player1(white)
            }
            else{
                // create move for player2(black)
            }

        }
    }

    public void makeMove(Move move, Player player) {
        // Initial check for valid move
        // To check if source and destination doesn't contain
        // the same color pieces.
        if (move.isValid()) {
            Piece sourcePiece = move.getStartCell().getPiece();

            if (sourcePiece.canMove(this.chessBoard, move.getStartCell(), move.getEndCell())) {
                Piece destinationPiece = move.getEndCell().getPiece();
                if (destinationPiece != null && handleKilling(destinationPiece)) {
                    return;
                }
                gameLog.add(move);
                move.getEndCell().setPiece(sourcePiece);
                move.getStartCell().setPiece(null);

                whiteTurn = !whiteTurn;
            }
        }
    }

    private boolean handleKilling(Piece destinationPiece) {

        // if destination block contains King
        // and currently white is playing --> White wins
        if (destinationPiece instanceof King && whiteTurn) {
            this.status = GameStatus.WHITE_WON;
            return true;
        }
        // if destination block contains King
        // and currently Black is playing --> Black wins
        if (destinationPiece instanceof King && !whiteTurn) {
            this.status = GameStatus.BLACK_WON;
            return true;
        }
        // Set the destination piece as killed
        destinationPiece.setKilled(true);
        return false;
    }
}