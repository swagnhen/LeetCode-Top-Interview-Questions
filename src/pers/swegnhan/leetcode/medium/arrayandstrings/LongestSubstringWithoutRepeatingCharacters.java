package pers.swegnhan.leetcode.medium.arrayandstrings;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        char[] input = s.toCharArray();
        int max = 0;
        for(int i = 0; i < input.length; i++){
            int length = 0;
            Set<Character> set = new HashSet();
            for(int j = i; j < input.length; j++){
                if(set.contains(input[j]) == true)
                    break;
                length++;
                set.add(input[j]);
                max = max > length ? max : length;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstringPlus(String s) {
        char[] input = s.toCharArray();
        int max = 0;
        int start = -1;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < input.length; i++){
            if (map.containsKey(input[i]))
                start = start > map.get(input[i]) ? start : map.get(input[i]);
            map.put(input[i], i);
            max = Math.max(max, i - start);
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstringPlus("abcabcbb"));
    }

}
