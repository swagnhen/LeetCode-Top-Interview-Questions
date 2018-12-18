package pers.swegnhan.leetcode.hard.arrayandstrings;

import java.util.*;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new ArrayList<>();
        List<Integer> result = new LinkedList<>();
        int left = 0, right = matrix[0].length, up = 0, down = matrix.length;
        while(left < right && up < down){
            if(left >= right || up >= down)
                break;
            for(int i = left; i < right; i++)
                result.add(matrix[up][i]);
            up++;
            if(left >= right || up >= down)
                break;
            for(int i = up; i < down; i++)
                result.add(matrix[i][right - 1]);
            right--;
            if(left >= right || up >= down)
                break;
            for(int i = right - 1; i >= left; i--)
                result.add(matrix[down - 1][i]);
            down--;
            if(left >= right || up >= down)
                break;
            for(int i = down - 1; i >= up; i--)
                result.add(matrix[i][left]);
            left++;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(spiralOrder(new int[][]{
                {6,7,8},
                {1,2,3}
        }));
    }

}
