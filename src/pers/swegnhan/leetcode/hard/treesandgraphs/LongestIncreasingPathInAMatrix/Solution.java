package pers.swegnhan.leetcode.hard.treesandgraphs.LongestIncreasingPathInAMatrix;

public class Solution {

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int l = matrix.length, r = matrix[0].length;
        int[][] length = new int[l][r];
        boolean noChange = true;
        for(int i = 0; i < l; i++){
            for(int j = 0; j < r; j++){
                if((i == 0 || matrix[i - 1][j] <= matrix[i][j]) &&
                        (j == 0 || matrix[i][j - 1] <= matrix[i][j]) &&
                        (i == l - 1 || matrix[i + 1][j] <= matrix[i][j]) &&
                        (j == r - 1 || matrix[i][j + 1] <= matrix[i][j]))
                    length[i][j] = 1;
                else
                    noChange = false;
            }
        }
        int max = 1;
        while(!noChange){
            noChange = true;
            for(int i = 0; i < l; i++){
                for(int j = 0; j < r; j++){
                    if(i > 0 && matrix[i - 1][j] > matrix[i][j] && length[i - 1][j] + 1 > length[i][j]){
                        noChange = false;
                        length[i][j] = length[i - 1][j] + 1;
                        max = Math.max(max, length[i][j]);
                    }
                    if(j > 0 && matrix[i][j - 1] > matrix[i][j] && length[i][j - 1] + 1 > length[i][j]){
                        noChange = false;
                        length[i][j] = length[i][j - 1] + 1;
                        max = Math.max(max, length[i][j]);
                    }
                    if(i < l - 1 && matrix[i + 1][j] > matrix[i][j] && length[i + 1][j] + 1 > length[i][j]){
                        noChange = false;
                        length[i][j] = length[i + 1][j] + 1;
                        max = Math.max(max, length[i][j]);
                    }
                    if(j < r - 1 && matrix[i][j + 1] > matrix[i][j] && length[i][j + 1] + 1 > length[i][j]){
                        noChange = false;
                        length[i][j] = length[i][j + 1] + 1;
                        max = Math.max(max, length[i][j]);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][]test1 = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        }, test2 = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        System.out.println(solution.longestIncreasingPath(test1));
        System.out.println(solution.longestIncreasingPath(test2));
    }

}
