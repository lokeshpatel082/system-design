package com.loki.snake.ladder.model;

import lombok.Getter;

@Getter
public class Snake implements BoardElement{
    private final int start;
    private final int end;
    public Snake(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int moveToNewPosition(int position) {
        return 0;
    }

//    public Integer getEnd() {
//        return end;
//    }
}
