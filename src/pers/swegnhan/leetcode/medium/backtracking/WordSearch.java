package pers.swegnhan.leetcode.medium.backtracking;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        boolean result = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(!result && board[i][j] == word.charAt(0)) {
                    boolean[][] trace = new boolean[board.length][board[0].length];
                    result = result || existStep(trace, board, word, 0, i, j);
                }
            }
        }
        return result;
    }

    public static boolean existStep(boolean[][] trace, char[][] board, String word, int pos, int i, int j) {
        if (pos == word.length())
            return true;
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == word.charAt(pos) && !trace[i][j]) {
            trace[i][j] = true;
            boolean result =  existStep(trace, board, word, pos + 1, i + 1, j)
                    || existStep(trace, board, word, pos + 1, i - 1, j)
                    || existStep(trace, board, word, pos + 1, i, j + 1)
                    || existStep(trace, board, word, pos + 1, i, j - 1);
            trace[i][j] = false;
            return result;
        } else
            return false;
    }

    public static void main(String[] args){
        char[][] testBoard = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        String testWord = "ABCESEEEFS";
        System.out.println(exist(testBoard, testWord));
    }

}
