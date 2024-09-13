package com.loki.snake.ladder.model;

public interface  BoardElement {
    public int moveToNewPosition(int position);
    public int getStart();
    public int getEnd();
}
