package com.loki.chess;

public class Player {
    private String name;
    private  boolean won;

    public Player(String name){
        this.name = name;
        this.won = false;
    }
    public boolean hasWon(){
        return this.won;
    }
    public String getName(){
        return this.name;
    }

}
