package pers.swegnhan.leetcode.easy.design;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

    private int[] nums;

    public ShuffleAnArray(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
    }

    private static void swapUnsafe(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOf(nums, nums.length);
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums.length <= 1)
            return Arrays.copyOf(nums, nums.length);
        int[] shuffleNums = Arrays.copyOf(nums, nums.length);
        Random random = new Random();
        for(int i = 0; i < shuffleNums.length; i++)
            swapUnsafe(shuffleNums, i, Math.abs(random.nextInt(i + 1)));
        return shuffleNums;
    }

    public static void main(String[] args){
        int[] test = new int[]{1,2,3,4,5};
        ShuffleAnArray obj = new ShuffleAnArray(test);
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();
        swapUnsafe(param_2, 3, 4);
        System.out.println("end");
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */