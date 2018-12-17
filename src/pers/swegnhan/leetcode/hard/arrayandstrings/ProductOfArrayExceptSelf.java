package pers.swegnhan.leetcode.hard.arrayandstrings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < result.length; i++)
            result[i] = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < result.length; j++){
                if(j != i)
                    result[j] *= nums[i];
            }
        }
        return result;
    }

    public static int[] productExceptSelfPlus(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return nums;
        int left = 1, right = 1;
        int[] result = new int[nums.length];
        for(int i = 0; i < result.length; i++)
            result[i] = 1;
        for(int i = 1; i < nums.length; i++) {
            result[i] *= left * nums[i - 1];
            left *= nums[i - 1];
        }
        for(int i = nums.length - 2; i >=0; i--){
            result[i] *= right * nums[i + 1];
            right *= nums[i + 1];
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(Arrays.stream(productExceptSelfPlus(new int[]{1,2,3,4})).boxed().collect(Collectors.toList()));
    }

}
