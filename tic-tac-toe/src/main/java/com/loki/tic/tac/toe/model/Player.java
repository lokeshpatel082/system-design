package com.loki.tic.tac.toe.model;

import lombok.Getter;
@Getter
public class Player {

    private final Token token;
    private final String name;

    public Player(String name, Token token){
        this.name = name;
        this.token = token;
    }
}
