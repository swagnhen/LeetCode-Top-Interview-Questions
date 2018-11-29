package pers.swegnhan.leetcode.easy.others;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += i - nums[i];
        sum += nums.length;
        return sum;
    }

}
