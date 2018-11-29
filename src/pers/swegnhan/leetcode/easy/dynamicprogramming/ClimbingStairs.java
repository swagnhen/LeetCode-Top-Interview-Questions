package pers.swegnhan.leetcode.easy.dynamicprogramming;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairsPlus(int n){
        if(n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        int n0 = 0, n1 = 2, n2 = 1;
        for(int i = 3; i <= n; i++){
            n0 = n1 + n2;
            n2 = n1;
            n1 = n0;
        }
        return n0;
    }

    public static void main(String[] args){
        System.out.println(climbStairsPlus(44));
    }

}
