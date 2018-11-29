package pers.swegnhan.leetcode.medium.backtracking;

import java.util.*;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        subsetsStep(result, new LinkedList<>(), nums, 0);
        return result;
    }

    public static void subsetsStep(List<List<Integer>> result, List<Integer> step, int[] nums, int start) {
        if(start == nums.length){
            result.add(step);
            return;
        }
        LinkedList<Integer> sub1 = new LinkedList<>(step);
        LinkedList<Integer> sub2 = new LinkedList<>(step);
        sub2.add(nums[start]);
        subsetsStep(result, sub1, nums, start + 1);
        subsetsStep(result, sub2, nums, start + 1);
    }

    public static void main(String[] args){
        System.out.println(subsets(new int[]{1,2,3}));
    }

}
