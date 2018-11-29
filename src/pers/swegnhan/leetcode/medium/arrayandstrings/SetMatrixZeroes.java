package pers.swegnhan.leetcode.medium.arrayandstrings;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        if(matrix.length == 0)
            return;
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j ++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for(int i = 0; i < row.length; i++)
            if(row[i] == true)
                for(int j = 0; j < column.length; j++)
                    matrix[i][j] = 0;
        for(int i = 0; i < column.length; i++)
            if(column[i] == true)
                for(int j = 0; j < row.length; j++)
                    matrix[j][i] = 0;
    }

    public static void setZeroesPlus(int[][] matrix){
        if(matrix.length == 0)
            return;
        boolean firstrow = false, fistcolumn = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j ++){
                if(matrix[i][j] == 0){
                    if(i == 0)
                        firstrow = true;
                    if(j == 0)
                        fistcolumn = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(firstrow == true)
            for(int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        if(fistcolumn == true)
            for(int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        int[][] test = {
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
        };
        setZeroesPlus(test);
        for(int i = 0; i < test.length; i++){
            for(int j = 0; j < test[0].length; j++)
                System.out.print(test[i][j]);
            System.out.println();
        }
    }

}
