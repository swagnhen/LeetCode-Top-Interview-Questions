package pers.swegnhan.leetcode.hard.arrayandstrings;

import java.util.Arrays;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int minPositive = 1;
        for(int num : nums){
            if(num == minPositive)
                minPositive++;
            else if(num > 0 && num > minPositive)
                return minPositive;
        }
        return minPositive;
    }

    public static int firstMissingPositivePlus(int[] nums) {
        if(nums.length == 0)
            return 1;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] - 1 < nums.length && nums[i] - 1 >= 0 && nums[i] - 1 != i && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(i != nums[i] - 1)
                return i + 1;
        }
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args){
        System.out.println(firstMissingPositivePlus(new int[]{3,4,-1,1}));
    }

}
