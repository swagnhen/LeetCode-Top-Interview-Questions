package pers.swegnhan.leetcode.easy.strings;

public class ReverseString {

    public static String reverseString(String s) {
        char swap = ' ';
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length() / 2; i++){
            swap = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(sb.length() - 1 - i));
            sb.setCharAt(sb.length() - 1 - i, swap);
        }
        s = new String(sb);
        return s;
    }

    public static void main(String[] args){
        System.out.println(reverseString("amanaP :lanac a ,nalp a ,nam A"));
    }

}
