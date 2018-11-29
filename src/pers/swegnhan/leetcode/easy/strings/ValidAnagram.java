package pers.swegnhan.leetcode.easy.strings;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] smap = new int[256], tmap = new int[256];
        for(int i = 0; i < 256; i++){
            smap[i] = 0;
            tmap[i] = 0;
        }
        for(int i = 0; i < s.length(); i++){
            smap[s.charAt(i)]++;
            tmap[t.charAt(i)]++;
        }
        for(int i = 0; i < 256; i++){
            if(smap[i] != tmap[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isAnagram("rat", "car"));
    }

}
