package com.loki.snake.ladder.model;

import lombok.Getter;

@Getter
public class Ladder implements BoardElement{
    private final int start;
    private final int end;
    public Ladder(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int moveToNewPosition(int position) {
        return 0;
    }



}
