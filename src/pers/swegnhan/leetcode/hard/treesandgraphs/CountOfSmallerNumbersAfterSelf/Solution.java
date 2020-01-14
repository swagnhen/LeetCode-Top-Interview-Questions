package pers.swegnhan.leetcode.hard.treesandgraphs.CountOfSmallerNumbersAfterSelf;

import java.util.*;

public class Solution {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for(int i  = 0; i < nums.length; i++){
            int count = 0;
            for(int j =  i + 1; j < nums.length; j++){
                if(nums[j] < nums[i])
                    count++;
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {5,2,6,1};
        System.out.println(solution.countSmaller(test1));
    }

}
