package pers.swegnhan.leetcode.hard.arrayandstrings;

import java.util.Arrays;

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

    public static void main(String[] args){
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

}
