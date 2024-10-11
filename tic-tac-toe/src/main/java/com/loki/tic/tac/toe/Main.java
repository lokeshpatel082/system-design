package com.loki.tic.tac.toe;

import com.loki.tic.tac.toe.model.Player;
import com.loki.tic.tac.toe.model.TicTacToeGame;
import com.loki.tic.tac.toe.model.Token;
import com.loki.tic.tac.toe.model.TokenType;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        Deque<Player> players = new LinkedList<>();
        Player player1 = new Player("Lokesh", new Token(TokenType.X));
        Player player2 = new Player("Kishan", new Token(TokenType.O));

        players.add(player1);
        players.add(player2);

        TicTacToeGame game = new TicTacToeGame(players, 3);
        game.start();
    }
}