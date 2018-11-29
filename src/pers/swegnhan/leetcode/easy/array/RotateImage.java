package pers.swegnhan.leetcode.easy.array;

public class RotateImage {

    public static void rotate(int[][] matrix) {
        int max = matrix.length - 1, temp = 0;
        for(int i = 0; i < max + 1 / 2; i++){
            for(int j = 0; j < max - 2 * i; j++){
                temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[max - i - j][i];
                matrix[max - i - j][i] = matrix[max - i][max - i - j];
                matrix[max - i][max - i - j] = matrix[i + j][max - i];
                matrix[i + j][max - i] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[][] test = {
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        rotate(test);
        System.out.println("end");
    }

}
