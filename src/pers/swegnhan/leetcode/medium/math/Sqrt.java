package pers.swegnhan.leetcode.medium.math;

public class Sqrt {

    public static int mySqrt(int x) {
        for(long i = 0; i <= x; i++){
            if((i + 1L) * (i + 1L) > x)
                return (int)i;
        }
        return 0;
    }

    public static int mySqrtPlus(int x){
        int start = 0, mid = 0, end = x;
        int prestart = start, preend = end;
        while(start < end){
            mid = (start + end + 1) / 2;
            if(mid > x / mid)
                end = mid;
            else
                start = mid;
            if(prestart == start && preend == end)
                break;
            preend = end;
            prestart = start;
        }
        return mid == 0 || mid == 1 ? mid : mid - 1;
    }

    public static void main(String[] args){
        System.out.println(mySqrtPlus(9));
    }

}
