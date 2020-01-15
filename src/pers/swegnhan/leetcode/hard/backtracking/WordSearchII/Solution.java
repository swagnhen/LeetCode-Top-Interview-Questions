package pers.swegnhan.leetcode.hard.backtracking.WordSearchII;

import java.util.*;

public class Solution {

    public boolean step(char[][]board, int x, int y, boolean[][] hasVisited, String word, int pos){
        if(pos == word.length())
            return true;
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || word.charAt(pos) != board[x][y] || hasVisited[x][y])
            return false;
        hasVisited[x][y] = true;
        if(step(board, x + 1, y, hasVisited, word, pos + 1) ||
                step(board, x - 1, y, hasVisited, word, pos + 1) ||
                step(board, x, y + 1, hasVisited, word, pos + 1) ||
                step(board, x, y - 1, hasVisited, word, pos + 1))
            return true;
        hasVisited[x][y] = false;
        return false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        if(board.length == 0)
            return result;
        boolean[][] hasVisited = new boolean[board.length][board[0].length];
        for(String word : words){
            for(int i = 0; i < board.length; i++)
                for(int j = 0; j < board[i].length; j++)
                    hasVisited[i][j] = false;
            boolean loop = true;
            for(int i = 0; i < board.length && loop; i++) {
                for (int j = 0; j < board[i].length && loop; j++) {
                    if (step(board, i, j, hasVisited, word, 0)) {
                        result.add(word);
                        loop = false;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
              {'a','a'}
        };
        String[] words = new String[]{"aa"};
        System.out.println(solution.findWords(board, words));
    }

}
