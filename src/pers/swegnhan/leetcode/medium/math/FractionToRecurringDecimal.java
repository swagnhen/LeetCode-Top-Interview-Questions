package pers.swegnhan.leetcode.medium.math;

import java.util.*;

public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        Set<Integer> set = new TreeSet();
        result.append(numerator / denominator).append('.');
        int remainder = numerator % denominator;
        while(remainder != 0){
            if(set.contains(remainder)){

            }

        }
    }

}
