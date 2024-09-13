package com.loki.snake.ladder.model;
import java.util.Random;

public class Dice {
    private final  int MAXIMUM_NUMBER ;
    private final  int MINIMUM_NUMBER;
    private final Random random;
    public Dice(final int minNo, final int maxNo){
        this.MAXIMUM_NUMBER = maxNo;
        this.MINIMUM_NUMBER = minNo;
        this.random = new Random();
    }
    public int roll(){
        int number = random.nextInt(MAXIMUM_NUMBER - MINIMUM_NUMBER + 1) + MINIMUM_NUMBER;
        System.out.println("    player got "+ number+"\n");
        return number;
    }
    public static void main(String[] args){
        Dice dice = new Dice(1,6);
        for(int i = 0;i<50;i++){
            System.out.println(dice.roll());
        }

    }
}
