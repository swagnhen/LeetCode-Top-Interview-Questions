package pers.swegnhan.leetcode.hard.arrayandstrings;

import java.util.Arrays;

public class GameOfLife {

    public static void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int count = 0;
                if(i - 1 >= 0) {
                    if (j - 1 >= 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 3))
                        count++;
                    if (board[i - 1][j] == 1 || board[i - 1][j] == 3)
                        count++;
                    if (j + 1 < board[0].length && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 3))
                        count++;
                }
                if(j - 1 >= 0 && (board[i][j - 1] == 1 || board[i][j - 1] == 3))
                    count++;
                if(j + 1 < board[0].length && (board[i][j + 1] == 1 || board[i][j + 1] == 3))
                    count++;
                if(i + 1 < board.length){
                    if (j - 1 >= 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 3))
                        count++;
                    if (board[i + 1][j] == 1 || board[i + 1][j] == 3)
                        count++;
                    if (j + 1 < board[0].length && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 3))
                        count++;
                }
                if(board[i][j] == 0 && count == 3)
                    board[i][j] = 2;
                else if(board[i][j] == 1 && (count < 2 || count > 3))
                    board[i][j] = 3;
            }
        }
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 2)
                    board[i][j] = 1;
                if(board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
    }

    public static void main(String[] args){
        int[][] test = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        gameOfLife(test);
        for(int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                System.out.print("" + test[i][j] + ' ');
            }
            System.out.println();
        }
    }

}
