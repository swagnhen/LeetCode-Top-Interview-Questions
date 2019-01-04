package pers.swegnhan.leetcode.hard.arrayandstrings;

import java.util.*;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0)
            return "";
        boolean hasSuitWindow = false;
        int start = 0, head = 0, length = Integer.MAX_VALUE, counter = t.length();
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        for(char c : ct)
            map.put(c, map.getOrDefault(c, 0) + 1);
        for(int i = 0; i < cs.length; i++){
            if(map.containsKey(cs[i])){
                map.put(cs[i], map.get(cs[i]) - 1);
                if(map.get(cs[i]) >= 0)
                    counter--;
            }
            while(counter <= 0){
                hasSuitWindow = true;
                if(i - start <= length){
                    head = start;
                    length = i - start;
                }
                if(map.containsKey(cs[start])){
                    map.put(cs[start], map.get(cs[start]) + 1);
                    if(map.get(cs[start]) > 0)
                        counter++;
                }
                start++;
            }
        }
        if(!hasSuitWindow)
            return "";
        return s.substring(head, head + length + 1);
    }

    public static void main(String[] args){
        System.out.println(minWindow("acbbaca","aba"));
    }
}
