package com.loki.tic.tac.toe.model;

public class GameBoard {
    private int size;
    private Token[][] gameBoard;

    public GameBoard(int size) {
        this.size = size;
        initializeBoard();

    }

    private void initializeBoard() {
        this.gameBoard = new Token[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.gameBoard[i][j] = null;
            }
        }
    }

    public void displayBoard() {
        System.out.println("Current Board is:\n");
        for (int i = 0; i < this.size; i++) {

            for (int j = 0; j < this.size; j++) {
                System.out.print("| ");

                if (this.gameBoard[i][j] == null) {
                    System.out.print("     ");
                } else {
                    System.out.print(this.gameBoard[i][j].getTokenType()+"    ");
                }

                if(j == this.size - 1){
                    System.out.print("|");
                }


            }
            System.out.println("");
        }
    }

    public Token getToken(int row, int col) {
        return this.gameBoard[row][col];
    }

    public void setToken(int row, int col, Token token) {
        this.gameBoard[row][col] = token;
    }

    public boolean isFull() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.gameBoard[i][j] == null) return false;
            }
        }
        return true;
    }
    public boolean checkRows(){
        for (int i = 0; i < this.size; i++){
            int count = 1;
            for (int j = 1; j < this.size; j++){
                if(this.gameBoard[i][0] != null && this.gameBoard[i][j]!=null &&
                        this.gameBoard[i][j].getTokenType() == this.gameBoard[i][0].getTokenType()){
                    count++;
                }
            }
            if(count == this.size) return true;
        }
        return false;
    }

    public boolean checkCols(){
        for (int col = 0; col < this.size; col++){
            int count = 1;
            for (int row = 1; row < this.size; row++){
                if(this.gameBoard[0][col] != null && this.gameBoard[row][col]!=null && this.gameBoard[0][col].getTokenType() == this.gameBoard[row][col].getTokenType()){
                   count++;
                }
            }
            if(count == this.size) return true;
        }
        return false;
    }
    public boolean checkDiagonals(){
//        for (int col = 0; col < this.size; col++){
//            for (int row = 1; row < this.size; row++){
//                if(this.gameBoard[0][col].getTokenType() != this.gameBoard[row][col].getTokenType()){
//                    return false;
//                }
//            }
//        }

        // to be implemented;
        return false;
    }
}
