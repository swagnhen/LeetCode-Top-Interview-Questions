package pers.swegnhan.leetcode.easy.array;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            int[] sign = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.') {
                    if (sign[board[i][j] - '1'] == 1)
                        return false;
                    sign[board[i][j] - '1']++;
                }
            }
        }
        for(int i = 0; i < 9; i++){
            int[] sign = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.') {
                    if (sign[board[j][i] - '1'] == 1)
                        return false;
                    sign[board[j][i] - '1']++;
                }
            }
        }
        for(int i = 0; i < 9; i++){
            int[] sign = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            for(int j = (i / 3) * 3; j < (i / 3) * 3 + 3; j++)
                for(int k = (i % 3) * 3; k < (i % 3) * 3 + 3; k++) {
                    if(board[j][k] != '.') {
                        if (sign[board[j][k] - '1'] == 1)
                            return false;
                        sign[board[j][k] - '1']++;
                    }
                }
        }
        return true;
    }

    public static void main(String[] args){
        char[][] test1 = new char[][] {
                new char[] {'5','3','.','.','7','.','.','.','.'},
                new char[] {'6','.','.','1','9','5','.','.','.'},
                new char[] {'.','9','8','.','.','.','.','6','.'},
                new char[] {'8','.','.','.','6','.','.','.','3'},
                new char[] {'4','.','.','8','.','3','.','.','1'},
                new char[] {'7','.','.','.','2','.','.','.','6'},
                new char[] {'.','6','.','.','.','.','2','8','.'},
                new char[] {'.','.','.','4','1','9','.','.','5'},
                new char[] {'.','.','.','.','8','.','.','7','9'}
        };
        char[][] test2 = new char[][] {
                new char[] {'8','3','.','.','7','.','.','.','.'},
                new char[] {'6','.','.','1','9','5','.','.','.'},
                new char[] {'.','9','8','.','.','.','.','6','.'},
                new char[] {'8','.','.','.','6','.','.','.','3'},
                new char[] {'4','.','.','8','.','3','.','.','1'},
                new char[] {'7','.','.','.','2','.','.','.','6'},
                new char[] {'.','6','.','.','.','.','2','8','.'},
                new char[] {'.','.','.','4','1','9','.','.','5'},
                new char[] {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("" + isValidSudoku(test1) + isValidSudoku(test2));
    }

}
