package pers.swegnhan.leetcode.easy.strings;

public class ReverseInteger {

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        char swap = ' ';
        if(x >= 0) {
            for (int i = 0; i < sb.length() / 2; i++) {
                swap = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(sb.length() - 1 - i));
                sb.setCharAt(sb.length() - 1 - i, swap);
            }
        }
        else {
            for (int i = 1; i <= sb.length() / 2; i++) {
                swap = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(sb.length() - i));
                sb.setCharAt(sb.length() - i, swap);
            }
        }
        long l = Long.valueOf(sb.toString());
        if(l > Integer.MAX_VALUE || l < Integer.MIN_VALUE)
            return 0;
        else
            return (int)l;
    }

    public static void main(String[] args){
        System.out.println(reverse(-65535));
    }

}
