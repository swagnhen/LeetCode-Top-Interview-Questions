package pers.swegnhan.leetcode.easy.sortingandsearching;

import java.util.Random;

public class FirstBadVersion {

    private static int badVersion;

    static {
        Random random = new Random();
        badVersion = Math.abs(random.nextInt()%10);
    }

    public static boolean isBadVersion(int n){
        if (n >= 1702766719)
            return true;
        return false;
    }

    public static int firstBadVersion(int n) {
        return firstBadVersionStep(1, n);
    }

    public static int firstBadVersionStep(long start, long end){
        if(start >= end){
            int target = (int)start;
            if(isBadVersion(target) == false){
                while(isBadVersion(target) == false)
                    target++;
                return target;
            }
            else{
                while(isBadVersion(target) == true)
                    target--;
                return target + 1;
            }
        }
        else if(isBadVersion((int)((start + end) / 2)) == false)
            return firstBadVersionStep((start + end) / 2 + 1, end);
        else
            return firstBadVersionStep(start, ((start + end) / 2) - 1);
    }

    public static void main(String[] args){
        int test = firstBadVersion(2126753390);
        System.out.println("end");
    }

}
