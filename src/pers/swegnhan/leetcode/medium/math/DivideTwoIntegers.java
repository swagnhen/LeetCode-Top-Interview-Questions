package pers.swegnhan.leetcode.medium.math;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        boolean pon = (dividend ^ divisor) >= 0;
        if(dividend > 0)
            dividend = -dividend;
        if(divisor > 0)
            divisor = -divisor;
        int count = 0, sum = 0;
        while(dividend - sum <= divisor){
            sum += divisor;
            count++;
        }
        if(pon)
            return count;
        else
            return -count;
    }

    public static int dividePlus(int dividend, int divisor){
        boolean pon = (dividend ^ divisor) >= 0;
        long dvd = dividend, dvs = divisor;
        if(dvd < 0)
            dvd = -dvd;
        if(dvs < 0)
            dvs = -dvs;
        long dvst = dvs;
        long step = 0, count = 0;
        while(dvd >= (dvst << 1)){
            if(step == 0)
                step += 2;
            else
                step <<= 1;
            dvst <<= 1;
        }
        count += step;
        if(step == 0)
            dvst = 0;
        while(dvd >= dvst + dvs){
            dvst += dvs;
            count++;
        }
        if(!pon)
            count = -count;
        if(count > Integer.MAX_VALUE || count < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        return (int)count;
    }

    public static void main(String[] args){
        System.out.println(dividePlus(-268342466, 2147483647));
    }

}
