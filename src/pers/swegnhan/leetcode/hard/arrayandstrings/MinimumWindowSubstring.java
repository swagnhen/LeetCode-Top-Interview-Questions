package pers.swegnhan.leetcode.hard.arrayandstrings;

import java.util.*;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        for(char c : ct)
            map.put(c, new HashSet<>());
        for(int i = 0; i < cs.length; i++){
            if(map.containsKey(cs[i]))
                map.get(cs[i]).add(i);
        }
    }

}
