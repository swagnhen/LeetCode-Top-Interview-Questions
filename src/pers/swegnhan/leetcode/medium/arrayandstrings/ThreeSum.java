package pers.swegnhan.leetcode.medium.arrayandstrings;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0)
                    k--;
                else if(sum < 0)
                    j++;
                else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                }
            }
        }
        return new LinkedList<>(result);
    }

    public static void main(String[] args){
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}
