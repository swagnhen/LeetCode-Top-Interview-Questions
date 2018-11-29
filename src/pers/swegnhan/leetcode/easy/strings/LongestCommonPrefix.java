package pers.swegnhan.leetcode.easy.strings;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        char[] sample = strs[0].toCharArray();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++)
            min = Math.min(min, strs[i].length());
        int i = 0;
        for(; i < min; i++) {
            int j = 1;
            for (; j < strs.length; j++){
                if(sample[i] != strs[j].charAt(i))
                    break;
            }
            if(j != strs.length)
                break;
        }
        return strs[0].substring(0, i);
    }

    public static void main(String[] args){
        String[] ss = {"as", "a"};
        System.out.println(longestCommonPrefix(ss));
    }

}
