package pers.swegnhan.leetcode.medium.sortingandsearching;

public class SearchA2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        if(matrix[0].length == 0)
            return false;
        return searchMatrixStep(matrix, target, 0, 0);
    }

    public static boolean searchMatrixStep(int[][] matrix, int target, int row, int col){
        if(row >= matrix.length || col >= matrix[0].length)
            return false;
        if(matrix[row][col] == target)
            return true;
        else if(matrix[row][col] < target)
            return searchMatrixStep(matrix, target, row + 1, col) || searchMatrixStep(matrix, target, row, col + 1);
        else
            return false;
    }

    public static boolean searchMatrixPlus(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        if(matrix[0].length == 0)
            return false;
        return searchMatrixPlusStep(matrix, target, 0, matrix[0].length - 1);
    }

    public static boolean searchMatrixPlusStep(int[][] matrix, int target, int row, int col){
        if(row >= matrix.length || col < 0)
            return false;
        if(matrix[row][col] == target)
            return true;
        else if(matrix[row][col] < target)
            return searchMatrixPlusStep(matrix, target, row + 1, col);
        else
            return searchMatrixPlusStep(matrix, target, row, col - 1);
    }

    public static void main(String[] args){

    }

}
