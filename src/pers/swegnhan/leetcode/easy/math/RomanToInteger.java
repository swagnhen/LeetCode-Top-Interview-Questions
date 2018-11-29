package pers.swegnhan.leetcode.easy.math;

public class RomanToInteger {

    public static int romanToInt(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case 'I':
                    if(i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))
                        break;
                    else
                        result += 1;
                    break;
                case 'V':
                    if(i - 1 >= 0 && s.charAt(i - 1) == 'I')
                        result += 4;
                    else
                        result += 5;
                    break;
                case 'X':
                    if(i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
                        break;
                    else if(i - 1 >= 0 && s.charAt(i - 1) == 'I')
                        result += 9;
                    else
                        result += 10;
                    break;
                case 'L':
                    if(i - 1 >= 0 && s.charAt(i - 1) == 'X')
                        result += 40;
                    else
                        result += 50;
                    break;
                case 'C':
                    if(i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'))
                        break;
                    else if(i - 1 >= 0 && s.charAt(i - 1) == 'X')
                        result += 90;
                    else
                        result += 100;
                    break;
                case 'D':
                    if(i - 1 >= 0 && s.charAt(i - 1) == 'C')
                        result += 400;
                    else
                        result += 500;
                    break;
                case 'M':
                    if(i - 1 >= 0 && s.charAt(i - 1) == 'C')
                        result += 900;
                    else
                        result += 1000;
                    break;
                default:
                    return -1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(romanToInt("MCMXCIV"));
    }

}
