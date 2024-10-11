package com.loki.tic.tac.toe.model;

import lombok.Getter;

public class Token {

    @Getter
    private final TokenType tokenType;
    public Token(TokenType tokenType){
        this.tokenType = tokenType;
    }

}
