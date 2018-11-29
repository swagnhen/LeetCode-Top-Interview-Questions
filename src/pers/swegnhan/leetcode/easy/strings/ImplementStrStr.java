package pers.swegnhan.leetcode.easy.strings;

public class ImplementStrStr {

    public static int[] getNext(String needle){
        int[] next = new int[needle.length()];
        next[0] = -1;
        int k = -1;
        for(int i = 1; i < needle.length(); i++){
            while(k > -1 && needle.charAt(i) != needle.charAt(k + 1)) k = next[k];
            if(needle.charAt(i) == needle.charAt(k + 1)) k++;
            next[i] = k;
        }
        return next;
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        int[] next = getNext(needle);
        int i = 0, j = 0;
        char[] hs = haystack.toCharArray(), nd = needle.toCharArray();
        while(i < haystack.length()){
            if(j == needle.length())
                return i - j;
            if(hs[i] == nd[j]) {
                i++; j++;
            }
            else if (j > 0){
                j = next[j - 1] + 1;
            }
            else
                i++;
        }
        if(j == needle.length())
            return i - j;
        return -1;
    }

    public static void main(String[] args){
        System.out.println("mississippi".indexOf("issip"));
    }

}
