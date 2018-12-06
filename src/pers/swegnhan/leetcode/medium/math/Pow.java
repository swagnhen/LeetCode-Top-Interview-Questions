package pers.swegnhan.leetcode.medium.math;

public class Pow {

    public static double myPow(double x, int n) {
        if(x == -1){
            if(n % 2 == 0)
                return 1;
            else
                return -1;
        }
        if(x == 1.0 || n == 0)
            return 1;
        long n_ = n;
        if(n < 0) {
            n_ *= -1;
            x = 1.0 / x;
        }
        double result = 1;
        for(int i = 0; i < n_; i++) {
            result *= x;
            if(result == 0.0)
                return 0.0;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(myPow(2.00000, -2147483648));
    }

}
