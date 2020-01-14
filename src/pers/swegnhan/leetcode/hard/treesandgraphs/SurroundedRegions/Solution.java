package pers.swegnhan.leetcode.hard.treesandgraphs.SurroundedRegions;

public class Solution {
    public void solve(char[][] board) {
        int boardLength = board.length;
        if(boardLength < 1)
            return;
        int boardWeigth = board[0].length;
        for(int i = 0; i < boardWeigth; i++){
            if(board[0][i] == 'O')
                markNotCaptured(board, 0, i);
            if(board[boardLength - 1][i] == 'O')
                markNotCaptured(board, boardLength - 1, i);
        }
        for(int i = 0; i < boardLength; i++){
            if(board[i][0] == 'O')
                markNotCaptured(board, i, 0);
            if(board[i][boardWeigth - 1] == 'O')
                markNotCaptured(board, i, boardWeigth - 1);
        }
        for(int i = 0; i < boardLength; i++){
            for(int j = 0; j < boardWeigth; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'U')
                    board[i][j] = 'O';
            }
        }
    }

    private void markNotCaptured(char[][]board, int x, int y){
        if(x < 0 || x >= board.length ||
                y < 0 || y >= board[0].length ||
                board[x][y] == 'X' || board[x][y] == 'U')
            return;
        board[x][y] = 'U';
        markNotCaptured(board, x - 1, y);
        markNotCaptured(board, x + 1, y);
        markNotCaptured(board, x, y - 1);
        markNotCaptured(board, x, y + 1);
    }
}