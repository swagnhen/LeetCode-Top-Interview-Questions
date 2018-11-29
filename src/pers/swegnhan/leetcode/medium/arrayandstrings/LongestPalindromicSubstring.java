package pers.swegnhan.leetcode.medium.arrayandstrings;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if(s.isEmpty())
            return "";
        char[] input = s.toCharArray();
        int position = -1, max = -1;
        char SOrD = 'S';
        for(int i = 0; i < input.length; i++){
            int lengthS = 0, lengthD = -1;
            for(int j = 1;  i - j >= 0 && i + j < input.length; j++){
                if(input[i - j] != input[i + j])
                    break;
                lengthS++;
            }
            if(i + 1 < input.length && input[i] == input[i + 1]){
                lengthD = 0;
                for(int j = 1; i - j >= 0 && i + j + 1 < input.length; j++){
                    if(input[i - j] != input[i + j + 1])
                        break;
                    lengthD++;
                }
            }
            if(lengthD >= max){
                max = lengthD;
                position = i;
                SOrD  = 'D';
            }
            if(lengthS > max){
                max = lengthS;
                position = i;
                SOrD = 'S';
            }
        }
        String result = null;
        if(SOrD == 'S')
            result = s.substring(position - max, position + max + 1);
        else
            result = s.substring(position - max, position + max + 2);
        return result;
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome(""));
    }

}
