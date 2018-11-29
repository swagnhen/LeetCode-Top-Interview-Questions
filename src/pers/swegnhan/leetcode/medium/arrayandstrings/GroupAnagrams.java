package pers.swegnhan.leetcode.medium.arrayandstrings;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            int[] feature = new int[26];
            for(int j = 0; j < strs[i].length(); j++)
                feature[strs[i].charAt(j) - 'a']++;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 26; j++)
                sb.append(feature[j]);
            if(!map.containsKey(sb.toString()))
                map.put(sb.toString(), new LinkedList<>());
            map.get(sb.toString()).add(strs[i]);
        }
        List<List<String>> result = new LinkedList<>();
        Iterator<Map.Entry<String, List<String>>> iterable = map.entrySet().iterator();
        while(iterable.hasNext())
            result.add(iterable.next().getValue());
        return result;
    }

    public static void main(String[] args){
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

}
