package pers.swegnhan.leetcode.medium.math;

import java.util.*;

public class HappyNumber {

    public static boolean isHappy(int n) {
        char[] tempc;
        boolean hasOne = false;
        long templ = n,  sum = 0;
        Set<Long> set = new HashSet<>();
        while(!set.contains(sum) && sum != 1){
            set.add(sum);
            sum = 0;
            tempc = Long.toString(templ).toCharArray();
            for(int i = 0; i < tempc.length; i++) {
                sum += (tempc[i] - '0') * (tempc[i] - '0');
            }
            templ = sum;
        }
        if(sum == 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        System.out.println(isHappy(2));
    }

}
