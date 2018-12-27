package pers.swegnhan.leetcode.hard.arrayandstrings;

import java.util.*;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int max = 1, length = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1] + 1) {
                length++;
                max = max >= length ? max : length;
            }else if(nums[i] == nums[i - 1])
                continue;
            else
                length = 1;
        }
        return max;
    }

    public static int longestConsecutivePlus(int[] nums){
        int before = 0, after = 0, sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums){
            if(!map.containsKey(num)) {
                before = map.getOrDefault(num - 1, 0);
                after = map.getOrDefault(num + 1, 0);
                sum = before + after + 1;
                map.put(num, sum);
                max = max >= sum ? max : sum;
                map.put(num - before, sum);
                map.put(num + after, sum);
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(longestConsecutivePlus(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

}
