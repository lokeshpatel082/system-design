package com.loki.snake.ladder;

import com.loki.snake.ladder.model.Board;
import com.loki.snake.ladder.model.Dice;
import com.loki.snake.ladder.model.GameStatus;
import com.loki.snake.ladder.model.Player;

import java.util.Queue;

public class Game {
    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;
    private GameStatus status;
    public Game(Board board, Dice dice, Queue<Player> players){
        this.board = board;
        this.dice = dice;
        this.players = players;
        this.status = GameStatus.IN_PROGRESS;
    }

    public void start(){
        while(status == GameStatus.IN_PROGRESS){
            Player currentPlayer = players.poll();
            System.out.println("--> Player "+currentPlayer.getName()+"'s turn to roll the dice\n");
            int position = currentPlayer.getPosition() + dice.roll();
            int newPosition = board.getNewPosition(position);
            if(newPosition > board.getBoardSize()){
                System.out.println("    Player exeeds the winning position, no valid advancement, current position is "+ currentPlayer.getPosition());
                players.add(currentPlayer);
                System.out.println("    Next Player's Turn !!\n");

            }
            else if(newPosition == board.getBoardSize()){
                System.out.println("Hurray !! Player "+ currentPlayer.getName() + " has Reached to winning position !!\n Exit the game.");
                this.status = GameStatus.FINISHED;
            }
            else{
                System.out.println("    Player is at position "+ newPosition+"\n");
                currentPlayer.setPosition(newPosition);
                players.add(currentPlayer);
                System.out.println("    Next Player's Turn !!\n");
            }
        }

    }


}
