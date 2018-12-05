package pers.swegnhan.leetcode.medium.math;

public class FactorialTrailingZeroes {

    public static int trailingZeroes(int n) {
        int count5 = 0;
        long step = 5;
        while(step <= n){
            long countStep = 0;
            while((countStep + 1) * step <= n)
                countStep++;
            step *= 5;
            count5 += countStep;
        }
        return count5;
    }

    public static void main(String[] args){
        System.out.println(trailingZeroes(1808548329));
    }

}
