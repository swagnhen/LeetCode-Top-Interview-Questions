package pers.swegnhan.leetcode.medium.math;

import java.util.*;

public class FractionToRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        StringBuilder result = new StringBuilder();
        Set<Long> set = new TreeSet();
        long nmrt = numerator, dnmnt = denominator;
        if((nmrt ^ dnmnt) < 0)
            result.append('-');
        if(nmrt < 0)
            nmrt *= -1;
        if(dnmnt < 0)
            dnmnt *= -1;
        result.append(nmrt / dnmnt).append('.');
        long remainder = nmrt % dnmnt;
        while(remainder != 0){
            if(set.contains(remainder)){
                set.clear();
                StringBuilder cycDecimal = new StringBuilder();
                while(remainder != 0){
                    if(set.contains(remainder)){
                        int pos = result.indexOf(cycDecimal.toString());
                        result.insert(pos, '(');
                        result.insert(pos + cycDecimal.length() + 1, ')');
                        return result.substring(0, pos + cycDecimal.length() + 2);
                    }
                    set.add(remainder);
                    remainder *= 10;
                    cycDecimal.append(remainder / dnmnt);
                    remainder = remainder % dnmnt;
                }
            }
            set.add(remainder);
            remainder *= 10;
            result.append(remainder / dnmnt);
            remainder = remainder % dnmnt;
        }
        if(result.charAt(result.length() - 1) == '.')
            result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(fractionToDecimal(1, 90));
    }

}
