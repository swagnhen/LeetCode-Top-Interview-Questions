package pers.swegnhan.leetcode.medium.dynamicprogramming;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        m--; n--;
        double result = 1;
        for(int i = m + n; i > m; i--)
            result = (result * i) / (i - m);
        return (int)Math.round(result);
    }

    public static void main(String[] args){
        System.out.println(uniquePaths(3, 7));
    }

}
