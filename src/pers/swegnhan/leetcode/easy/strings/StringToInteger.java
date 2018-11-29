package pers.swegnhan.leetcode.easy.strings;

public class StringToInteger {

    public static int myAtoi(String str) {
        int p = 0;
        int flag = 1;
        long sum = 0;
        while(p < str.length() && str.charAt(p) == ' ') p++;
        if(p == str.length())
            return 0;
        if(str.charAt(p) == '+')
            p++;
        else if(str.charAt(p) == '-'){
            flag = -1;
            p++;
        }
        while(p < str.length() && str.charAt(p) >='0' && str.charAt(p) <= '9'){
            sum *= 10;
            sum += str.charAt(p) - '0';
            if(sum * flag >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(sum * flag <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            p++;
        }
        sum *= flag;
        return (int)sum;
    }

    public static void main(String[] args){
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("91283472332"));
    }

}
