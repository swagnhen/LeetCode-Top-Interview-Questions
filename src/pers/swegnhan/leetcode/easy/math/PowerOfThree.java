package pers.swegnhan.leetcode.easy.math;

public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        long temp = 1, step = 3;
        while(n > temp){
            if(temp * step > n && temp * 3 <= n)
                temp *= 3;
            else{
                temp *= step;
                step *= 3;
            }
        }
        if(n == temp)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        isPowerOfThree(387420489);
    }

}
