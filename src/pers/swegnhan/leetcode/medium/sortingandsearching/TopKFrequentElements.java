package pers.swegnhan.leetcode.medium.sortingandsearching;

import java.util.*;

public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        for(int i = 0; i < k; i++){
            int max = Integer.MIN_VALUE;
            Integer maxKey = -1;
            for (Integer key : map.keySet()){
                if(map.get(key) > max){
                    max = map.get(key);
                    maxKey = key;
                }
            }
            map.remove(maxKey);
            result.add(maxKey);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3,3}, 2));
    }

}
