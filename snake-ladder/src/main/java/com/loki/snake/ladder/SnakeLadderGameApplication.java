package com.loki.snake.ladder;

import com.loki.snake.ladder.model.Board;
import com.loki.snake.ladder.model.Dice;
import com.loki.snake.ladder.model.Player;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SnakeLadderGameApplication {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("************* Welcome to Snake and Ladder Game ************* !!\n\n");
        System.out.println("Enter the board size, number of snakes and number of ladders you want to play with: ");
        int size = scanner.nextInt();
        int noSnakes = scanner.nextInt();
        int noLadders = scanner.nextInt();
        Board board = new Board(size,noSnakes,noLadders);
        Dice dice = new Dice(1,6);

        System.out.println("\n\nPlease enter the number of players: ");
        int noPlayers = scanner.nextInt();
        Queue<Player> players = new ArrayDeque<>() ;
        System.out.println("\nPlayer Registration in progess...\n ");
        for(int i = 1; i<=noPlayers; i++){
            System.out.println("Enter the name of player "+ i +": ");
            String name = scanner.next();
            players.add(new Player(name));
        }

        Game game = new Game(board,dice,players);
        game.start();

    }
}