package pers.swegnhan.leetcode.medium.backtracking;

import java.util.*;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permuteStep(result, nums, new ArrayList<>(), nums.length);
        return result;
    }

    public static void permuteStep(List<List<Integer>> result, int[] nums, ArrayList<Integer> resultStep, int length){
        if(resultStep.size() == length){
            result.add(resultStep);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            ArrayList<Integer> temp = new ArrayList<>(resultStep);
            temp.add(nums[i]);
            permuteStep(result, exportNums(nums, i), temp, length);
        }
    }

    public static int[] exportNums(int[] nums, int n){
        if(nums.length == 1)
            return null;
        int[] result = new int[nums.length - 1];
        for(int i = 0; i < n; i++)
            result[i] = nums[i];
        for(int i = n + 1; i <nums.length; i++)
            result[i - 1] = nums[i];
        return result;
    }

    public static void main(String[] args){
        System.out.println(permute(new int[]{1,2,3}));
    }

}
