package com.loki.snake.ladder.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Board {
    private static final Random random = new Random();

    @Getter
    private final int boardSize;

    @Setter
    @Getter
    private List<Snake> snakes;

    @Setter
    @Getter
    private List<Ladder> ladders;

    @Setter
    @Getter
    private int noSnakes;

    @Setter
    @Getter
    private int noladders;
    private HashMap<Integer,BoardElement> boardElements;
    public Board(int size, int noSnakes, int noLadders){
        this.boardSize  = size;
        this.noSnakes = noSnakes;
        this.noladders = noLadders;
        this.boardElements = new HashMap<>();
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        initializeBoardElements();
    }

    public void addSnake(Snake snake){

        snakes.add(snake);
        boardElements.put(snake.getStart(), snake);
        System.out.println("Snake: "+snakes.size()+" {head: "+ snake.getStart()+", tail: "+snake.getEnd());
    }
    public void addLadder(Ladder ladder){
        ladders.add(ladder);
        boardElements.put(ladder.getStart(),ladder);
        System.out.println("Ladder: "+ladders.size()+" {start: "+ ladder.getStart()+", end: "+ladder.getEnd());
    }
    private boolean canPlaceBoardElement(int startPosition){
        return !boardElements.containsKey(startPosition);
    }
    private void initializeBoardElements(){
        // place snakes

        while(true){
            int start = random.nextInt(boardSize) + 1;
            int end = random.nextInt(boardSize) + 1;
            if(start <= end || !canPlaceBoardElement(start)){
                continue;
            }
            addSnake(new Snake(start, end));
            if(snakes.size() == noSnakes){
                break;
            }

        }

        // place ladders
        while(true){
            int start = random.nextInt(boardSize) + 1;
            int end = random.nextInt(boardSize) + 1;
            if(start >= end || !canPlaceBoardElement(start)){
                continue;
            }
            addLadder(new Ladder(start, end));
            if(ladders.size() == noladders){
                break;
            }
        }

    }
    public int getNewPosition(int position){
        int newPosition = position;
        while(boardElements.containsKey(newPosition)){
            newPosition = boardElements.get(newPosition).getEnd();
            if(position < newPosition){
                System.out.println("    Hurray!! you got the ladder\n");
            }
            else {
                System.out.println("    LOL !! you got bit by the snake\n");
            }
        }
        return newPosition;

    }

}
