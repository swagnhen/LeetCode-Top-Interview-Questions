package pers.swegnhan.leetcode.medium.math;

public class ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        char[] input = s.toCharArray();
        int result = 0;
        for(char inputc : input) {
            result *= 26;
            result += inputc - 'A' + 1;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(titleToNumber("AB"));
    }

}
