package com.loki.tic.tac.toe.model;

import java.util.Deque;
import java.util.Scanner;

public class TicTacToeGame {
    private Deque<Player> players;
    private GameBoard gameBoard;

    public TicTacToeGame(Deque<Player> players, int boardSize){
        this.players = players;
        this.gameBoard = new GameBoard(boardSize);
    }

    public void start(){
        boolean isGameRunning = true;
        while(isGameRunning){
            Player currentPlayer = players.removeFirst();
            if(this.gameBoard.isFull()){
                isGameRunning = false;
                System.out.println("Game Over with Tie !!");
                continue;
            }
            this.gameBoard.displayBoard();
            System.out.print(" "+ currentPlayer.getName()+"'s turn, Enter row, col: ");
            Scanner scanner = new Scanner(System.in);
            String values[] = scanner.nextLine().split(",");
            int row = Integer.valueOf(values[0]);
            int col = Integer.valueOf(values[1]);

            this.gameBoard.setToken(row, col, currentPlayer.getToken());
            if(this.gameBoard.checkRows() || this.gameBoard.checkCols()){
                System.out.println("Player "+ currentPlayer.getName() + " has won the game !!");
                isGameRunning = false;
                continue;
            }
            players.addLast(currentPlayer);
        }
    }
}
