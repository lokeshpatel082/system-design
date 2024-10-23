package com.loki.chess;

public class Main {
    public static void main (String [] args){
        Player player1 = new Player("Loki");
        Player player2 = new Player("Kishan");

        Game chessGame = new Game(player1, player2);
        chessGame.start();

    }
}
